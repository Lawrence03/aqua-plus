package icu.samnyan.aqua.sega.chusan.dao.userdata;

import icu.samnyan.aqua.sega.chusan.model.userdata.UserRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("C3UserRegionRepository")
public interface UserRegionRepository extends JpaRepository<UserRegion, Long> {

    List<UserRegion> findByUser_Card_ExtId(long extId);
}
