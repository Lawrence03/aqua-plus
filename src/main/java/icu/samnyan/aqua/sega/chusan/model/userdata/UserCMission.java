package icu.samnyan.aqua.sega.chusan.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "C3UserCMission")
@Table(name = "c3_user_cmission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCMission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UserData user;

    private int missionId;

    private int point;

    @OneToMany(mappedBy = "userCMission", cascade = CascadeType.ALL)
    private List<UserCMissionProgress> userCMissionProgressList;

    public UserCMission(UserData userData) {
        user = userData;
    }
}
