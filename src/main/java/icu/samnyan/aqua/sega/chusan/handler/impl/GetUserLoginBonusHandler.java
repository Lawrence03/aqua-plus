package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserLoginBonusRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserLoginBonus;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.eclipse.jetty.server.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetUserLoginBonusHandler")
public class GetUserLoginBonusHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserLoginBonusHandler.class);

    private final StringMapper mapper;

    private final UserLoginBonusRepository userLoginBonusRepository;

    @Autowired
    public GetUserLoginBonusHandler(StringMapper mapper, UserLoginBonusRepository userLoginBonusRepository) {
        this.mapper = mapper;
        this.userLoginBonusRepository = userLoginBonusRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");

        Map<String, Object> resultMap = new LinkedHashMap<>();
        List<UserLoginBonus> userLoginBonusList = userLoginBonusRepository.findAll();
        resultMap.put("userId", userId);
        resultMap.put("length", 0);
        resultMap.put("userLoginBonusList", new ArrayList<>());

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
