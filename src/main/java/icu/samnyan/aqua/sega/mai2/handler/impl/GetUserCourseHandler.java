package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserCourseRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserCourse;
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
@Component("Mai2GetUserCourseHandler")
public class GetUserCourseHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserCourseHandler.class);

    private final BasicMapper mapper;

    private final UserCourseRepository userCourseRepository;

    public GetUserCourseHandler(BasicMapper mapper, UserCourseRepository userCourseRepository) {
        this.mapper = mapper;
        this.userCourseRepository = userCourseRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        List<UserCourse> userCourseList = userCourseRepository.findByUser_Card_ExtId(userId);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("userCourseList", userCourseList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
