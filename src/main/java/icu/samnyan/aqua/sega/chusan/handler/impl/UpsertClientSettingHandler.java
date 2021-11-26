package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.request.ClientSettingRequest;
import icu.samnyan.aqua.sega.chusan.model.response.CodeResp;
import icu.samnyan.aqua.sega.general.model.GameVersion;
import icu.samnyan.aqua.sega.general.service.ClientSettingService;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

import static icu.samnyan.aqua.sega.util.AquaConst.DEFAULT_KEYCHIP_ID;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3UpsertClientSettingHandler")
public class UpsertClientSettingHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(UpsertClientSettingHandler.class);

    private final StringMapper mapper;

    private final ClientSettingService clientSettingService;

    public UpsertClientSettingHandler(StringMapper mapper, ClientSettingService clientSettingService) {
        this.mapper = mapper;
        this.clientSettingService = clientSettingService;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        var req = mapper.convert(request, ClientSettingRequest.class);
        var set = req.getClientSetting();
        var serial = (String) set.getClientId();
        if (!serial.equals(DEFAULT_KEYCHIP_ID)) {
            clientSettingService.writeSetting(new GameVersion(serial, set.getRomVersion(), set.getDataVersion(), LocalDateTime.now()));
        }
        String json = mapper.write(new CodeResp(1));
        logger.info("Response: " + json);
        return json;
    }
}
