package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class AdvertisementSnapshot {

    boolean is_buy;
    boolean monitor_liquidity;
    boolean not_anonymous;
    boolean phone_confirmed;
    boolean trusted;
    boolean is_enabled;
    private Long key;
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
    private Long owner_key;
    private String title;
    private Long window;
    private Long metadata_key;
}
