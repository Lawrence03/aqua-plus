package icu.samnyan.aqua.sega.general.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Entity(name = "AllowKeychipEntry")
@Table(name = "allow_keychip")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllowKeychip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String keychipId;

    @Column(unique = true)
    private String placeName;

    public AllowKeychip(String keychipId) {
        this.keychipId = keychipId;
    }


}
