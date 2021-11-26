package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserRecentRatingRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserRecentRating;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Return the recent play to calculate rating. Rating base on top 30 songs plus top 10 in recent 30 plays.
 *
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetUserRecentRatingHandler")
public class GetUserRecentRatingHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserRecentRatingHandler.class);

    private final StringMapper mapper;

    private final UserRecentRatingRepository userRecentRatingRepository;

    @Autowired
    public GetUserRecentRatingHandler(StringMapper mapper,
                                      UserRecentRatingRepository userRecentRatingRepository) {
        this.mapper = mapper;
        this.userRecentRatingRepository = userRecentRatingRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");

        List<UserRecentRating> ratingList = userRecentRatingRepository
                .findByUser_Card_ExtIdOrderBySortOrderAsc(Long.parseLong(userId));

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", ratingList.size());
        resultMap.put("userRecentRatingList", ratingList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
