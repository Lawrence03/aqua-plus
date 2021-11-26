package icu.samnyan.aqua.sega.chusan.dao.userdata;

import icu.samnyan.aqua.sega.chusan.model.userdata.UserData;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserMusic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("C3UserMusicRepository")
public interface UserMusicRepository extends JpaRepository<UserMusic, Long> {

    Optional<UserMusic> findTopByUserAndMusicIdAndLevelOrderByIdDesc(UserData user, int musicId, int level);

    List<UserMusic> findByUser_Card_ExtId(long extId);

    List<UserMusic> findByUser_Card_ExtIdAndMusicId(long extId, int musicId);

    Page<UserMusic> findByUser_Card_ExtId(long extId, Pageable page);
}
