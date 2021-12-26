package icu.samnyan.aqua.sega.cardmaker.model.response.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellingCardItem {
    private int cardId;
    private String startDate;
    private String endDate;
    private String noticeStartDate;
    private String noticeEndDate;
}
