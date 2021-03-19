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
@Entity(name = "Mai2UserMap")
@Table(name = "mai2_user_map")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMap implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    private int mapId;

    private int distance;

    @JsonProperty("isLock")
    private boolean isLock;

    @JsonProperty("isClear")
    private boolean isClear;

    @JsonProperty("isComplete")
    private boolean isComplete;

    public UserMap(UserData user) {
        this.user = user;
    }
}
