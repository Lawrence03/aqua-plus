package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserCardRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserCard;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetUserCardHandler")
public class GetUserCardHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserCardHandler.class);

    private final BasicMapper mapper;

    private final UserCardRepository userCardRepository;

    public GetUserCardHandler(BasicMapper mapper, UserCardRepository userCardRepository) {
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
