package icu.samnyan.aqua.sega.chusan.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Entity(name = "C3UserGameOption")
@Table(name = "c3_user_game_option")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGameOption implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UserData user;

    private int bgInfo;

    private int fieldColor;

    private int guideSound;

    private int soundEffect;

    private int guideLine;

    private int speed;

    private int optionSet;

    private int matching;

    private int judgePos;

    private int rating;

    private int judgeCritical;

    private int judgeJustice;

    private int judgeAttack;

    private int headphone;

    private int playerLevel;

    private int successTap;

    private int successExTap;

    private int successSlideHold;

    private int successAir;

    private int successFlick;

    private int successSkill;

    private int successTapTimbre;

    private int privacy;

    private int mirrorFumen;

    private int selectMusicFilterLv;

    private int sortMusicFilterLv;

    private int sortMusicGenre;

    private int categoryDetail;

    private int judgeTimingOffset;

    private int playTimingOffset;

    private int fieldWallPosition;

    private int resultVoiceShort;

    private int notesThickness;

    private int judgeAppendSe;

    private int trackSkip;

    private int hardJudge;

    private int speed_120;

    private int fieldWallPosition_120;

    private int playTimingOffset_120;

    private int judgeTimingOffset_120;

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

    private int judgeSlideHold;

    private int judgeTap;

    public UserGameOption(UserData userData) {
        user = userData;
    }
}
