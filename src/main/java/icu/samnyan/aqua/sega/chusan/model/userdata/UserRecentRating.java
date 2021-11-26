package icu.samnyan.aqua.sega.chusan.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Entity(name = "C3UserRecentRating")
@Table(name = "c3_user_recent_rating", uniqueConstraints = {@UniqueConstraint(columnNames = {"profile_id", "sort_order"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRecentRating implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UserData user;

    @JsonIgnore
    @Column(name = "sort_order")
    private int sortOrder;

    private int musicId;

    private int difficultId;

    private int romVersionCode;

    private int score;

    public UserRecentRating(UserData userData) {
        user = userData;
    }
}
