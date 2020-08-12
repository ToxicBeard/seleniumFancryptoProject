package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class OutTransaction {
    private Long id;
    private String tx_id;
    private String address;
    private BigDecimal amount;
    private Integer confirmations;
    private LocalDateTime time;
    private BigDecimal fee;
    private String wallet_private_key;
    private Long request_id;
}
