package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserChargeRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserCharge;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetUserChargeHandler")
public class GetUserChargeHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserChargeHandler.class);

    private final BasicMapper mapper;

    private final UserChargeRepository userChargeRepository;

    public GetUserChargeHandler(BasicMapper mapper, UserChargeRepository userChargeRepository) {
        this.mapper = mapper;
        this.userChargeRepository = userChargeRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        List<UserCharge> userChargeList = userChargeRepository.findByUser_Card_ExtId(userId);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("userChargeList", userChargeList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
