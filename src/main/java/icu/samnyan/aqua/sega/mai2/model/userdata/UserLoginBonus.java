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
@Entity(name = "Mai2UserLoginBonus")
@Table(name = "mai2_user_login_bonus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginBonus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    private int bonusId;

    private int point;

    @JsonProperty("isCurrent")
    private boolean isCurrent;

    @JsonProperty("isComplete")
    private boolean isComplete;

    public UserLoginBonus(UserData user) {
        this.user = user;
    }
}
