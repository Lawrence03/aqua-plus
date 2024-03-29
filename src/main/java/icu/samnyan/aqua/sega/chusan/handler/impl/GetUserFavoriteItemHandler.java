package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetUserFavoriteItemHandler")
public class GetUserFavoriteItemHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserFavoriteItemHandler.class);

    private final StringMapper mapper;

    @Autowired
    public GetUserFavoriteItemHandler(StringMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");
        String kind = (String) request.get("kind");

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("kind", kind);
        resultMap.put("length", 0);
        resultMap.put("nextIndex", 0);
        resultMap.put("userFavoriteItemList", new ArrayList<>());

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
