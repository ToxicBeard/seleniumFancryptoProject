package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Balance {
    private Long id;
    private Long owner_id;
    private Integer currency;
    private BigDecimal balance;
    private BigDecimal unconfirmed_balance;
    private BigDecimal deposited;
}
