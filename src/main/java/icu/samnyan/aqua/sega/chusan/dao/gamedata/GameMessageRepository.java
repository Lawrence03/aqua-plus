package icu.samnyan.aqua.sega.chusan.dao.gamedata;

import icu.samnyan.aqua.sega.chusan.model.gamedata.GameMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("C3GameMessageRepository")
public interface GameMessageRepository extends JpaRepository<GameMessage, Integer> {
}
