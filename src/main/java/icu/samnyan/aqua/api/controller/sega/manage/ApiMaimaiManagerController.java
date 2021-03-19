package icu.samnyan.aqua.api.controller.sega.manage;

import icu.samnyan.aqua.sega.maimai.dao.gamedata.GameEventRepository;
import icu.samnyan.aqua.sega.maimai.model.gamedata.GameEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@RestController
@RequestMapping("api/manage/maimai/")
public class ApiMaimaiManagerController {

    private final GameEventRepository gameEventRepository;

    public ApiMaimaiManagerController(GameEventRepository gameEventRepository) {
        this.gameEventRepository = gameEventRepository;
    }

    @PostMapping("import/event")
    public List<GameEvent> importEvent(@RequestBody List<GameEvent> req) {
        return gameEventRepository.saveAll(req);
    }
}
