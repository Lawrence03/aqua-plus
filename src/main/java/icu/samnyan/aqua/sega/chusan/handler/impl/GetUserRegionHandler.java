package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserRegionRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserRegion;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetUserRegionHandler")
public class GetUserRegionHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserRegionHandler.class);

    private final StringMapper mapper;

    private UserRegionRepository userRegionRepository;

    @Autowired
    public GetUserRegionHandler(StringMapper mapper, UserRegionRepository userRegionRepository) {
        this.mapper = mapper;
        this.userRegionRepository = userRegionRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");

        List<UserRegion> userRegionList = userRegionRepository.findByUser_Card_ExtId(Long.parseLong(userId));

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", userRegionList.size());
        resultMap.put("userRegionList", userRegionList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
