package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserEvent {
    private Long id;
    private Long creater_id;
    private Long receiver_id;
    private LocalDateTime created_at;
    private Integer type;
    private Long deal_id;
    private Long deal_message_id;
    private Integer source;
    private Long invoice_id;
    private Long invoice_payment_id;
}
