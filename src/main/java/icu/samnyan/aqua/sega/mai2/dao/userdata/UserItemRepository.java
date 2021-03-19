package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.gamedata.GameEvent;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserItemRepository")
public interface UserItemRepository extends JpaRepository<UserItem, Long> {
    Optional<UserItem> findByUserAndItemKindAndItemId(UserData user, int itemKind, int itemId);

    Page<UserItem> findByUser_Card_ExtIdAndItemKind(Long userId, int kind, Pageable page);
}
