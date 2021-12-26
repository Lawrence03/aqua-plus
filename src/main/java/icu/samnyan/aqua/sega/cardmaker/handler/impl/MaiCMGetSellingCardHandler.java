package icu.samnyan.aqua.sega.cardmaker.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.cardmaker.dao.mai.SellingCardRepository;
import icu.samnyan.aqua.sega.cardmaker.handler.BaseHandler;
import icu.samnyan.aqua.sega.cardmaker.model.mai.SellingCard;
import icu.samnyan.aqua.sega.cardmaker.model.response.data.SellingCardItem;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component("CardmakerMaiCMGetSellingCardHandler")
public class MaiCMGetSellingCardHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(MaiCMGetSellingCardHandler.class);

    private final BasicMapper mapper;
    private final SellingCardRepository sellingCardRepository;

    public MaiCMGetSellingCardHandler(BasicMapper mapper, SellingCardRepository sellingCardRepository){
        this.mapper = mapper;
        this.sellingCardRepository = sellingCardRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        List<SellingCard> sellingCardList = sellingCardRepository.findAll();
        List<SellingCardItem> sellingCard = new ArrayList<>();
        sellingCardList.forEach(x -> sellingCard.add(new SellingCardItem(
                x.getCardId(),
                "2021-01-01 07:00:00.0",
                "2029-12-31 23:59:59.0",
                "2021-01-01 07:00:00.0",
                "2029-12-31 23:59:59.0"
        )));
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("length", sellingCard.size());
        resultMap.put("sellingCardList", sellingCard);
        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
