package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserFavoriteRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserFavorite;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetUserFavoriteHandler")
public class GetUserFavoriteHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserFavoriteHandler.class);

    private final BasicMapper mapper;

    private final UserFavoriteRepository userFavoriteRepository;

    public GetUserFavoriteHandler(BasicMapper mapper, UserFavoriteRepository userFavoriteRepository) {
        this.mapper = mapper;
        this.userFavoriteRepository = userFavoriteRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();
        int itemKind = ((Number) request.get("itemKind")).intValue();

        Optional<UserFavorite> userFavorite = userFavoriteRepository.findByUser_Card_ExtIdAndItemKind(userId, itemKind);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        if(userFavorite.isPresent()) {
            resultMap.put("userFavoriteData", userFavorite.get());
        } else {
            resultMap.put("userFavoriteData", null);
        }

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
