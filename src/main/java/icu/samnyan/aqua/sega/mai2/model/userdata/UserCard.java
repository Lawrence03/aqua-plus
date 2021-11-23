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
@Entity(name = "Mai2UserCard")
@Table(name = "mai2_user_card")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    private int cardId;

    private int cardTypeId;

    private int charaId;

    private int mapId;

    private String startDate;

    private String endDate;

    public UserCard(UserData user) {
        this.user = user;
    }
}
