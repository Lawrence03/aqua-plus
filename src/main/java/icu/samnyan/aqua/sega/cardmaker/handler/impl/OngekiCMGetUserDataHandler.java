package icu.samnyan.aqua.sega.cardmaker.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.cardmaker.handler.BaseHandler;
import icu.samnyan.aqua.sega.ongeki.dao.userdata.UserDataRepository;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserData;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Component("CardmakerOngekiCMGetUserDataHandler")
public class OngekiCMGetUserDataHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(OngekiCMGetUserDataHandler.class);
    private final BasicMapper mapper;
    private final UserDataRepository userDataRepository;
    @Autowired
    public OngekiCMGetUserDataHandler(BasicMapper mapper, UserDataRepository userDataRepository) {
        this.mapper = mapper;
        this.userDataRepository = userDataRepository;
    }
    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        Long userId = ( (Number) request.get("userId") ).longValue();

        Optional<UserData> userDataOptional = userDataRepository.findByCard_ExtId(userId);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        if(userDataOptional.isPresent()) {
            resultMap.put("userData", userDataOptional.get());
        } else {
            resultMap.put("userData",null);
        }

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        return json;
    }
}
