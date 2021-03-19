package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserActivityRepository;
import icu.samnyan.aqua.sega.mai2.model.request.data.UserActivityList;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserActivity;
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
@Component("Mai2GetUserActivityHandler")
public class GetUserActivityHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserActivityHandler.class);

    private final BasicMapper mapper;

    private final UserActivityRepository userActivityRepository;

    public GetUserActivityHandler(BasicMapper mapper, UserActivityRepository userActivityRepository) {
        this.mapper = mapper;
        this.userActivityRepository = userActivityRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        List<UserActivity> playList = userActivityRepository.findByUser_Card_ExtIdAndKind(userId, 1);
        List<UserActivity> musicList = userActivityRepository.findByUser_Card_ExtIdAndKind(userId, 2);

        UserActivityList result = new UserActivityList(playList, musicList);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userActivity", result);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
