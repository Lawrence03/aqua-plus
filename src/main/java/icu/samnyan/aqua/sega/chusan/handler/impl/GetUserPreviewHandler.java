package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserCharacterRepository;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserDataRepository;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserGameOptionRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.response.GetUserPreviewResp;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserCharacter;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserData;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserGameOption;
import icu.samnyan.aqua.sega.general.service.ClientSettingService;
import icu.samnyan.aqua.sega.util.VersionUtil;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static icu.samnyan.aqua.sega.util.AquaConst.SERIAL_KEY;

/**
 * The handler for loading basic profile information.
 * <p>
 * return null if no profile exist
 *
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetUserPreviewHandler")
public class GetUserPreviewHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserPreviewHandler.class);

    private final StringMapper mapper;

    private final ClientSettingService clientSettingService;

    private final UserDataRepository userDataRepository;
    private final UserCharacterRepository userCharacterRepository;
    private final UserGameOptionRepository userGameOptionRepository;

    private final boolean overwriteVersion;
    private final String romVersion;
    private final String dataVersion;

    @Autowired
    public GetUserPreviewHandler(StringMapper mapper,
                                 ClientSettingService clientSettingService,
                                 UserDataRepository userDataRepository,
                                 UserCharacterRepository userCharacterRepository,
                                 UserGameOptionRepository userGameOptionRepository,
                                 @Value("${game.chusan.overwrite-version}") boolean overwriteVersion,
                                 @Value("${game.chusan.rom-version}") String romVersion,
                                 @Value("${game.chusan.data-version}") String dataVersion
    ) {
        this.mapper = mapper;
        this.clientSettingService = clientSettingService;
        this.userDataRepository = userDataRepository;
        this.userCharacterRepository = userCharacterRepository;
        this.userGameOptionRepository = userGameOptionRepository;
        this.overwriteVersion = overwriteVersion;
        this.romVersion = romVersion;
        this.dataVersion = dataVersion;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");


        Optional<UserData> userData = userDataRepository.findByCard_ExtId(Long.parseLong(userId));

        if (userData.isEmpty()) {
            return null;
        }


        UserData user = userData.get();

        GetUserPreviewResp resp = new GetUserPreviewResp();
        resp.setUserId(userId);
        resp.setLogin(false);
        resp.setUserName(user.getUserName());
        resp.setUserNameEx(user.getUserNameEx());
        resp.setReincarnationNum(user.getReincarnationNum());
        resp.setLevel(user.getLevel());
        resp.setExp(user.getExp());
        resp.setPlayerRating(user.getPlayerRating());
        resp.setLastGameId(user.getLastGameId());
        resp.setClassEmblemBase(user.getClassEmblemBase());
        resp.setClassEmblemMedal(user.getClassEmblemMedal());
        resp.setBattleRankId(user.getBattleRankId());

        var vo = clientSettingService.getSetting((String) request.get(SERIAL_KEY));
        if (vo.isPresent()) {
            var version = vo.get();
            resp.setLastRomVersion(VersionUtil.getTargetVersion(user.getLastRomVersion(), version.getRomVersion()));
            resp.setLastDataVersion(VersionUtil.getTargetVersion(user.getLastDataVersion(), version.getDataVersion()));
        } else {
            resp.setLastRomVersion(user.getLastRomVersion());
            resp.setLastDataVersion(user.getLastDataVersion());
        }

        resp.setLastPlayDate(user.getLastPlayDate());
        resp.setTrophyId(user.getTrophyId());

        Optional<UserCharacter> userCharacterOptional = userCharacterRepository.
                findTopByUserAndCharacterIdOrderByIdDesc(user, user.getCharacterId());
        userCharacterOptional.ifPresent(resp::setUserCharacter);

        Optional<UserGameOption> userGameOptionOptional = userGameOptionRepository.findByUser(user);
        userGameOptionOptional.ifPresent(userGameOption -> {
            resp.setPlayerLevel(userGameOption.getPlayerLevel());
            resp.setRating(userGameOption.getRating());
            resp.setHeadphone(userGameOption.getHeadphone());
        });

        resp.setChargeState(1);
        resp.setEmoneyBrandId(0);

        String json = mapper.write(resp);
        logger.info("Response: " + json);
        return json;

    }
}
