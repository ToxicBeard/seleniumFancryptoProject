package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class InvoicePayment {
    private Long id;
    private Long invoice_fk;
    private BigDecimal crypto_amount;
    private BigDecimal fiat_price;
    private BigDecimal fiat_amount;
    private BigDecimal fee;
    private LocalDateTime created_at;
    private Long user_data_fk;
    private String confirmation;
    private Integer pieces;
}
