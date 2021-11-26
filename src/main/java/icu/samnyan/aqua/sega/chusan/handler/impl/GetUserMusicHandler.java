package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserMusicRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.response.data.UserMusicListItem;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserMusic;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import icu.samnyan.aqua.spring.data.OffsetPageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Response:
 *
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetUserMusicHandler")
public class GetUserMusicHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserMusicHandler.class);

    private final StringMapper mapper;

    private final UserMusicRepository userMusicRepository;

    @Autowired
    public GetUserMusicHandler(StringMapper mapper, UserMusicRepository userMusicRepository) {
        this.mapper = mapper;
        this.userMusicRepository = userMusicRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");
        int currentIndex = Integer.parseInt((String) request.get("nextIndex"));
        int maxCount = Integer.parseInt((String) request.get("maxCount"));
        if (currentIndex < 0) {
            currentIndex = 0;
        }

        Page<UserMusic> dbPage = userMusicRepository.findByUser_Card_ExtId(
                Long.parseLong(userId),
                OffsetPageRequest.of(currentIndex, maxCount, Sort.by("musicId"))
        );

        // Convert to result format
        // Result Map
        Map<Integer, UserMusicListItem> userMusicMap = new LinkedHashMap<>();

        dbPage.getContent().forEach(userMusic -> {
            UserMusicListItem list;
            if (userMusicMap.containsKey(userMusic.getMusicId())) {
                list = userMusicMap.get(userMusic.getMusicId());
            } else {
                list = new UserMusicListItem(0, new ArrayList<>());
                userMusicMap.put(userMusic.getMusicId(), list);
            }
            list.getUserMusicDetailList().add(userMusic);
            list.setLength(list.getUserMusicDetailList().size());
        });

        // Remove the last music id if the result length is the same as maxCount,
        // to prevent a music id split across multiple page, which will cause some
        // problem with the game.
        int lastListSize = 0;
        if (dbPage.getNumberOfElements() >= maxCount) {
            // Get last key
            int lastMusicId = userMusicMap.keySet().stream().reduce((a, b) -> b).orElseThrow();
            List<UserMusic> lastList = userMusicMap.get(lastMusicId).getUserMusicDetailList();
            lastListSize = lastList.size();
            // Remove last one from map
            userMusicMap.remove(lastMusicId);
        }

        long nextIndex = currentIndex + dbPage.getNumberOfElements() - lastListSize;

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", userMusicMap.size());
        resultMap.put("nextIndex", dbPage.getNumberOfElements() < maxCount ? -1 : nextIndex);
        resultMap.put("userMusicList", userMusicMap.values());

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
