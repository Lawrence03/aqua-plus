package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserCourseRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserCourse;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Handle GetUserCourse request
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetUserCourseHandler")
public class GetUserCourseHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserCourseHandler.class);

    private final StringMapper mapper;

    private final UserCourseRepository userCourseRepository;

    @Autowired
    public GetUserCourseHandler(StringMapper mapper, UserCourseRepository userCourseRepository) {
        this.mapper = mapper;
        this.userCourseRepository = userCourseRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);

        if(request.containsKey("nextIndex")) {
            int nextIndex = Integer.parseInt((String) request.get("nextIndex"));
            int maxCount = Integer.parseInt((String) request.get("maxCount"));

            int pageNum = nextIndex / maxCount;

            Pageable page = PageRequest.of(pageNum, maxCount);
            Page<UserCourse> dbPage = userCourseRepository.findByUser_Card_ExtId(Long.parseLong(userId), page);

            long currentIndex = maxCount * pageNum + dbPage.getNumberOfElements();

            resultMap.put("length", dbPage.getNumberOfElements());
            resultMap.put("nextIndex", dbPage.getNumberOfElements() < maxCount ? -1 : currentIndex);
            resultMap.put("userCourseList", dbPage.getContent());
        } else {
            List<UserCourse> courseList = userCourseRepository.findByUser_Card_ExtId(Long.parseLong(userId));
            resultMap.put("length", courseList.size());
            resultMap.put("userCourseList", courseList);
        }

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
