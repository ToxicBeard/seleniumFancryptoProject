package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LastAdSearchParam {
    private Long id;
    private Long owner_fk;
    private Integer country;
    private Integer currency;
    private Integer payment_type;
    private BigDecimal amount;
    private Boolean is_buy;
}
