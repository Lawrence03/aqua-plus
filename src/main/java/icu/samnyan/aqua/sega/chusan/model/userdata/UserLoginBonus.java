package icu.samnyan.aqua.sega.chusan.model.userdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "C3UserLoginBonus")
@Table(name = "c3_user_login_bonus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginBonus implements Serializable {

    @Id
    private int id;

}
