package icu.samnyan.aqua.sega.chusan.dao.userdata;

import icu.samnyan.aqua.sega.chusan.model.userdata.UserCMissionProgress;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCMissionProgressRepository extends JpaRepository<UserCMissionProgress, Long> {

}
