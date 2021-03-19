package icu.samnyan.aqua.sega.ongeki.model.gamedata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Entity(name = "OngekiGameTechMusic")
@Table(name = "ongeki_game_tech_music")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameTechMusic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    private int eventId;

    private int musicId;

    private int level;
}
