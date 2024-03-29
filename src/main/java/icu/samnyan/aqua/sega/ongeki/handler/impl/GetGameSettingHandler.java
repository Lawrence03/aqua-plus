package icu.samnyan.aqua.sega.ongeki.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.general.dao.PropertyEntryRepository;
import icu.samnyan.aqua.sega.general.dao.AllowKeychipRepository;
import icu.samnyan.aqua.sega.general.model.AllowKeychip;
import icu.samnyan.aqua.sega.general.model.PropertyEntry;
import icu.samnyan.aqua.sega.ongeki.handler.BaseHandler;
import icu.samnyan.aqua.sega.ongeki.model.response.GetGameSettingResp;
import icu.samnyan.aqua.sega.ongeki.model.response.data.GameSetting;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("OngekiGetGameSettingHandler")
public class GetGameSettingHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetGameSettingHandler.class);

    private final BasicMapper mapper;

    private final PropertyEntryRepository propertyEntryRepository;

    private final AllowKeychipRepository allowKeychipRepository;

    @Autowired
    public GetGameSettingHandler(BasicMapper mapper, PropertyEntryRepository propertyEntryRepository, AllowKeychipRepository allowKeychipRepository) {
        this.mapper = mapper;
        this.propertyEntryRepository = propertyEntryRepository;
        this.allowKeychipRepository = allowKeychipRepository;
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

        PropertyEntry ongekiDataVersion = propertyEntryRepository.findByPropertyKey("ongeki_data_version")
                .orElseGet(() -> new PropertyEntry("ongeki_data_version", "1.10.00"));
        PropertyEntry ongekiOnlineDataVersion = propertyEntryRepository.findByPropertyKey("ongeki_online_data_version")
                .orElseGet(() -> new PropertyEntry("ongeki_online_data_version", "1.10.00"));

        GameSetting gameSetting = new GameSetting(
                ongekiDataVersion.getPropertyValue(),
                ongekiOnlineDataVersion.getPropertyValue(),
                false,
                10,
                ZonedDateTime.now(ZoneId.of("Asia/Tokyo")).plusHours(23).toString().substring(0, 20).replace('T', ' ').concat("0"),
                ZonedDateTime.now(ZoneId.of("Asia/Tokyo")).plusHours(23).plusMinutes(1).toString().substring(0, 20).replace('T', ' ').concat("0"),
                false,
                300,
                300,
                300,
                300,
                300,
                300);

        GetGameSettingResp resp = new GetGameSettingResp(
                gameSetting,
                false,
                false
        );

        String json = mapper.write(resp);

        logger.info("Response: " + json);
        return json;
    }
}
