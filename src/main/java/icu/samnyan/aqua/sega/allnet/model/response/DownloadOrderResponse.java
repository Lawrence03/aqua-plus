package icu.samnyan.aqua.sega.allnet.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DownloadOrderResponse implements PowerOnResponse {
    private int stat;
    private String uri;

    @Override
    public String toString() {
        return "stat=" + stat +
                "&uri=" + uri;
    }
}