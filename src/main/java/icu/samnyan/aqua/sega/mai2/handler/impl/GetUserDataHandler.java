package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserDataRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetUserDataHandler")
public class GetUserDataHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserDataHandler.class);

    private final BasicMapper mapper;

    private final UserDataRepository userDataRepository;

    public GetUserDataHandler(BasicMapper mapper, UserDataRepository userDataRepository) {
        this.mapper = mapper;
        this.userDataRepository = userDataRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        UserData userData = userDataRepository.findByCard_ExtId(userId).orElseThrow();
        if(userData.getCharaLockSlot() == null || userData.getCharaLockSlot().isEmpty()) {
            userData.setCharaLockSlot(List.of(0, 0, 0, 0, 0));
        }

        if(userData.getDateTime() == null) {
            userData.setDateTime(0L);
        }

        userData.setIsNetMember(2);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("userData", userData);
        resultMap.put("banState", userData.getBanState());

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
