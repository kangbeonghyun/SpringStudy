package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 빠른, 일반, 느림
 *
 * */
@Data
@AllArgsConstructor
public class DeliveryCode {

    private String code;
    private String displayName;

}
