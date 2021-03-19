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
@Entity(name = "Mai2UserCharacter")
@Table(name = "mai2_user_character")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCharacter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    private int characterId;

    private int level;

    private int awakening;

    private int useCount;

    public UserCharacter(UserData user) {
        this.user = user;
    }
}
