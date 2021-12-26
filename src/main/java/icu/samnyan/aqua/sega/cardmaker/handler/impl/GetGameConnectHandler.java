package icu.samnyan.aqua.sega.cardmaker.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.general.dao.PropertyEntryRepository;
import icu.samnyan.aqua.sega.mai2.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.Map;

@Component("CardmakerGetGameConnectHandler")
public class GetGameConnectHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetGameConnectHandler.class);

    private final BasicMapper mapper;

    private final PropertyEntryRepository propertyEntryRepository;

    private final String HOST;
    private final String PORT;

    public GetGameConnectHandler(BasicMapper mapper,
                                 PropertyEntryRepository propertyEntryRepository,
                                 @Value("${allnet.server.host}") String HOST,
                                 @Value("${allnet.server.port}") String PORT) {
        this.mapper = mapper;
        this.propertyEntryRepository = propertyEntryRepository;
        this.HOST = HOST;
        this.PORT = PORT;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("length", 3);
        ArrayList<Object> gameConnectList = new ArrayList<>();
        Map<String, Object> gameConnect = new LinkedHashMap<>();
        gameConnect.put("modelKind", 0);
        gameConnect.put("type", 0);
        gameConnect.put("titleUri", "http://" + HOST + ":" + PORT + "/CardmakerServlet/Chuni/");
        gameConnectList.add(gameConnect);
        gameConnect = new LinkedHashMap<>();
        gameConnect.put("modelKind", 1);
        gameConnect.put("type", 0);
        gameConnect.put("titleUri", "http://" + HOST + ":" + PORT + "/CardmakerServlet/Mai/");
        gameConnectList.add(gameConnect);
        gameConnect = new LinkedHashMap<>();
        gameConnect.put("modelKind", 2);
        gameConnect.put("type", 0);
        gameConnect.put("titleUri", "http://" + HOST + ":" + PORT + "/CardmakerServlet/Ongeki/");
        gameConnectList.add(gameConnect);
        resultMap.put("gameConnectList", gameConnectList);
        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }

}
