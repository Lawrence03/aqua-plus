package icu.samnyan.aqua.sega.mai2.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Mai2User2pPlaylogDetail")
@Table(name = "mai2_user_2p_playlog_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User2pPlaylogDetail  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    private int musicId;

    private int level;

    private int achievement;

    private int deluxscore;

    private String userPlayDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "playlog_id")
    private User2pPlaylog playlog;
}
