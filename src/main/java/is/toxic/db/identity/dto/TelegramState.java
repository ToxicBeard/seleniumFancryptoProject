package is.toxic.db.identity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TelegramState {
    private Long id;
    private Integer telegram_user_id;
    private String data;
    private Long active_deal_id;
    private String user_id;
}
