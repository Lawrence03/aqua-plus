package icu.samnyan.aqua.sega.chusan.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Entity(name = "C3UserRegion")
@Table(name = "c3_user_region", uniqueConstraints = {@UniqueConstraint(columnNames = {"profile_id", "region_id"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UserData user;

    @Column(name = "region_id")
    private int regionId;

    private int playCount;

    private String created;

    public UserRegion(UserData userData) {
        user = userData;
    }
}
