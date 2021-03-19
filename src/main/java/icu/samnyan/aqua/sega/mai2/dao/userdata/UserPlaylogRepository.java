package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserPlaylog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserPlaylogRepository")
public interface UserPlaylogRepository extends JpaRepository<UserPlaylog, Long> {
    Optional<UserPlaylog> findTopByUserAndPlaylogIdAndTrackNo(UserData user, long playlogId, int trackNo);

    Page<UserPlaylog> findByUser_Card_ExtId(long aimeId, Pageable page);

    List<UserPlaylog> findByUser_Card_ExtIdAndMusicIdAndLevel(long aimeId, int id, int level);
}
