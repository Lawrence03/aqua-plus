package icu.samnyan.aqua.sega.cardmaker.model.ongeki;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "CardmakerOngekiUserCard")
@Table(name = "cardmaker_ongeki_user_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int cardId;

}
