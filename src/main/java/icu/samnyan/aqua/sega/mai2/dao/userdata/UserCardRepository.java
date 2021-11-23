package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserCard;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserCardRepository")
public interface UserCardRepository  extends JpaRepository<UserCard, Long> {

    Optional<UserCard> findByUserAndCardId(UserData user, int cardId);

    List<UserCard> findByUser_Card_ExtId(Long userId);
}
