package icu.samnyan.aqua.sega.cardmaker.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.cardmaker.handler.BaseHandler;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserItemRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserItem;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Component("CardmakerMaiCMGetUserItemHandler")
public class MaiCMGetUserItemHandler implements BaseHandler {
    private static final Logger logger = LoggerFactory.getLogger(MaiCMGetUserItemHandler.class);
    private final BasicMapper mapper;

    private final UserItemRepository userItemRepository;

    public MaiCMGetUserItemHandler(BasicMapper mapper, UserItemRepository userItemRepository) {
        this.mapper = mapper;
        this.userItemRepository = userItemRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();
        long nextIndexVal = ((Number) request.get("nextIndex")).longValue();
        int maxCount = ((Number) request.get("maxCount")).intValue();

        long mul = 10000000000L;

        int kind = (int) (nextIndexVal / mul);
        int nextIndex = (int) (nextIndexVal % mul);
        int pageNum = nextIndex / maxCount;

        Page<UserItem> dbPage = userItemRepository.findByUser_Card_ExtIdAndItemKind(userId, kind, PageRequest.of(pageNum, maxCount));

        long currentIndex = kind * mul + maxCount * pageNum + dbPage.getNumberOfElements();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("nextIndex", dbPage.getNumberOfElements() < maxCount ? 0 : currentIndex);
        resultMap.put("itemKind", kind);
        resultMap.put("userItemList", dbPage.getContent());

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
