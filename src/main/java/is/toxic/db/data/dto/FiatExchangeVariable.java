package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class FiatExchangeVariable {
    private Integer key;
    private BigDecimal value;
}
