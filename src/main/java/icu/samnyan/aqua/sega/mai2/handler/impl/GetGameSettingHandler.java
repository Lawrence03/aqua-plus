package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.general.dao.AllowKeychipRepository;
import icu.samnyan.aqua.sega.general.dao.PropertyEntryRepository;
import icu.samnyan.aqua.sega.general.model.PropertyEntry;
import icu.samnyan.aqua.sega.mai2.handler.BaseHandler;
import icu.samnyan.aqua.sega.mai2.model.response.GetGameSettingResp;
import icu.samnyan.aqua.sega.mai2.model.response.data.GameSetting;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetGameSettingHandler")
public class GetGameSettingHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetGameSettingHandler.class);

    private final BasicMapper mapper;

    private final PropertyEntryRepository propertyEntryRepository;
    private final AllowKeychipRepository allowKeychipRepository;

    private final String HOST;
    private final String PORT;

    @Autowired
    public GetGameSettingHandler(BasicMapper mapper,
                                 PropertyEntryRepository propertyEntryRepository,
                                 AllowKeychipRepository allowKeychipRepository,
                                 @Value("${allnet.server.host}") String HOST,
                                 @Value("${allnet.server.port}") String PORT) {
        this.mapper = mapper;
        this.propertyEntryRepository = propertyEntryRepository;
        this.allowKeychipRepository = allowKeychipRepository;
        this.HOST = HOST;
        this.PORT = PORT;
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
                false,
                10,
                ZonedDateTime.now(ZoneId.of("Asia/Tokyo")).toString().substring(0, 10).concat(" 23:59:00.0"),
                ZonedDateTime.now(ZoneId.of("Asia/Tokyo")).toString().substring(0, 10).concat(" 23:59:00.0"),
                1,
                1,
                "",
                "",
                "http://" + HOST + ":" + PORT + "/",
                "");

        GetGameSettingResp resp = new GetGameSettingResp(
                false,
                gameSetting
                );

        String json = mapper.write(resp);

        logger.info("Response: " + json);
        return json;
    }
}
