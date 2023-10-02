package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.userdata.User2pPlaylogDetail;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("Mai2User2pPlaylogDetailRepository")
public interface User2pPlaylogDetailRepository {
    Optional<User2pPlaylogDetail> findByUser_Id(long userId);
}
