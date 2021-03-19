package icu.samnyan.aqua.sega.mai2.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResp {
    public int returnCode = 1;
    public String lastLoginDate = "";
    public int loginCount = 0;
    public int consecutiveLoginCount = 0;
    public long loginId = 0L;
}
