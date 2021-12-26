package icu.samnyan.aqua.sega.cardmaker.model.mai;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "CardmakerMaiSellingCard")
@Table(name = "cardmaker_mai_selling_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellingCard implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int cardId;
}
