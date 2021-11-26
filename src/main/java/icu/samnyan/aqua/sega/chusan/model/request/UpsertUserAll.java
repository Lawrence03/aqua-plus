package icu.samnyan.aqua.sega.chusan.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import icu.samnyan.aqua.sega.chusan.model.userdata.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertUserAll implements Serializable {

    @Nullable
    private List<UserData> userData;

    @Nullable
    private List<UserGameOption> userGameOption;

    @Nullable
    private List<UserMapArea> userMapAreaList;

    @Nullable
    private List<UserCharacter> userCharacterList;

    @Nullable
    private List<UserItem> userItemList;

    @Nullable
    private List<UserMusic> userMusicDetailList;

    @Nullable
    private List<UserActivity> userActivityList;

    @Nullable
    private List<UserRecentRating> userRecentRatingList;

    @Nullable
    private List<UserCharge> userChargeList;

    @Nullable
    private List<UserPlaylog> userPlaylogList;

    @Nullable
    private List<UserCourse> userCourseList;

    @Nullable
    private List<UserDuel> userDuelList;

    @Nullable
    @JsonProperty("isNewMapList")
    private String isNewMapList;

    @Nullable
    @JsonProperty("isNewCharacterList")
    private String isNewCharacterList;

    @Nullable
    @JsonProperty("isNewMusicDetailList")
    private String isNewMusicDetailList;

    @Nullable
    @JsonProperty("isNewItemList")
    private String isNewItemList;

    @Nullable
    @JsonProperty("isNewCourseList")
    private String isNewCourseList;

    @Nullable
    @JsonProperty("isNewDuelList")
    private String isNewDuelList;

}
