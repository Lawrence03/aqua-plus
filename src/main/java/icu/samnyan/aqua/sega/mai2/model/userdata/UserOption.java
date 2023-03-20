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
@Entity(name = "Mai2UserOption")
@Table(name = "mai2_user_option")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOption implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    private int optionKind;

    private int noteSpeed;

    private int slideSpeed;

    private int touchSpeed;

    private int tapDesign;

    private int holdDesign;

    private int slideDesign;

    private int starType;

    private int outlineDesign;

    private int noteSize;

    private int slideSize;

    private int touchSize;

    private int starRotate;

    private int dispCenter;

    private int dispChain;

    private int dispRate;

    private int dispBar;

    private int touchEffect;

    private int submonitorAnimation;

    private int submonitorAchive;

    private int submonitorAppeal;

    private int matching;

    private int trackSkip;

    private int brightness;

    private int mirrorMode;

    private int dispJudge;

    private int dispJudgePos;

    private int dispJudgeTouchPos;

    private int adjustTiming;

    private int JudgeTiming;

    private int ansVolume;

    private int tapHoldVolume;

    private int criticalSe;

    private int breakSe;

    private int breakVolume;

    private int exSe;

    private int exVolume;

    private int slideSe;

    private int slideVolume;

    private int touchHoldVolume;

    private int headPhoneVolume;

    private int sortTab;

    private int sortMusic;

    private int outFrameType;

    private int breakSlideVolume;

    private int touchVolume;

    public UserOption(UserData user) {
        this.user = user;
    }
}
