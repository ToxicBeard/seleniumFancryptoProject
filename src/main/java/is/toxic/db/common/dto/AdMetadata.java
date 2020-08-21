package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AdMetadata {
    private Long id;
    private Integer status;
    private BigDecimal max_amount;
    private BigDecimal price;
    private Long advertisement_id;
}
