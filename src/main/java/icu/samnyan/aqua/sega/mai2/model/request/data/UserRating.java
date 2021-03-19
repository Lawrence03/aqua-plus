package icu.samnyan.aqua.sega.mai2.model.request.data;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserUdemae;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {
    private int rating;
    private List<UserRate> ratingList;
    private List<UserRate> newRatingList;
    private List<UserRate> nextRatingList;
    private List<UserRate> nextNewRatingList;
    private UserUdemae udemae = null;
}
