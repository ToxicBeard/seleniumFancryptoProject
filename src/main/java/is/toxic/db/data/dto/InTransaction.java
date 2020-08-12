package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class InTransaction {
    private Long id;
    private String tx_id;
    private Long address_id;
    private BigDecimal amount;
    private Integer confirmations;
    private LocalDateTime time;
}
