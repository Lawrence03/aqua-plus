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
@Entity(name = "Mai2UserFavorite")
@Table(name = "mai2_user_favourite")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFavorite implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    private int itemKind;

    @Convert(converter = IntArrayToString.class)
    private List<Integer> itemIdList;

    public UserFavorite(UserData user) {
        this.user = user;
    }
}
