package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.response.CodeResp;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3UpsertClientTestmodeHandler")
public class UpsertClientTestmodeHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(UpsertClientTestmodeHandler.class);

    private final StringMapper mapper;

    public UpsertClientTestmodeHandler(StringMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String json = mapper.write(new CodeResp(1));
        logger.info("Response: " + json);
        return json;
    }
}