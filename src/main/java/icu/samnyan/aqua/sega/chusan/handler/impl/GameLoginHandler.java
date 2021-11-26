package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserDataRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.response.CodeResp;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserData;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GameLoginHandler")
public class GameLoginHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GameLoginHandler.class);

    private final StringMapper mapper;

    private final UserDataRepository userDataRepository;

    public GameLoginHandler(StringMapper mapper, UserDataRepository userDataRepository) {
        this.mapper = mapper;
        this.userDataRepository = userDataRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");
        Optional<UserData> userDataOptional = userDataRepository.findByCard_ExtId(Long.parseLong(userId));
        userDataOptional.ifPresent(this::updateLoginTime);

        String json = mapper.write(new CodeResp(1));
        logger.info("Response: " + json);
        return json;
    }

    private void updateLoginTime(UserData userData) {
        userDataRepository.save(userData);
    }
}
