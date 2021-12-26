package icu.samnyan.aqua.sega.cardmaker.model.response.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameSetting {
    private String dataVersion;
    private String ongekiCmVersion;
    private String chuniCmVersion;
    private String maimaiCmVersion;
    private int requestInterval;
    @JsonProperty("isMaintenance")
    private boolean isMaintenance;
    private boolean watermark;
    private String rebootStartTime;
    private String rebootEndTime;
    private int maxCountCharacter;
    private int maxCountCard;
    private int maxCountItem;
    @JsonProperty("isBackgroundDistribute")
    private boolean isBackgroundDistribute;
}
