package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserPortraitRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserPortrait;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2UploadUserPortraitHandler")
public class UploadUserPortraitHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(UploadUserPortraitHandler.class);

    private final BasicMapper mapper;

    private final UserPortraitRepository userPortraitRepository;

    public UploadUserPortraitHandler(BasicMapper mapper, UserPortraitRepository userPortraitRepository) {
        this.mapper = mapper;
        this.userPortraitRepository = userPortraitRepository;
    }

    @Override
    @Transactional
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        UserPortrait userPortrait = mapper.convert(request.get("userPortrait"), UserPortrait.class);
        if (userPortrait.getDivNumber() == 0){
            userPortraitRepository.deleteAllByUserId(userPortrait.getUserId());
        }
        userPortraitRepository.save(userPortrait);

        String json = "{\"returnCode\":\"1\",\"apiName\":\"UploadUserPortraitApi\"}";
        logger.info("Response: " + json);
        return json;
    }
}
