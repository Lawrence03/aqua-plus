package icu.samnyan.aqua.sega.mai2.dao.userdata;

import icu.samnyan.aqua.sega.mai2.model.gamedata.GameEvent;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserCharacter;
import icu.samnyan.aqua.sega.mai2.model.userdata.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2UserCharacterRepository")
public interface UserCharacterRepository extends JpaRepository<UserCharacter, Long> {
    Optional<UserCharacter> findByUserAndCharacterId(UserData user, int characterId);

    List<UserCharacter> findByUser_Card_ExtId(Long userId);
}
