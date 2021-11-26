package icu.samnyan.aqua.sega.chusan.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import icu.samnyan.aqua.sega.chusan.model.userdata.UserCharacter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserPreviewResp {

    /**
     * AiMe ID, from request
     */
    private String userId;

    /**
     * Current login (i.e. profile lock) status
     */
    @JsonProperty("isLogin")
    private boolean isLogin;

    /**
     * Date "YYYY-MM-DD hh:mm:ss"
     */
    private LocalDateTime lastLoginDate;

    /**
     * UserData
     */
    private String userName;

    private int reincarnationNum;

    private int level;

    private String exp;

    private int playerRating;

    private String lastGameId;

    private String lastRomVersion;

    private String lastDataVersion;

    /**
     * Date "YYYY-MM-DD hh:mm:ss"
     */
    private LocalDateTime lastPlayDate;

    private int trophyId;

    /**
     * Currently selected UserCharacter
     */
    private UserCharacter userCharacter;

    /**
     * UserGameOption
     */
    private int playerLevel;

    private int rating;

    private int headphone;

    private int chargeState;

    private String userNameEx;

    private int emoneyBrandId;

    private int classEmblemMedal;

    private int classEmblemBase;

    private int battleRankId;

}
