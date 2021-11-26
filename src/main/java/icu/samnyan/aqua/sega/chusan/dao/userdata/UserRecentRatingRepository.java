package icu.samnyan.aqua.sega.chusan.dao.userdata;

import icu.samnyan.aqua.sega.chusan.model.userdata.UserData;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserRecentRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("C3UserRecentRatingRepository")
public interface UserRecentRatingRepository extends JpaRepository<UserRecentRating, Long> {

    Optional<UserRecentRating> findTopByUserAndSortOrderOrderByIdAsc(UserData user, int sortOrder);

    List<UserRecentRating> findByUser_Card_ExtIdOrderBySortOrderAsc(long extId);
}
