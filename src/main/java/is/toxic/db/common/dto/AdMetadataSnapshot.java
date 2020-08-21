package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AdMetadataSnapshot {
    private Long key;
    private Integer status;
    private BigDecimal max_amount;
    private BigDecimal price;
}
