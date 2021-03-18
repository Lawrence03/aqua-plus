package icu.samnyan.aqua.sega.ongeki.dao.userdata;

import icu.samnyan.aqua.sega.ongeki.model.userdata.UserData;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserEventMusic;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserMusicDetail;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserMusicItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("OngekiUserEventMusicRepository")
public interface UserEventMusicRepository extends JpaRepository<UserEventMusic, Long> {

    List<UserEventMusic> findByUser_Card_ExtId(int userId);

    Optional<UserEventMusic> findByUserAndEventIdAndMusicIdAndLevel(UserData user, int eventId, int musicId, int level);

    @Transactional
    void deleteByUser(UserData user);
}
