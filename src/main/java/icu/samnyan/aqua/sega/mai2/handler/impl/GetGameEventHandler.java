package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.gamedata.GameEventRepository;
import icu.samnyan.aqua.sega.mai2.handler.BaseHandler;
import icu.samnyan.aqua.sega.mai2.model.gamedata.GameEvent;
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
@Component("Mai2GetGameEventHandler")
public class GetGameEventHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetGameEventHandler.class);

    private final BasicMapper mapper;

    private final GameEventRepository gameEventRepository;

    @Autowired
    public GetGameEventHandler(BasicMapper mapper, GameEventRepository gameEventRepository) {
        this.mapper = mapper;
        this.gameEventRepository = gameEventRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        Integer type = (Integer) request.get("type");

        List<GameEvent> gameEventList = gameEventRepository.findAll();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("type", type);
        resultMap.put("gameEventList", gameEventList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
