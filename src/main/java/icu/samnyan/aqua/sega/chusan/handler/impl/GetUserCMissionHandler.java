package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserCMissionProgressRepository;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserCMissionRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserCMission;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserCMissionProgress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("C3GetUserCMissionHandler")
public class GetUserCMissionHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserCMissionHandler.class);

    private final StringMapper mapper;

    private final UserCMissionRepository userCMissionRepository;

    @Autowired
    public GetUserCMissionHandler(StringMapper mapper, UserCMissionRepository userCMissionRepository) {
        this.mapper = mapper;
        this.userCMissionRepository = userCMissionRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");
        String missionId = (String) request.get("missionId");
        int point = 0;
        List<UserCMissionProgress> userCMissionProgressList = new LinkedList<>();

        Optional<UserCMission> userCMission = userCMissionRepository.findByUser_Card_ExtIdAndMissionId(Long.parseLong(userId), Integer.parseInt(missionId));
        if (!userCMission.isEmpty()) {
            point = userCMission.get().getPoint();
            userCMissionProgressList = userCMission.get().getUserCMissionProgressList();
        }

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("missionId", missionId);
        resultMap.put("point", point);
        resultMap.put("userCMissionProgressList", userCMissionProgressList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }

}
