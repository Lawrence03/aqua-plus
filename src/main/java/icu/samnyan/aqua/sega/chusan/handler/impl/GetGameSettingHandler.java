package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.response.GetGameSettingResp;
import icu.samnyan.aqua.sega.chusan.model.response.data.GameSetting;
import icu.samnyan.aqua.sega.general.dao.PropertyEntryRepository;
import icu.samnyan.aqua.sega.general.model.PropertyEntry;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetGameSettingHandler")
public class GetGameSettingHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetGameSettingHandler.class);

    private final StringMapper mapper;

    private final PropertyEntryRepository propertyEntryRepository;

    private final String HOST;

    private final String PORT;

    private final String romVersion;

    private final String dataVersion;

    @Autowired
    public GetGameSettingHandler(StringMapper mapper,
                                 PropertyEntryRepository propertyEntryRepository,
                                 @Value("${allnet.server.host}") String HOST,
                                 @Value("${allnet.server.port}") String PORT,
                                 @Value("${game.chusan.rom-version}") String romVersion,
                                 @Value("${game.chusan.data-version}") String dataVersion
    ) {
        this.mapper = mapper;
        this.propertyEntryRepository = propertyEntryRepository;
        this.HOST = HOST;
        this.PORT = PORT;
        this.romVersion = romVersion;
        this.dataVersion = dataVersion;
    }


    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {

        GameSetting gameSetting = new GameSetting(
                romVersion,
                dataVersion,
                false,
                10,
                ZonedDateTime.now(ZoneId.of("Asia/Tokyo")).toString().substring(0, 10).concat(" 06:30:00.0"),
                ZonedDateTime.now(ZoneId.of("Asia/Tokyo")).toString().substring(0, 10).concat(" 07:00:00.0"),
                false,
                300,
                300,
                100,
                0,
                0,
                99,
                5,
                "http://" + HOST + ":" + PORT + "/ChusanServlet/",
                "http://" + HOST + ":" + PORT + "/ChusanServlet/",
                "http://" + HOST + ":" + PORT + "/ChusanServlet/");

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
