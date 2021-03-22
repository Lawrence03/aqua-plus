package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserCharge;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserChargeRepository")
public interface UserChargeRepository extends JpaRepository<UserCharge, Long> {
    Optional<UserCharge> findByUserAndChargeId(UserData user, int chargeId);

    List<UserCharge> findByUser_Card_ExtId(Long userId);
}
