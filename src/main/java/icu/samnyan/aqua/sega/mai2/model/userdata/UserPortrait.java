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
@Entity(name = "Mai2UserPortrait")
@Table(name = "mai2_user_portrait")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPortrait implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    private int userId;
    
    private int divNumber;

    private int divLength;

    @Column(columnDefinition = "TEXT")
    private String divData;

    private int placeId;

    private String clientId;

    private String uploadDate;

    private String fileName;
}
