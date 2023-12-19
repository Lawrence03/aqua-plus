package icu.samnyan.aqua.sega.chusan.dao.userdata;

import icu.samnyan.aqua.sega.chusan.model.userdata.UserCMission;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCMissionRepository extends JpaRepository<UserCMission, Long> {

    Optional<UserCMission> findByUser (UserData user);

    Optional<UserCMission> findByUser_Card_ExtId (long extId);

    Optional<UserCMission> findByUserAndMissionId (UserData user, int missionId);

    Optional<UserCMission> findByUser_Card_ExtIdAndMissionId (long extId, int missionId);
}
