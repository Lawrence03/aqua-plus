package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserItemRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserItem;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetUserItemHandler")
public class GetUserItemHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserItemHandler.class);

    private final BasicMapper mapper;

    private final UserItemRepository userItemRepository;

    public GetUserItemHandler(BasicMapper mapper, UserItemRepository userItemRepository) {
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
        if (kind == 0xc) {
            ArrayList<Object> userTicketList = new ArrayList<>();
            Map<String, Object> ticketItem = new LinkedHashMap<>();
            ticketItem.put("itemId", 11005);
            ticketItem.put("itemKind", 0xc);
            ticketItem.put("stock", 9);
            ticketItem.put("isValid", true);
            userTicketList.add(ticketItem);
            ticketItem = new LinkedHashMap<>();
            ticketItem.put("itemId", 20020);
            ticketItem.put("itemKind", 0xc);
            ticketItem.put("stock", 9);
            ticketItem.put("isValid", true);
            userTicketList.add(ticketItem);
            resultMap.put("nextIndex", 0);
            resultMap.put("userItemList", userTicketList);
        }

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
