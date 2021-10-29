package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserExtendRepository;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserExtend;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2GetUserExtendHandler")
public class GetUserExtendHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserExtendHandler.class);

    private final BasicMapper mapper;

    private final UserExtendRepository userExtendRepository;

    public GetUserExtendHandler(BasicMapper mapper, UserExtendRepository userExtendRepository) {
        this.mapper = mapper;
        this.userExtendRepository = userExtendRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        Optional<UserExtend> userExtend = userExtendRepository.findByUser_Card_ExtId(userId);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        if(userExtend.isPresent()) {
            UserExtend extend = userExtend.get();
            if(extend.getExtendContentBit() == null) {
                extend.setExtendContentBit(0L);
            }
            if(extend.getIsPhotoAgree() == null) {
                extend.setIsPhotoAgree(false);
            }
            if(extend.getIsGotoCodeRead() == null) {
                extend.setIsGotoCodeRead(false);
            }
            ArrayList<Integer> selectedCardList = new ArrayList<Integer>();
            selectedCardList.add(4);
            extend.setSelectedCardList(selectedCardList);
            resultMap.put("userExtend", extend);
        } else {
            resultMap.put("userExtend", null);
        }

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
