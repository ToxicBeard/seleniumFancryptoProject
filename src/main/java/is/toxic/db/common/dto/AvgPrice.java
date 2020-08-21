package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AvgPrice {
    private Integer id;
    private Integer fiat_currency;
    private Integer crypto_currency;
    private BigDecimal value;
}
