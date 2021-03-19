package icu.samnyan.aqua.sega.mai2.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import icu.samnyan.aqua.sega.mai2.model.request.data.MapEncountNpc;
import icu.samnyan.aqua.sega.util.hibernate.EncountMapNpcListConverter;
import icu.samnyan.aqua.sega.util.hibernate.IntArrayToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Entity(name = "Mai2UserExtend")
@Table(name = "mai2_user_extend")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExtend implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    private int selectMusicId;

    private int selectDifficultyId;

    private int categoryIndex;

    private int musicIndex;

    private int extraFlag;

    private int selectScoreType;

    private Long extendContentBit = 0L;

    @JsonProperty("isPhotoAgree")
    private Boolean isPhotoAgree = false;

    @JsonProperty("isGotoCodeRead")
    private Boolean isGotoCodeRead = false;

    private boolean selectResultDetails;

    private int sortCategorySetting;

    private int sortMusicSetting;

    // Int array
    @Convert(converter = IntArrayToString.class)
    private List<Integer> selectedCardList;

    // Object array
    @Convert(converter = EncountMapNpcListConverter.class)
    private List<MapEncountNpc> encountMapNpcList;

    public UserExtend(UserData user) {
        this.user = user;
    }
}
