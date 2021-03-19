package icu.samnyan.aqua.sega.mai2.model.request.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPhoto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int orderId;

    private long userId;

    private int divNumber;

    private int divLength;

    private String divData;

    private int placeId;

    private String clientId;

    private String uploadDate;

    private long playlogId;

    private int trackNo;
}
