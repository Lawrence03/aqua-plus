package icu.samnyan.aqua.sega.ongeki.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.ongeki.dao.userdata.UserBossRepository;
import icu.samnyan.aqua.sega.ongeki.handler.BaseHandler;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserBoss;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("OngekiCommonStubHandler")
public class CommonStubHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(CommonStubHandler.class);

    private final BasicMapper mapper;

    private String mListName;

    @Autowired
    public CommonStubHandler(BasicMapper mapper) {
        this.mapper = mapper;
    }

    public CommonStubHandler setListName(String name) {
        mListName = name;
        return this;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException, RuntimeException {
        if (mListName == null || mListName.isBlank()) {
            throw new RuntimeException("Should set list name first!");
        }
        Integer userId = (Integer) request.get("userId");

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", 0);
        resultMap.put(mListName, new List[]{});

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        mListName = null;

        return json;
    }
}
