package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserMusicDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserMusicDetailRepository")
public interface UserMusicDetailRepository extends JpaRepository<UserMusicDetail, Long> {
    Optional<UserMusicDetail> findByUserAndMusicIdAndLevel(UserData user, int musicId, int level);

    Page<UserMusicDetail> findByUser_Card_ExtId(long aimeId, Pageable page);

    List<UserMusicDetail> findByUser_Card_ExtIdAndMusicId(long aimeId, int id);
}
