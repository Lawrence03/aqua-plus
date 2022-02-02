package icu.samnyan.aqua.sega.ongeki.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.general.dao.PropertyEntryRepository;
import icu.samnyan.aqua.sega.general.model.PropertyEntry;
import icu.samnyan.aqua.sega.ongeki.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component("OngekiGetGameMusicReleaseStateHandler")
public class GetGameMusicReleaseStateHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetGameMusicReleaseStateHandler.class);

    private final BasicMapper mapper;

    private final PropertyEntryRepository propertyEntryRepository;


    @Autowired
    public GetGameMusicReleaseStateHandler(BasicMapper mapper, PropertyEntryRepository propertyEntryRepository) {
        this.mapper = mapper;
        this.propertyEntryRepository = propertyEntryRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {

        PropertyEntry techScore = propertyEntryRepository.findByPropertyKey("ongeki_music_release_score")
                .orElseGet(() -> new PropertyEntry("ongeki_music_release_score", "0"));
        PropertyEntry cardNum = propertyEntryRepository.findByPropertyKey("ongeki_music_release_card")
                .orElseGet(() -> new PropertyEntry("ongeki_music_release_card", "0"));

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("techScore", techScore.getPropertyValue());
        resultMap.put("cardNum", cardNum.getPropertyValue());

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        return json;
    }
}
