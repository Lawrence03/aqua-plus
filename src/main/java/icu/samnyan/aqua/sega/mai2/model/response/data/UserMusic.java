package icu.samnyan.aqua.sega.mai2.model.response.data;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserMusicDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMusic {
    List<UserMusicDetail> userMusicDetailList;
}
