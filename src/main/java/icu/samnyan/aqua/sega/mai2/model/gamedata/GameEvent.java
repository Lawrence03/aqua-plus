package icu.samnyan.aqua.sega.mai2.model.gamedata;

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
@Entity(name = "Mai2GameEvent")
@Table(name = "mai2_game_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    public int type;

    @JsonProperty("id")
    public int eventId;

    public String startDate;

    public String endDate;
}