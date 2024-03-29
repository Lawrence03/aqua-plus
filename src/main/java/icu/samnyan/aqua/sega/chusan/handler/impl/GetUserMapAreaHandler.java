package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserMapAreaRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserMapArea;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Handle GetUserMap request
 *
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetUserMapAreaHandler")
public class GetUserMapAreaHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserMapAreaHandler.class);

    private final StringMapper mapper;

    private final UserMapAreaRepository userMapAreaRepository;

    @Autowired
    public GetUserMapAreaHandler(StringMapper mapper, UserMapAreaRepository userMapAreaRepository) {
        this.mapper = mapper;
        this.userMapAreaRepository = userMapAreaRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");

        List<UserMapArea> userMapList = userMapAreaRepository.findAllByUser_Card_ExtId(Long.parseLong(userId));

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", userMapList.size());
        resultMap.put("userMapAreaList", userMapList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
