package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CryptoExchangeVariable {

    private Integer key;
    private BigDecimal value;
}
