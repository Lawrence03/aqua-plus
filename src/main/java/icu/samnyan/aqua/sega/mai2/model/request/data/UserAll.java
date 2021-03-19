package icu.samnyan.aqua.sega.mai2.model.request.data;

import icu.samnyan.aqua.sega.mai2.model.userdata.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAll implements Serializable {
    private List<UserData> userData;
    private List<UserExtend> userExtend;
    private List<UserOption> userOption;
    private List<UserCharacter> userCharacterList;
    private List<UserGhost> userGhost;
    private List<UserMap> userMapList;
    private List<UserLoginBonus> userLoginBonusList;
    private List<UserRating> userRatingList;
    private List<UserItem> userItemList;
    private List<UserMusicDetail> userMusicDetailList;
    private List<UserFavorite> userFavoriteList;
    private List<UserActivityList> userActivityList;
    private String isNewCharacterList;
}
