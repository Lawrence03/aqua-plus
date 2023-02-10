package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.general.model.Card;
import icu.samnyan.aqua.sega.general.service.CardService;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserDataRepository;
import icu.samnyan.aqua.sega.mai2.handler.BaseHandler;
import icu.samnyan.aqua.sega.mai2.model.response.UserLoginResp;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2UserLoginHandler")
public class UserLoginHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(UserLoginHandler.class);

    private final BasicMapper mapper;

    private final UserDataRepository userDataRepository;
    private final CardService cardService;

    public UserLoginHandler(BasicMapper mapper, UserDataRepository userDataRepository, CardService cardService) {
        this.mapper = mapper;
        this.userDataRepository = userDataRepository;
        this.cardService = cardService;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();
        try {
            Optional<Card> cardOptional = cardService.getCardByExtId(userId);
            if (cardOptional.isEmpty()) {
                if (request.containsKey("accessCode")) {
                    String accessCode = (String) request.get("accessCode");
                    cardService.registerByAccessCode(accessCode, userId);
                }
            }
        } catch (Exception e){

        }


        Optional<UserData> userOptional = userDataRepository.findByCard_ExtId(userId);

        UserLoginResp resp = new UserLoginResp();
        resp.setLoginId(1);
        if (userOptional.isPresent()) {
            var u = userOptional.get();
            resp.setLoginId(100);
            resp.setLoginCount(u.getPlayCount());
            resp.setLastLoginDate(u.getLastLoginDate());
            resp.setConsecutiveLoginCount(u.getPlayCount());
        }

        String json = mapper.write(resp);
        logger.info("Response: " + json);
        return json;
    }
}
