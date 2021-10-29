package icu.samnyan.aqua.sega.mai2.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Entity(name = "Mai2UserFriendSeasonRanking")
@Table(name = "mai2_user_friend_season_ranking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFriendSeasonRanking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    private int seasonId;

    private int point;

    private int rank;

    @JsonProperty("rewardGet")
    private boolean rewardGet;

    private String userName;

    private String recordDate;

    public UserFriendSeasonRanking(UserData user) {
        this.user = user;
    }
}
