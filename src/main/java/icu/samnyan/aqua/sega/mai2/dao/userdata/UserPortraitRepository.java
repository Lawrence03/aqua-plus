package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserPortrait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserPortraitRepository")
public interface UserPortraitRepository extends JpaRepository<UserPortrait, Long> {
    List<UserPortrait> findByUserId(Integer userId);
    void deleteAllByUserId(Integer userId);
}
