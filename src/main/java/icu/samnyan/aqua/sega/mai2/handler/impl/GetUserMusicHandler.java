package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserMusicDetailRepository;
import icu.samnyan.aqua.sega.mai2.model.response.data.UserMusic;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserMusicDetail;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
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
@Component("Mai2GetUserMusicHandler")
public class GetUserMusicHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserMusicHandler.class);

    private final BasicMapper mapper;

    private final UserMusicDetailRepository userMusicDetailRepository;

    public GetUserMusicHandler(BasicMapper mapper, UserMusicDetailRepository userMusicDetailRepository) {
        this.mapper = mapper;
        this.userMusicDetailRepository = userMusicDetailRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();
        int nextIndex = ((Number) request.get("nextIndex")).intValue();
        int maxCount = ((Number) request.get("maxCount")).intValue();

        int pageNum = nextIndex / maxCount;

        Page<UserMusicDetail> dbPage = userMusicDetailRepository.findByUser_Card_ExtId(userId, PageRequest.of(pageNum, maxCount));

        long currentIndex = maxCount * pageNum + dbPage.getNumberOfElements();

        List<UserMusic> result = new ArrayList<>();
        result.add(new UserMusic(dbPage.getContent()));

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("nextIndex", dbPage.getNumberOfElements() < maxCount ? 0 : currentIndex);
        resultMap.put("userMusicList", result);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
