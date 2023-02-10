package icu.samnyan.aqua.sega.chunithm.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chunithm.handler.BaseHandler;
import icu.samnyan.aqua.sega.chunithm.model.response.GetGameSettingResp;
import icu.samnyan.aqua.sega.chunithm.model.response.data.GameSetting;
import icu.samnyan.aqua.sega.general.dao.AllowKeychipRepository;
import icu.samnyan.aqua.sega.general.dao.PropertyEntryRepository;
import icu.samnyan.aqua.sega.general.model.PropertyEntry;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component
public class GetGameSettingHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetGameSettingHandler.class);

    private final StringMapper mapper;

    private final PropertyEntryRepository propertyEntryRepository;
    private final AllowKeychipRepository allowKeychipRepository;

    @Autowired
    public GetGameSettingHandler(StringMapper mapper, PropertyEntryRepository propertyEntryRepository, AllowKeychipRepository allowKeyChipRepository) {
        this.mapper = mapper;
        this.propertyEntryRepository = propertyEntryRepository;
        this.allowKeychipRepository = allowKeyChipRepository;
    }


    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {

        String keychip = (String) request.get("clientId");
        boolean allow = allowKeychipRepository.existsByKeychipId(keychip);
        try {
            if (!allow) {
                logger.info("Blocked keychip: " + keychip);
                return null;
            }
        } catch (Exception e) {}
        
        GameSetting gameSetting = new GameSetting(
                1,
                false,
                10,
                ZonedDateTime.now(ZoneId.of("Asia/Tokyo")).toString().substring(0, 10).concat(" 06:30:00.0"),
                ZonedDateTime.now(ZoneId.of("Asia/Tokyo")).toString().substring(0, 10).concat(" 07:00:00.0"),
                false,
                300,
                300,
                300);

        GetGameSettingResp resp = new GetGameSettingResp(
                gameSetting,
                false,
                true
        );

        String json = mapper.write(resp);

        logger.info("Response: " + json);
        return json;
    }
}
