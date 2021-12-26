package icu.samnyan.aqua.sega.cardmaker.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.cardmaker.handler.BaseHandler;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserCardRepository;
import icu.samnyan.aqua.sega.mai2.handler.impl.GetUserCardHandler;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserCard;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component("CardmakerMaiCMGetUserCardHandler")
public class MaiCMGetUserCardHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(MaiCMGetUserCardHandler.class);

    private final BasicMapper mapper;

    private final UserCardRepository userCardRepository;

    public MaiCMGetUserCardHandler(BasicMapper mapper, UserCardRepository userCardRepository) {
        this.mapper = mapper;
        this.userCardRepository = userCardRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        List<UserCard> userCardList = userCardRepository.findByUser_Card_ExtId(userId);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("nextIndex", 0);
        resultMap.put("userCardList", userCardList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
