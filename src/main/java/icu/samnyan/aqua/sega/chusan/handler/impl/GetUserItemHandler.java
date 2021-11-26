package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserItemRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserItem;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Handler for getting user item.
 * This get call before profile create.
 *
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetUserItemHandler")
public class GetUserItemHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserItemHandler.class);

    private final StringMapper mapper;

    private final UserItemRepository userItemRepository;

    public GetUserItemHandler(StringMapper mapper, UserItemRepository userItemRepository) {
        this.mapper = mapper;
        this.userItemRepository = userItemRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");
        Long nextIndexVal = Long.parseLong((String) request.get("nextIndex"));
        int maxCount = Integer.parseInt((String) request.get("maxCount"));

        Long mul = 10000000000L;

        int kind = (int) (nextIndexVal / mul);
        int nextIndex = (int) (nextIndexVal % mul);
        int pageNum = nextIndex / maxCount;

        Pageable page = PageRequest.of(pageNum, maxCount);
        Page<UserItem> userItemPage = userItemRepository.findAllByUser_Card_ExtIdAndItemKind(Long.parseLong(userId), kind, page);

        List<UserItem> userItemList = userItemPage.getContent();

        long currentIndex = kind * mul + maxCount * pageNum + userItemPage.getNumberOfElements();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", userItemPage.getNumberOfElements());
        resultMap.put("nextIndex", userItemPage.getNumberOfElements() < maxCount ? -1 : currentIndex);
        resultMap.put("itemKind", kind);
        resultMap.put("userItemList", userItemList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;

    }
}
