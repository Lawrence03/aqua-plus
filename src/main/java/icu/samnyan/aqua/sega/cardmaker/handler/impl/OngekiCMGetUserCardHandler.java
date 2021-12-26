package icu.samnyan.aqua.sega.cardmaker.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.cardmaker.dao.ongeki.UserCardRepository;
import icu.samnyan.aqua.sega.cardmaker.handler.BaseHandler;
import icu.samnyan.aqua.sega.cardmaker.model.ongeki.UserCard;
import icu.samnyan.aqua.sega.cardmaker.model.response.data.UserCardItem;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component("CardmakerOngekiCMGetUserCardHandler")
public class OngekiCMGetUserCardHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(OngekiCMGetUserCardHandler.class);
    private final BasicMapper mapper;

    private final UserCardRepository userCardRepository;

    @Autowired
    public OngekiCMGetUserCardHandler(BasicMapper mapper, UserCardRepository userCardRepository) {
        this.mapper = mapper;
        this.userCardRepository = userCardRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        Integer userId = (Integer) request.get("userId");
        Integer maxCount = (Integer) request.get("maxCount");
        Integer nextIndex = (Integer) request.get("nextIndex");

        int pageNum = nextIndex / maxCount;

        Page<UserCard> dbPage = userCardRepository.findAll(PageRequest.of(pageNum, maxCount));

        long currentIndex = maxCount * pageNum + dbPage.getNumberOfElements();

        List<UserCardItem> userCardList = new ArrayList<>();
        dbPage.forEach(x -> userCardList.add(new UserCardItem(
                x.getCardId(),
                5,
                1,
                70,
                70,
                0,
                1,
                0,
                "2021-01-01 08:00:00.0",
                "2021-01-01 09:00:00.0",
                100000,
                "2021-01-01 07:00:00.0",
                false,
                false
        )));

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", dbPage.getNumberOfElements());
        resultMap.put("nextIndex", dbPage.getNumberOfElements() < maxCount ? -1 : currentIndex);
        resultMap.put("userCardList", userCardList);

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        return json;
    }

}
