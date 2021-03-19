package icu.samnyan.aqua.api.controller.sega.game.mai2;

import icu.samnyan.aqua.api.model.ReducedPageResponse;
import icu.samnyan.aqua.api.util.ApiMapper;
import icu.samnyan.aqua.sega.mai2.dao.userdata.*;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserMusicDetail;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserPlaylog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@RestController
@RequestMapping("api/game/mai2")
public class ApiMai2PlayerDataController {

    private final ApiMapper mapper;

    private final UserDataRepository userDataRepository;
    private final UserCharacterRepository userCharacterRepository;
    private final UserGeneralDataRepository userGeneralDataRepository;
    private final UserMusicDetailRepository userMusicDetailRepository;
    private final UserPlaylogRepository userPlaylogRepository;
    private final UserPhotoLogRepository userPhotoLogRepository;

    public ApiMai2PlayerDataController(ApiMapper mapper, UserDataRepository userDataRepository, UserCharacterRepository userCharacterRepository, UserGeneralDataRepository userGeneralDataRepository, UserMusicDetailRepository userMusicDetailRepository, UserPlaylogRepository userPlaylogRepository, UserPhotoLogRepository userPhotoLogRepository) {
        this.mapper = mapper;
        this.userDataRepository = userDataRepository;
        this.userCharacterRepository = userCharacterRepository;
        this.userGeneralDataRepository = userGeneralDataRepository;
        this.userMusicDetailRepository = userMusicDetailRepository;
        this.userPlaylogRepository = userPlaylogRepository;
        this.userPhotoLogRepository = userPhotoLogRepository;
    }


    @GetMapping("profile")
    public UserData getProfile(@RequestParam Long aimeId) {
        return userDataRepository.findByCard_ExtId(aimeId).orElseThrow();
    }

    @GetMapping("recent")
    public ReducedPageResponse<UserPlaylog> getRecent(@RequestParam Long aimeId,
                                                      @RequestParam(required = false, defaultValue = "0") int page,
                                                      @RequestParam(required = false, defaultValue = "10") int size) {
        Page<UserPlaylog> playlogs = userPlaylogRepository.findByUser_Card_ExtId(aimeId, PageRequest.of(page,size, Sort.Direction.DESC, "id"));
        return new ReducedPageResponse<>(playlogs.getContent(), playlogs.getPageable().getPageNumber(), playlogs.getTotalPages(), playlogs.getTotalElements());
    }

    @GetMapping("song/{id}")
    public List<UserMusicDetail> getSongDetail(@RequestParam Long aimeId, @PathVariable int id) {
        return userMusicDetailRepository.findByUser_Card_ExtIdAndMusicId(aimeId, id);
    }

    @GetMapping("song/{id}/{level}")
    public List<UserPlaylog> getLevelPlaylog(@RequestParam Long aimeId, @PathVariable int id, @PathVariable int level) {
        return userPlaylogRepository.findByUser_Card_ExtIdAndMusicIdAndLevel(aimeId, id, level);
    }
}
