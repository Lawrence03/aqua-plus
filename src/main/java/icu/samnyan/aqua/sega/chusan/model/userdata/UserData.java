package icu.samnyan.aqua.sega.chusan.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import icu.samnyan.aqua.sega.general.model.Card;
import icu.samnyan.aqua.sega.util.jackson.AccessCodeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Entity(name = "C3UserData")
@Table(name = "c3_user_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Card card;
    // Access code in card

    private String accessCode;

    private String userName;

    private int level;

    private int reincarnationNum;

    private String exp;

    private long point;

    private long totalPoint;

    private int playCount;

    private int multiPlayCount;

    private int playerRating;

    private int highestRating;

    private int nameplateId;

    private int frameId;

    // Currently selected UserCharacter
    private int characterId;

    private int trophyId;

    private int playedTutorialBit;

    private int firstTutorialCancelNum;

    private int masterTutorialCancelNum;

    private int totalMapNum;

    private long totalHiScore;

    private long totalBasicHighScore;

    private long totalAdvancedHighScore;

    private long totalExpertHighScore;

    private long totalMasterHighScore;

    private long totalUltimaHighScore;

    private LocalDateTime eventWatchedDate;

    private int friendCount;

    private String firstGameId;

    private String firstRomVersion;

    private String firstDataVersion;

    private LocalDateTime firstPlayDate;

    private String lastGameId;

    private String lastRomVersion;

    private String lastDataVersion;

    private LocalDateTime lastPlayDate;

    private int lastPlaceId;

    private String lastPlaceName;

    private String lastRegionId;

    private String lastRegionName;

    private String lastAllNetId;

    private String lastClientId;

    // added in new
    private String lastCountryCode;
    private String userNameEx;
    private String compatibleCmVersion;
    private int medal;
    private int mapIconId;
    private int voiceId;
    private int avatarWear;
    private int avatarHead;
    private int avatarFace;
    private int avatarSkin;
    private int avatarItem;
    private int avatarFront;
    private int avatarBack;
    private int classEmblemBase;
    private int classEmblemMedal;
    private int stockedGridCount;
    private int exMapLoopCount;
    private int netBattlePlayCount;
    private int netBattleWinCount;
    private int netBattleLoseCount;
    private int netBattleConsecutiveWinCount;
    private int charaIllustId;
    private int skillId;
    private int overPowerPoint;
    private int overPowerRate;
    private int overPowerLowerRank;
    private int avatarPoint;
    private int battleRankId;
    private int battleRankPoint;
    private int eliteRankPoint;
    private int netBattle1stCount;
    private int netBattle2ndCount;
    private int netBattle3rdCount;
    private int netBattle4thCount;
    private int netBattleCorrection;
    private int netBattleErrCnt;
    private int netBattleHostErrCnt;
    private int battleRewardStatus;
    private int battleRewardIndex;
    private int battleRewardCount;
    private int ext1;
    private int ext2;
    private int ext3;
    private int ext4;
    private int ext5;
    private int ext6;
    private int ext7;
    private int ext8;
    private int ext9;
    private int ext10;
    private String extStr1;
    private String extStr2;
    private int extLong1;
    private int extLong2;
    private String rankUpChallengeResults;
}
