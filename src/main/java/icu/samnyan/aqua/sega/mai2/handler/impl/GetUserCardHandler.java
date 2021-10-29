package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chunithm.model.response.CodeResp;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserCard;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetUserCardHandler")
public class GetUserCardHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserCardHandler.class);

    private final BasicMapper mapper;

    public GetUserCardHandler(BasicMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        String romVersion = (String) request.get("__romVersion");
        int cardId = 1014, charaId = 101, mapId = 1;

        if (romVersion != null) {
            if (romVersion.compareTo("1.17") >= 0 && romVersion.compareTo("1.19") <= 0) {
                cardId = 1501014;
                charaId = 100501;
                mapId = 100005;
            }
            if (romVersion.compareTo("1.20") >= 0 && romVersion.compareTo("1.25") <= 0) {
                cardId = 2001014;
                charaId = 200104;
                mapId = 200001;
            }
        }

        List<Object> userCardList = new ArrayList<>();
        Map<String, Object> cardItem = new LinkedHashMap<>();
        cardItem.put("cardId", cardId);
        cardItem.put("cardTypeId", 4);
        cardItem.put("charaId", charaId);
        cardItem.put("mapId", mapId);
        cardItem.put("startDate", "2021-01-01 07:00:00.0");
        cardItem.put("endDate", "2029-01-01 23:59:59.0");
        userCardList.add(cardItem);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("nextIndex", 0);
        resultMap.put("userCardList", userCardList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
