package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserFriendSeasonRanking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserFriendSeasonRankingRepository")
public interface UserFriendSeasonRankingRepository extends JpaRepository<UserFriendSeasonRanking, Long> {
    Optional<UserFriendSeasonRanking> findByUserAndSeasonId(UserData user, int seasonId);

    Page<UserFriendSeasonRanking> findByUser_Card_ExtId(Long userId, Pageable page);
}