package icu.samnyan.aqua.sega.chusan.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "C3UserCMissionProgress")
@Table(name = "c3_user_cmission_progress")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCMissionProgress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(name = "order_id")
    private int order;

    private int progress;

    private int stage;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "mission_id")
    private UserCMission userCMission;;

    public UserCMissionProgress(UserCMission userCMission) {
        this.userCMission = userCMission;
    }
}
