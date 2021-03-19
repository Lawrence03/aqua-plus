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
@Entity(name = "Mai2UserUdemae")
@Table(name = "mai2_user_udemae")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUdemae implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    private int rate;

    private int totalWinNum;

    private int totalLoseNum;

    private int maxWinNum;

    private int maxLoseNum;

    private int winNum;

    private int loseNum;

    private int npcTotalWinNum;

    private int npcTotalLoseNum;

    private int npcMaxWinNum;

    private int npcMaxLoseNum;

    private int npcWinNum;

    private int npcLoseNum;

    public UserUdemae(UserData user) {
        this.user = user;
    }
}