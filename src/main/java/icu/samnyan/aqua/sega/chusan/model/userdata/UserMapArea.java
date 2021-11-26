package icu.samnyan.aqua.sega.chusan.model.userdata;

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
@Entity(name = "C3UserMapArea")
@Table(name = "c3_user_map_area", uniqueConstraints = {@UniqueConstraint(columnNames = {"profile_id", "map_area_id"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMapArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UserData user;

    @Column(name = "map_area_id")
    private int mapAreaId;

    private int position;

    @JsonProperty("isClear")
    private boolean isClear;

    private int rate;

    private int statusCount;

    private int remainGridCount;

    @JsonProperty("isLocked")
    private boolean isLocked;

    public UserMapArea(UserData userData) {
        user = userData;
    }
}
