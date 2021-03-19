package icu.samnyan.aqua.sega.mai2.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Entity(name = "Mai2UserMusicDetail")
@Table(name = "mai2_user_music_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMusicDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    private int musicId;

    private int level;

    private int playCount;

    private int achievement;

    private int comboStatus;

    private int syncStatus;

    private int deluxscoreMax;

    private int scoreRank;

    public UserMusicDetail(UserData user) {
        this.user = user;
    }
}
