package icu.samnyan.aqua.sega.mai2.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity(name = "Mai2UserGhost")
@Table(name = "mai2_user_ghost")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGhost implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    private String name;

    private int iconId;

    private int plateId;

    private int titleId;

    private int rate;

    private int udemaeRate;

    private String playDatetime;

    private int shopId;

    private int regionCode;

    private int typeId;

    private int musicId;

    private int difficulty;

    private int version;

    @Column(columnDefinition = "TEXT")
    @Convert(converter = IntArrayToString.class)
    private List<Integer> resultBitList;

    private int resultNum;

    private int achievement;
}
