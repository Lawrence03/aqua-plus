package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserPortrait;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserSessionRepository")
public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
    Optional<UserSession> findByUser(UserData user);
}
