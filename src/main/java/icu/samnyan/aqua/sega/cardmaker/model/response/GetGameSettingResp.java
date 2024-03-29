package icu.samnyan.aqua.sega.cardmaker.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import icu.samnyan.aqua.sega.cardmaker.model.response.data.GameSetting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetGameSettingResp {
    private GameSetting gameSetting;
    @JsonProperty("isDumpUpload")
    private boolean isDumpUpload;
    @JsonProperty("isAou")
    private boolean isAou;
}

