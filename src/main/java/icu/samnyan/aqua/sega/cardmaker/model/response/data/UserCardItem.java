package icu.samnyan.aqua.sega.cardmaker.model.response.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCardItem {
    private int cardId;
    private int digitalStock;
    private int analogStock;
    private int level;
    private int maxLevel;
    private int exp;
    private int printCount;
    private int useCount;
    private String kaikaDate;
    private String choKaikaDate;
    private int skillId;
    private String created;
    private boolean isNew;
    private boolean isAcquired;
}
