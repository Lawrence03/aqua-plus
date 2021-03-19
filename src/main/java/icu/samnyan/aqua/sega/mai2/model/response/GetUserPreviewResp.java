package icu.samnyan.aqua.sega.mai2.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserPreviewResp {

    private long userId = 0;
    private String userName = "";
    @JsonProperty("isLogin")
    private boolean isLogin = false;
    private String lastGameId = "";
    private String lastDataVersion = "";
    private String lastRomVersion = "";
    private String lastLoginDate = null;
    private String lastPlayDate = null;
    private int playerRating = 0;
    private int nameplateId = 0;
    private int iconId = 0;
    private int trophyId = 0;
    private int partnerId = 0;
    private int frameId = 0;
    private int dispRate = 0;
    private int totalAwake = 0;
    @JsonProperty("isNetMember")
    private int isNetMember = 0;
    private String dailyBonusDate = "";
    private int headPhoneVolume = 0;
    private boolean isInherit = false;

}
