package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class BTCCoreWallet {

    private String private_key;
    private BigDecimal fee;
    private LocalDateTime last_block;
    private BigDecimal balance;
    private BigDecimal unconfirmed_balance;
    private LocalDateTime max_transactions_time;
}
