package icu.samnyan.aqua.sega.cardmaker.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.cardmaker.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component("CardmakerOngekiGetUserGachaHandler")
public class OngekiGetUserGachaHandler implements BaseHandler {
    private static final Logger logger = LoggerFactory.getLogger(OngekiGetUserGachaHandler.class);
    private final BasicMapper mapper;

    @Autowired
    public OngekiGetUserGachaHandler(BasicMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        Long userId = ( (Number) request.get("userId") ).longValue();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", 0);
        resultMap.put("userGachaList", new List[]{});

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        return json;
    }
}
