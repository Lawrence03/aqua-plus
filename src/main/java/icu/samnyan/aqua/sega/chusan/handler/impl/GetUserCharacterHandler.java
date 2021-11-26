package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserCharacterRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserCharacter;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Handle getUserCharacter request
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetUserCharacterHandler")
public class GetUserCharacterHandler implements BaseHandler {


    private static final Logger logger = LoggerFactory.getLogger(GetUserCharacterHandler.class);

    private final StringMapper mapper;

    private final UserCharacterRepository userCharacterRepository;


    @Autowired
    public GetUserCharacterHandler(StringMapper mapper, UserCharacterRepository userCharacterRepository) {
        this.mapper = mapper;
        this.userCharacterRepository = userCharacterRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");
        int nextIndex = Integer.parseInt((String) request.get("nextIndex"));
        int maxCount = Integer.parseInt((String) request.get("maxCount"));

        int pageNum = nextIndex / maxCount;

        Pageable pageable = PageRequest.of(pageNum, maxCount);
        Page<UserCharacter> dbPage = userCharacterRepository.findByUser_Card_ExtId(Long.parseLong(userId), pageable);

        long currentIndex = maxCount * pageNum + dbPage.getNumberOfElements();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", dbPage.getNumberOfElements());
        resultMap.put("nextIndex", dbPage.getNumberOfElements() < maxCount ? -1 : currentIndex);
        resultMap.put("userCharacterList", dbPage.getContent());

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
