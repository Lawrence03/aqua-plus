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

@Component("CardmakerOngekiGetUserGachaSupplyHandler")
public class OngekiGetUserGachaSupplyHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(OngekiGetUserGachaSupplyHandler.class);
    private final BasicMapper mapper;

    @Autowired
    public OngekiGetUserGachaSupplyHandler(BasicMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        Long userId = ( (Number) request.get("userId") ).longValue();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("supplyId", 0);
        resultMap.put("length", 0);
        resultMap.put("supplyCardList", new List[]{});

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        return json;
    }
}
