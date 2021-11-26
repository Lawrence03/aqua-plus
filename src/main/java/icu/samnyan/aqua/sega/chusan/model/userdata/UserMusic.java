package icu.samnyan.aqua.sega.chusan.model.userdata;

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
@Entity(name = "C3UserMusic")
@Table(name = "c3_user_music", uniqueConstraints = {@UniqueConstraint(columnNames = {"profile_id", "music_id", "level"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMusic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UserData user;

    @Column(name = "music_id")
    private int musicId;

    private int level;

    private int playCount;

    private int scoreMax;

    private int missCount;

    private int maxComboCount;

    @JsonProperty("isFullCombo")
    private boolean isFullCombo;

    @JsonProperty("isAllJustice")
    private boolean isAllJustice;

    @JsonProperty("isSuccess")
    private boolean isSuccess;

    private int fullChain;

    private int maxChain;

    private int scoreRank;

    @JsonProperty("isLock")
    private boolean isLock;

    private int theoryCount;

    private int ext1;

    public UserMusic(UserData userData) {
        user = userData;
    }
}
