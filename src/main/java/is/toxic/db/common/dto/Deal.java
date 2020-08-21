package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Deal {
    private Long id;
    private BigDecimal fiat_amount;
    private BigDecimal crypto_amount;
    private LocalDateTime created_at;
    private Integer status;
    private LocalDateTime completed_at;
    private LocalDateTime canceled_at;
    private Boolean is_fiat_payed;
    private LocalDateTime fiat_payed_at;
    private Long ad_owner_feed_back_id;
    private Long initiator_feedback_id;
    private Long dispute_id;
    private Long ad_snapshot_key;
    private Long initiator_snapshot_key;
    private String wallet;
    private BigDecimal fee;
}
