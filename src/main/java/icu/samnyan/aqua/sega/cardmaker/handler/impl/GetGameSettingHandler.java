package icu.samnyan.aqua.sega.cardmaker.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.cardmaker.handler.BaseHandler;
import icu.samnyan.aqua.sega.general.dao.AllowKeychipRepository;
import icu.samnyan.aqua.sega.general.dao.PropertyEntryRepository;
import icu.samnyan.aqua.sega.general.model.PropertyEntry;
import icu.samnyan.aqua.sega.cardmaker.model.response.data.GameSetting;
import icu.samnyan.aqua.sega.cardmaker.model.response.GetGameSettingResp;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
@Component("CardmakerGetGameSettingHandler")
public class GetGameSettingHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(icu.samnyan.aqua.sega.mai2.handler.impl.GetGameSettingHandler.class);

    private final BasicMapper mapper;

    private final PropertyEntryRepository propertyEntryRepository;
    private final AllowKeychipRepository allowKeychipRepository;

    @Autowired
    public GetGameSettingHandler(BasicMapper mapper,
                                 PropertyEntryRepository propertyEntryRepository,
                                 AllowKeychipRepository allowKeychipRepository) {
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
        } catch (Exception e) {
        }

        PropertyEntry start = propertyEntryRepository.findByPropertyKey("reboot_start_time")
                .orElseGet(() -> new PropertyEntry("reboot_start_time", "2020-01-01 06:30:00.0"));
        PropertyEntry end = propertyEntryRepository.findByPropertyKey("reboot_end_time")
                .orElseGet(() -> new PropertyEntry("reboot_end_time", "2020-01-01 07:00:00.0"));
        PropertyEntry ongekiDataVersion = propertyEntryRepository.findByPropertyKey("ongeki_data_version")
                .orElseGet(() -> new PropertyEntry("ongeki_data_version", "1.10.00"));


        GameSetting gameSetting = new GameSetting(
                "1.00.00",
                ongekiDataVersion.getPropertyValue(),
                "1.00.00",
                "1.00.00",
                10,
                false,
                false,
                start.getPropertyValue(),
                end.getPropertyValue(),
                300,
                300,
                300,
                false
        );

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
