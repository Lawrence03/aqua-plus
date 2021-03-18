package icu.samnyan.aqua.sega.ongeki.model.response.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Fro getGameRanking request
 * @author samnyan (privateamusement@protonmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameTechMusicItem {
    private int eventId;
    private int musicId;
    private int level;
}
