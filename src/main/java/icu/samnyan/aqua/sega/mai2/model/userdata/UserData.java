package icu.samnyan.aqua.sega.mai2.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import icu.samnyan.aqua.sega.general.model.Card;
import icu.samnyan.aqua.sega.util.hibernate.IntArrayToString;
import icu.samnyan.aqua.sega.util.jackson.AccessCodeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Entity(name = "Mai2UserData")
@Table(name = "mai2_user_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonSerialize(using = AccessCodeSerializer.class)
    @JsonProperty(value = "accessCode", access = JsonProperty.Access.READ_ONLY)
    @OneToOne
    @JoinColumn(name = "aime_card_id")
    private Card card;

    private String userName;

    private int isNetMember;

    private int iconId;

    private int plateId;

    private int titleId;

    private int partnerId;

    private long frameId;

    private int selectMapId;

    private int totalAwake;

    private int gradeRating;

    private int musicRating;

    private int playerRating;

    private int highestRating;

    private int gradeRank;

    private int classRank;

    private int courseRank;

    // Int array
    @Convert(converter = IntArrayToString.class)
    private List<Integer> charaSlot;

    // Int array
    @Convert(converter = IntArrayToString.class)
    private List<Integer> charaLockSlot;

    private long contentBit;

    private int playCount;

    private String eventWatchedDate;

    private String lastGameId;

    private String lastRomVersion;

    private String lastDataVersion;

    private String lastLoginDate;

    private String lastPlayDate;

    private int lastPlayCredit;

    private int lastPlayMode;

    private int lastPlaceId;

    private String lastPlaceName;

    private int lastAllNetId;

    private int lastRegionId;

    private String lastRegionName;

    private String lastClientId;

    private String lastCountryCode;

    private int lastSelectEMoney;

    private int lastSelectTicket;

    private int lastSelectCourse;

    private int lastCountCourse;

    private String firstGameId;

    private String firstRomVersion;

    private String firstDataVersion;

    private String firstPlayDate;

    private String compatibleCmVersion;

    private String dailyBonusDate;

    private String dailyCourseBonusDate;

    private int playVsCount;

    private int playSyncCount;

    private int winCount;

    private int helpCount;

    private int comboCount;

    private long totalDeluxscore;

    private long totalBasicDeluxscore;

    private long totalAdvancedDeluxscore;

    private long totalExpertDeluxscore;

    private long totalMasterDeluxscore;

    private long totalReMasterDeluxscore;

    private int totalSync;

    private int totalBasicSync;

    private int totalAdvancedSync;

    private int totalExpertSync;

    private int totalMasterSync;

    private int totalReMasterSync;

    private long totalAchievement;

    private long totalBasicAchievement;

    private long totalAdvancedAchievement;

    private long totalExpertAchievement;

    private long totalMasterAchievement;

    private long totalReMasterAchievement;

    private Long dateTime;

    private long playerOldRating;

    private long playerNewRating;

    private String lastPairLoginDate;

    private String lastTrialPlayDate;

    private int banState;

    private int mapStock;

    private int currentPlayCount;

    private int renameCredit;
}
