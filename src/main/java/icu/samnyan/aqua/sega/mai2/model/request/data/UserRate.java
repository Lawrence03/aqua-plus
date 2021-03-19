package icu.samnyan.aqua.sega.mai2.model.request.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRate implements Serializable {
    private int musicId;
    private int level;
    private int romVersion;
    private int achievement;
}
