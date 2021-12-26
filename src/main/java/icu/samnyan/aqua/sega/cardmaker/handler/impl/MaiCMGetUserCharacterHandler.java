package icu.samnyan.aqua.sega.cardmaker.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.cardmaker.handler.BaseHandler;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserCharacterRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserCharacter;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component("CardmakerMaiCMUserCharacterHandler")
public class MaiCMGetUserCharacterHandler implements BaseHandler {
    private static final Logger logger = LoggerFactory.getLogger(MaiCMGetUserCharacterHandler.class);

    private final BasicMapper mapper;

    private final UserCharacterRepository userCharacterRepository;

    public MaiCMGetUserCharacterHandler(BasicMapper mapper, UserCharacterRepository userCharacterRepository) {
        this.mapper = mapper;
        this.userCharacterRepository = userCharacterRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        List<UserCharacter> userCharacterList = userCharacterRepository.findByUser_Card_ExtId(userId);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("userCharacterList", userCharacterList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
