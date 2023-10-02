package icu.samnyan.aqua.sega.mai2.model.userdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Mai2User2pPlaylog")
@Table(name = "mai2_user_2p_playlog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User2pPlaylog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    private long userId1;

    private long userId2;

    private String userName1;

    private String userName2;

    private int regionId;

    private int placeId;
}
