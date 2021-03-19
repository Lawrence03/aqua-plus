package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.gamedata.GameEvent;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserExtend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserExtendRepository")
public interface UserExtendRepository extends JpaRepository<UserExtend, Long> {
    Optional<UserExtend> findByUser(UserData userData);

    Optional<UserExtend> findByUser_Card_ExtId(Long userId);
}
