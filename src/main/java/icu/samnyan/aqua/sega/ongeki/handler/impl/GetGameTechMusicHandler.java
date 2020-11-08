package icu.samnyan.aqua.sega.ongeki.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.ongeki.dao.gamedata.GameTechMusicRepository;
import icu.samnyan.aqua.sega.ongeki.handler.BaseHandler;
import icu.samnyan.aqua.sega.ongeki.model.gamedata.GameTechMusic;
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
@Component("OngekiGetGameTechMusicHandler")
public class GetGameTechMusicHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetGameTechMusicHandler.class);

    private final BasicMapper mapper;

    private final GameTechMusicRepository gameTechMusicRepository;

    @Autowired
    public GetGameTechMusicHandler(BasicMapper mapper, GameTechMusicRepository gameTechMusicRepository) {
        this.mapper = mapper;
        this.gameTechMusicRepository = gameTechMusicRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        List<GameTechMusic> musicList = gameTechMusicRepository.findAll();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("length", musicList.size());
        resultMap.put("gameTechMusicList", musicList);

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        return json;
    }
}
