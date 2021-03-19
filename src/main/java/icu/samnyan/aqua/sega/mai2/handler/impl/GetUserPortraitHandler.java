package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserPortraitRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserPortrait;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetUserPortraitHandler")
public class GetUserPortraitHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserPortraitHandler.class);

    private final BasicMapper mapper;

    private final UserPortraitRepository userPortraitRepository;

    public GetUserPortraitHandler(BasicMapper mapper, UserPortraitRepository userPortraitRepository) {
        this.mapper = mapper;
        this.userPortraitRepository = userPortraitRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        int userId = ((Number) request.get("userId")).intValue();

        List<UserPortrait> portraitList = userPortraitRepository.findByUserId(userId);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("userPortraitList", portraitList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
