package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserDataRepository;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserPlaylogRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserPlaylog;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2UploadUserPlaylogHandler")
public class UploadUserPlaylogHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(UploadUserPlaylogHandler.class);

    private final BasicMapper mapper;

    private final UserDataRepository userDataRepository;
    private final UserPlaylogRepository userPlaylogRepository;

    public UploadUserPlaylogHandler(BasicMapper mapper, UserDataRepository userDataRepository, UserPlaylogRepository userPlaylogRepository) {
        this.mapper = mapper;
        this.userDataRepository = userDataRepository;
        this.userPlaylogRepository = userPlaylogRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();
        UserPlaylog userPlaylog = mapper.convert(request.get("userPlaylog"), UserPlaylog.class);
        userDataRepository.findByCard_ExtId(userId).ifPresent(u -> {
            userPlaylog.setUser(u);
            userPlaylogRepository.save(userPlaylog);
        });

        String json = "{\"returnCode\":\"1\",\"apiName\":\"UploadUserPlaylogApi\"}";
        logger.info("Response: " + json);
        return json;
    }
}
