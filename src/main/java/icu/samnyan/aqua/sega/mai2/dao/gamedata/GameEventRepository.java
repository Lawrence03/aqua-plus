package icu.samnyan.aqua.sega.mai2.dao.gamedata;

import icu.samnyan.aqua.sega.mai2.model.gamedata.GameEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Mai2GameEventRepository")
public interface GameEventRepository extends JpaRepository<GameEvent, Long> {
}
