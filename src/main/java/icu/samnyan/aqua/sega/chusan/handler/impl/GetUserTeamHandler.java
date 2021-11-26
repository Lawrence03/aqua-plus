package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.dao.userdata.UserTeamRepository;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserTeam;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3GetUserTeamHandler")
public class GetUserTeamHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserTeamHandler.class);

    private final StringMapper mapper;

    private final UserTeamRepository userTeamRepository;

    @Autowired
    public GetUserTeamHandler(StringMapper mapper, UserTeamRepository userTeamRepository) {
        this.mapper = mapper;
        this.userTeamRepository = userTeamRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");
        Optional<UserTeam> userTeamOptional = userTeamRepository.findByUser_Card_ExtId(Long.parseLong(userId));

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        if (userTeamOptional.isPresent()) {
            UserTeam userTeam = userTeamOptional.get();
            if (userTeam.getTeamName().isEmpty()) {
                resultMap.put("teamId", 0);
                resultMap.put("teamRank", 0);
                resultMap.put("teamName", "");
            } else {
                resultMap.put("teamId", 1);
                resultMap.put("teamRank", 1);
                resultMap.put("teamName", userTeam.getTeamName());
            }
        } else {
            resultMap.put("teamId", 0);
            resultMap.put("teamRank", 0);
            resultMap.put("teamName", "");
        }
        resultMap.put("userTeamPoint", 114514);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
