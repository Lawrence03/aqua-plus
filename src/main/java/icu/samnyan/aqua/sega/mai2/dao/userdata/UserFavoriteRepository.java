package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.gamedata.GameEvent;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserFavoriteRepository")
public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Long> {
    Optional<UserFavorite> findByUserAndItemKind(UserData user, int kind);

    Optional<UserFavorite> findByUser_Card_ExtIdAndItemKind(Long userId, int itemKind);
}
