package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chunithm.model.response.CodeResp;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetUserRegionHandler")
public class GetUserRegionHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserRegionHandler.class);

    private final BasicMapper mapper;

    public GetUserRegionHandler(BasicMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();


        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", 0);
        resultMap.put("userRegionList", Collections.emptyList());

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
