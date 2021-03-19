package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.gamedata.GameEvent;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserActivity;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserActivityRepository")
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
    Optional<UserActivity> findByUserAndKindAndActivityId(UserData user, int kind, int id);

    List<UserActivity> findByUser_Card_ExtIdAndKind(Long userId, int kind);
}
