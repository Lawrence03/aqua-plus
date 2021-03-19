package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserLoginBonus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserLoginBonusRepository")
public interface UserLoginBonusRepository extends JpaRepository<UserLoginBonus, Long> {

    Page<UserLoginBonus> findByUser_Card_ExtId(Long userId, Pageable page);

    Optional<UserLoginBonus> findByUserAndBonusId(UserData userData, int bonusId);

}
