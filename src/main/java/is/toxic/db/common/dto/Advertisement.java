package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Advertisement {

    private Long id;
    private String equation;
    private BigDecimal min_amount;
    private BigDecimal max_amount;
    private String message;
    private LocalDateTime created_at;
    private Integer country;
    private Integer payment_type;
    private Integer fiat_currency;
    private Integer crypto_currency;
    private Boolean is_buy;
    private Long owner_id;
    private Boolean monitor_liquidity;
    private Boolean not_anonymous;
    private Boolean phone_confirmed;
    private Boolean trusted;
    private String title;
    private Long window;
    private Boolean is_enabled;
}
