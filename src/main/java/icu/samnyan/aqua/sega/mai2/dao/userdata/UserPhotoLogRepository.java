package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserPhotoLog;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserUdemae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserPhotoLogRepository")
public interface UserPhotoLogRepository extends JpaRepository<UserPhotoLog, Long> {
    Optional<UserPhotoLog> findByUser(UserData user);
}
