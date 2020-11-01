package icu.samnyan.aqua.sega.chunithm.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chunithm.handler.BaseHandler;
import icu.samnyan.aqua.sega.chunithm.model.response.GetUserPreviewResp;
import icu.samnyan.aqua.sega.chunithm.model.userdata.UserCharacter;
import icu.samnyan.aqua.sega.chunithm.model.userdata.UserData;
import icu.samnyan.aqua.sega.chunithm.model.userdata.UserDataEx;
import icu.samnyan.aqua.sega.chunithm.model.userdata.UserGameOption;
import icu.samnyan.aqua.sega.chunithm.service.UserCharacterService;
import icu.samnyan.aqua.sega.chunithm.service.UserDataService;
import icu.samnyan.aqua.sega.chunithm.service.UserDataExService;
import icu.samnyan.aqua.sega.chunithm.service.UserGameOptionService;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * The handler for loading basic profile information.
 * <p>
 * return null if no profile exist
 *
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component
public class GetUserPreviewHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserPreviewHandler.class);

    private final StringMapper mapper;

    private final UserDataService userDataService;
    private final UserCharacterService userCharacterService;
    private final UserDataExService userDataExService;
    private final UserGameOptionService userGameOptionService;

    private final boolean overwriteVersion;
    private final String romVersion;
    private final String dataVersion;

    @Autowired
    public GetUserPreviewHandler(StringMapper mapper,
                                 UserDataService userDataService,
                                 UserCharacterService userCharacterService,
                                 UserDataExService userDataExService,
                                 UserGameOptionService userGameOptionService,
                                 @Value("${game.chunithm.overwrite-version}") boolean overwriteVersion,
                                 @Value("${game.chunithm.rom-version}") String romVersion,
                                 @Value("${game.chunithm.data-version}") String dataVersion
    ) {
        this.mapper = mapper;
        this.userDataService = userDataService;
        this.userCharacterService = userCharacterService;
        this.userDataExService = userDataExService;
        this.userGameOptionService = userGameOptionService;
        this.overwriteVersion = overwriteVersion;
        this.romVersion = romVersion;
        this.dataVersion = dataVersion;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");


        Optional<UserData> userData = userDataService.getUserByExtId(userId);

        if (userData.isEmpty()) {
            return null;
        }


        UserData user = userData.get();

        GetUserPreviewResp resp = new GetUserPreviewResp();
        resp.setUserId(userId);
        resp.setLogin(false);
        resp.setLastLoginDate(user.getLastLoginDate());
        resp.setUserName(user.getUserName());
        resp.setReincarnationNum(user.getReincarnationNum());
        resp.setLevel(user.getLevel());
        resp.setExp(user.getExp());
        resp.setPlayerRating(user.getPlayerRating());
        resp.setLastGameId(user.getLastGameId());

        resp.setLastRomVersion(user.getLastRomVersion());
        resp.setLastDataVersion(user.getLastDataVersion());

        if (overwriteVersion) {
            resp.setLastRomVersion(romVersion);
            resp.setLastDataVersion(dataVersion);
        }
        resp.setLastPlayDate(user.getLastPlayDate());
        resp.setTrophyId(user.getTrophyId());

        Optional<UserCharacter> userCharacterOptional = userCharacterService.getByUserAndCharacterId(user, user.getCharacterId());
        userCharacterOptional.ifPresent(resp::setUserCharacter);

        Optional<UserGameOption> userGameOptionOptional = userGameOptionService.getByUser(user);
        userGameOptionOptional.ifPresent(userGameOption -> {
            resp.setPlayerLevel(userGameOption.getPlayerLevel());
            resp.setRating(userGameOption.getRating());
            resp.setHeadphone(userGameOption.getHeadphone());
        });

        resp.setChargeState(1);
        Optional<UserDataEx> userDataExOptional = userDataExService.getByUser(user);
        userDataExOptional.ifPresent(userDataEx -> {
            resp.setUserNameEx(userDataEx.getExtStr1());
        });

        String json = mapper.write(resp);
        logger.info("Response: " + json);
        return json;

    }
}
