package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class OutTransactionRequest {
    private Long id;
    private Integer currency;
    private BigDecimal amount;
    private BigDecimal fee;
    private String address;
    private Long owner_id;
    private LocalDateTime created_at;
    private Boolean is_started;
    private Boolean subtract_fee_from_amount;
    private String btc_core_wallet_private_key;
}
