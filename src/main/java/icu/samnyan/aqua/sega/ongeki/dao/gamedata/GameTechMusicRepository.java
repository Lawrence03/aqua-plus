package icu.samnyan.aqua.sega.ongeki.dao.gamedata;

import icu.samnyan.aqua.sega.ongeki.model.gamedata.GameTechMusic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("OngekiGameTechMusicRepository")
public interface GameTechMusicRepository extends JpaRepository<GameTechMusic, Long> {
}
