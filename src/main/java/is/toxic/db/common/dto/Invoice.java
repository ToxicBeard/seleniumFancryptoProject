package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Invoice {
    private Long id;
    private Boolean is_private;
    private Boolean is_base_crypto;
    private String user_name;
    private Integer fiat_currency;
    private Integer ttl_minutes;
    private String price_variable;
    private String comment;
    private Integer pieces_max;
    private Integer pieces_min;
    private BigDecimal price;
    private BigDecimal amount_payed_crypto;
    private BigDecimal amount_payed_fiat;
    private LocalDateTime created_at;
    private BigDecimal current_crypto_amount;
    private LocalDateTime deleted_at;
    private LocalDateTime expire_time;
    private Long owner_fk;
    private Integer payments_count;
    private Integer status;
    private Long target_user_fk;
    private BigDecimal fee;
    private Boolean target_deleted;
    private Boolean limit_liquidity;
}
