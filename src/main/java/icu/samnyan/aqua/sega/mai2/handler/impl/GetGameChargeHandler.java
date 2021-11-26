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

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetGameChargeHandler")
public class GetGameChargeHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetGameChargeHandler.class);

    private final BasicMapper mapper;

    @Autowired
    public GetGameChargeHandler(BasicMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {

        List<Object> gameChargeList = new ArrayList<>();

        Map<String, Object> chargeItem = new LinkedHashMap<>();
        chargeItem.put("orderId", 1);
		chargeItem.put("chargeId", 2);chargeItem.put("price", 1);
		chargeItem.put("startDate", "2021-01-01 07:00:00.0");chargeItem.put("endDate", "2029-01-01 23:59:59.0");
        gameChargeList.add(chargeItem);
        
        chargeItem = new LinkedHashMap<>();
        chargeItem.put("orderId", 2);
		chargeItem.put("chargeId", 3);chargeItem.put("price", 1);
		chargeItem.put("startDate", "2021-01-01 07:00:00.0");chargeItem.put("endDate", "2029-01-01 23:59:59.0");
        gameChargeList.add(chargeItem);
        
        chargeItem = new LinkedHashMap<>();
        chargeItem.put("orderId", 3);
		chargeItem.put("chargeId", 5);chargeItem.put("price", 1);
		chargeItem.put("startDate", "2021-01-01 07:00:00.0");chargeItem.put("endDate", "2029-01-01 23:59:59.0");
        gameChargeList.add(chargeItem);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("length", 1);
        resultMap.put("gameChargeList", gameChargeList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
