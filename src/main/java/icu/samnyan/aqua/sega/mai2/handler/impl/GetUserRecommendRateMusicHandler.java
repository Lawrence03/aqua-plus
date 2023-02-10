package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component("Mai2GetUserRecommendRateMusicHandler")
public class GetUserRecommendRateMusicHandler implements BaseHandler {
    private static final Logger logger = LoggerFactory.getLogger(GetUserRecommendRateMusicHandler.class);

    private final BasicMapper mapper;

    @Autowired
    public GetUserRecommendRateMusicHandler(BasicMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        Long userId = ( (Number) request.get("userId") ).longValue();

        List<Object> userRecommendRateMusicIdList = new ArrayList<>();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", 0);
        resultMap.put("userRecommendRateMusicIdList", userRecommendRateMusicIdList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
