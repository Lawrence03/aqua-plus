package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserGhostRepository;
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
@Component("Mai2GetUserGhostHandler")
public class GetUserGhostHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserGhostHandler.class);

    private final BasicMapper mapper;

    private final UserGhostRepository userGhostRepository;

    public GetUserGhostHandler(BasicMapper mapper, UserGhostRepository userGhostRepository) {
        this.mapper = mapper;
        this.userGhostRepository = userGhostRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        // Add default ghost later
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("userGhostList", Collections.emptyList());

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
