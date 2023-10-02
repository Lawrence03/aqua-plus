package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.userdata.User2pPlaylog;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("Mai2User2pPlaylogRepository")
public interface User2pPlaylogRepository {
    Optional<User2pPlaylog> findByUserA_Id(Long userId);
}
