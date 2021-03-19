package icu.samnyan.aqua.sega.mai2.model.request.data;

import icu.samnyan.aqua.sega.mai2.model.userdata.UserActivity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserActivityList implements Serializable {
    private List<UserActivity> playList;
    private List<UserActivity> musicList;
}
