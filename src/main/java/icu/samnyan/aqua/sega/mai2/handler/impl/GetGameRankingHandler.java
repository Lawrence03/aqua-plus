package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetGameRankingHandler")
public class GetGameRankingHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetGameRankingHandler.class);

    private final BasicMapper mapper;

    @Autowired
    public GetGameRankingHandler(BasicMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        Integer type = (Integer) request.get("type");

        List<Object> gameRankingList = new ArrayList<>();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("type", type);
        resultMap.put("gameRankingList", gameRankingList);

        String json = mapper.write(resultMap);
        Path path = FileSystems.getDefault().getPath("gameRankingObject.json");
        if (Files.exists(path)) {
            try {
                json = Files.readString(path);
            } catch (java.io.IOException e) {}
        }
        logger.info("Response: " + json);
        return json;
    }
}
