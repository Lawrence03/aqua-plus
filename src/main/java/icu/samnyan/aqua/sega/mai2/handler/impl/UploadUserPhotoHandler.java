package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserDataRepository;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserPhotoLogRepository;
import icu.samnyan.aqua.sega.mai2.dao.userdata.UserPlaylogRepository;
import icu.samnyan.aqua.sega.mai2.model.request.data.UserPhoto;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserPhotoLog;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2UploadUserPhotoHandler")
public class UploadUserPhotoHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(UploadUserPhotoHandler.class);

    private final BasicMapper mapper;

    private final UserDataRepository userDataRepository;
    private final UserPhotoLogRepository userPhotoLogRepository;
    private final UserPlaylogRepository userPlaylogRepository;

    private final String PATH = "data/mai2photo/";

    public UploadUserPhotoHandler(BasicMapper mapper, UserDataRepository userDataRepository, UserPhotoLogRepository userPhotoLogRepository, UserPlaylogRepository userPlaylogRepository) {
        this.mapper = mapper;
        this.userDataRepository = userDataRepository;
        this.userPhotoLogRepository = userPhotoLogRepository;
        this.userPlaylogRepository = userPlaylogRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        UserPhoto userPhoto = mapper.convert(request.get("userPhoto"), UserPhoto.class);
        long userId = userPhoto.getUserId();
        long playlogId = userPhoto.getPlaylogId();
        int trackNo = userPhoto.getTrackNo();

        String fileName = userId + "-" + playlogId + "-" + trackNo + ".jpg";

        try {
            byte[] data = Base64.getMimeDecoder().decode(userPhoto.getDivData());
            Files.createDirectories(Paths.get(PATH));
            Path p = Paths.get(PATH, fileName);
            if(Files.exists(p)) {
                Files.write(p, data, StandardOpenOption.APPEND);
            } else {
                Files.write(p, data, StandardOpenOption.CREATE);
            }

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        if(userPhoto.getDivLength() == userPhoto.getDivNumber() + 1) {
            userDataRepository.findByCard_ExtId(userId).ifPresent(u -> {
                UserPhotoLog log = new UserPhotoLog();
                log.setUser(u);
                log.setPlaceId(userPhoto.getPlaceId());
                log.setUploadDate(userPhoto.getUploadDate());
                log.setPlaylogId(userPhoto.getPlaylogId());
                log.setTrackNo(userPhoto.getTrackNo());
                userPhotoLogRepository.save(log);

                userPlaylogRepository.findTopByUserAndPlaylogIdAndTrackNo(u, log.getPlaylogId(), log.getTrackNo()).ifPresent(p -> {
                    p.setPhotoUpload(true);
                    userPlaylogRepository.save(p);
                });
            });

        }

        String json = "{\"returnCode\":\"1\",\"apiName\":\"UploadUserPhotoApi\"}";
        logger.info("Response: " + json);
        return json;
    }
}
