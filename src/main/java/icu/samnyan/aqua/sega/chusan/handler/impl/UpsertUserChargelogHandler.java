package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserChargeRepository;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserDataRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.response.CodeResp;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserCharge;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserData;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3UpsertUserChargelogHandler")
public class UpsertUserChargelogHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(UpsertUserChargelogHandler.class);

    private final StringMapper mapper;

    private final UserDataRepository userDataRepository;
    private final UserChargeRepository userChargeRepository;

    public UpsertUserChargelogHandler(StringMapper mapper, UserDataRepository userDataRepository, UserChargeRepository userChargeRepository) {
        this.mapper = mapper;
        this.userDataRepository = userDataRepository;
        this.userChargeRepository = userChargeRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");
        UserData user = userDataRepository.findByCard_ExtId(Long.parseLong(userId)).orElseThrow();

        @SuppressWarnings("unchecked") 
        Map<String, Object> userChargeMap = (Map<String, Object>) request.get("userCharge");
        String chargeId = (String) userChargeMap.get("chargeId");
        UserCharge charge = mapper.convert(userChargeMap, UserCharge.class);

        UserCharge userCharge = userChargeRepository.findByUserAndChargeId(user, Integer.parseInt(chargeId)).orElseGet(() -> new UserCharge(user));
        userCharge.setChargeId(charge.getChargeId());
        userCharge.setStock(charge.getStock());
        userCharge.setPurchaseDate(charge.getPurchaseDate());
        userCharge.setValidDate(charge.getValidDate());
        userCharge.setParam1(charge.getParam1());
        userCharge.setParam2(charge.getParam2());
        userCharge.setParamDate(charge.getParamDate());

        userChargeRepository.save(userCharge);

        String json = mapper.write(new CodeResp(1));
        logger.info("Response: " + json);
        return json;
    }
}
