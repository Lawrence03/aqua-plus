package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserDataRepository;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserOptionRepository;
import icu.samnyan.aqua.sega.mai2.handler.BaseHandler;
import icu.samnyan.aqua.sega.mai2.model.response.GetUserPreviewResp;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetUserPreviewHandler")
public class GetUserPreviewHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserPreviewHandler.class);

    private final BasicMapper mapper;

    private final UserDataRepository userDataRepository;
    private final UserOptionRepository userOptionRepository;

    @Autowired
    public GetUserPreviewHandler(BasicMapper mapper, UserDataRepository userDataRepository, UserOptionRepository userOptionRepository) {
        this.mapper = mapper;
        this.userDataRepository = userDataRepository;
        this.userOptionRepository = userOptionRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        Optional<UserData> userDataOptional = userDataRepository.findByCard_ExtId(userId);

        GetUserPreviewResp resp = new GetUserPreviewResp();
        resp.setUserId(userId);

        // Add a username check since the user will be created in login request but somehow not complete the saving process.
        if(userDataOptional.isPresent() && userDataOptional.get().getUserName() != null) {
            UserData user = userDataOptional.get();
            resp.setUserName(user.getUserName());
            resp.setLastGameId(user.getLastGameId());
            resp.setLastDataVersion(user.getLastDataVersion());
            resp.setLastRomVersion(user.getLastRomVersion());
            resp.setLastLoginDate(user.getLastLoginDate());
            resp.setLastPlayDate(user.getLastPlayDate());
            resp.setPlayerRating(user.getPlayerRating());
            resp.setNameplateId(user.getPlateId());
            resp.setIconId(user.getIconId());

            userOptionRepository.findByUser(user).ifPresent(option -> {
                resp.setDispRate(option.getDispRate());
            });
            resp.setTotalAwake(user.getTotalAwake());
            resp.setIsNetMember(2);
            resp.setDailyBonusDate(resp.getLastPlayDate());
            resp.setHeadPhoneVolume(resp.getHeadPhoneVolume());
            resp.setBanState(user.getBanState());
        }

        String json = mapper.write(resp);
        logger.info("Response: " + json);
        return json;
    }
}
