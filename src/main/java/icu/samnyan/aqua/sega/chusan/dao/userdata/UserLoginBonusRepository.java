package icu.samnyan.aqua.sega.chusan.dao.userdata;

import icu.samnyan.aqua.sega.chusan.model.userdata.UserLoginBonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("C3UserLoginBonusRepository")
public interface UserLoginBonusRepository extends JpaRepository<UserLoginBonus, Long> {

}
