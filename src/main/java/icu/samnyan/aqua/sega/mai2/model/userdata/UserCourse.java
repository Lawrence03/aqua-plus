package icu.samnyan.aqua.sega.mai2.model.userdata;

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
@Entity(name = "Mai2UserCourse")
@Table(name = "mai2_user_course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

		private int courseId;

    @JsonProperty("isLastClear")
		private boolean isLastClear;

		private int totalRestlife;

		private int totalAchievement;

		private int totalDeluxscore;

		private int playCount;

		private String clearDate;

		private String lastPlayDate;

		private int bestAchievement;

		private String bestAchievementDate;

		private int bestDeluxscore;

		private String bestDeluxscoreDate;
    public UserCourse(UserData user) {
        this.user = user;
    }
}
