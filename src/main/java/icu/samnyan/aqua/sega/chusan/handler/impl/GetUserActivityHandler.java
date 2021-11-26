package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserActivityRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserActivity;
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
@Component("C3GetUserActivityHandler")
public class GetUserActivityHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserActivityHandler.class);

    private final StringMapper mapper;

    private final UserActivityRepository userActivityRepository;

    @Autowired
    public GetUserActivityHandler(StringMapper mapper, UserActivityRepository userActivityRepository) {
        this.mapper = mapper;
        this.userActivityRepository = userActivityRepository;
    }


    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");
        String kind = (String) request.get("kind");

        List<UserActivity> userActivityList = userActivityRepository.
                findAllByUser_Card_ExtIdAndKindOrderBySortNumberDesc(
                        Long.parseLong(userId), Integer.parseInt(kind));

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", userActivityList.size());
        resultMap.put("kind", kind);
        resultMap.put("userActivityList", userActivityList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
