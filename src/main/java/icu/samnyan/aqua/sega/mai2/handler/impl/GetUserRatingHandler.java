package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserDataRepository;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserGeneralDataRepository;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserUdemaeRepository;
import icu.samnyan.aqua.sega.mai2.model.request.data.UserRate;
import icu.samnyan.aqua.sega.mai2.model.request.data.UserRating;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserGeneralData;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetUserRatingHandler")
public class GetUserRatingHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserRatingHandler.class);

    private final BasicMapper mapper;

    private final UserDataRepository userDataRepository;
    private final UserGeneralDataRepository userGeneralDataRepository;
    private final UserUdemaeRepository userUdemaeRepository;

    public GetUserRatingHandler(BasicMapper mapper, UserDataRepository userDataRepository, UserGeneralDataRepository userGeneralDataRepository, UserUdemaeRepository userUdemaeRepository) {
        this.mapper = mapper;
        this.userDataRepository = userDataRepository;
        this.userGeneralDataRepository = userGeneralDataRepository;
        this.userUdemaeRepository = userUdemaeRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();
        UserData userData = userDataRepository.findByCard_ExtId(userId).orElseThrow();


        UserRating rating = new UserRating();
        rating.setRating(userData.getPlayerRating());
        rating.setRatingList(getList(userGeneralDataRepository.findByUserAndPropertyKey(userData, "rating_list")));
        rating.setNewRatingList(getList(userGeneralDataRepository.findByUserAndPropertyKey(userData, "new_rating_list")));
        rating.setNextRatingList(getList(userGeneralDataRepository.findByUserAndPropertyKey(userData, "next_rating_list")));
        rating.setNextNewRatingList(getList(userGeneralDataRepository.findByUserAndPropertyKey(userData, "next_new_rating_list")));
        userUdemaeRepository.findByUser(userData).ifPresent(rating::setUdemae);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("userRating", rating);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }

    public List<UserRate> getList(Optional<UserGeneralData> userGeneralDataOptional) {
        if(userGeneralDataOptional.isEmpty()) {
            return Collections.emptyList();
        }

        String val = userGeneralDataOptional.get().getPropertyValue();
        if(val.isBlank()) {
            return Collections.emptyList();
        }

        List<UserRate> userRateList = new ArrayList<>();
        String[] elems = val.split(",");
        for(String elem : elems) {
            String[] v = elem.split(":");
            userRateList.add(new UserRate(Integer.parseInt(v[0]), Integer.parseInt(v[1]), 0, Integer.parseInt(v[2])));
        }
        return userRateList;
    }
}
