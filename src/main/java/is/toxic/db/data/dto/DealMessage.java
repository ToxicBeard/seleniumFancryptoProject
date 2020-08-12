package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DealMessage {

    private Long id;
    private LocalDateTime created_at;
    private Long owner_id;
    private String text;
    private Long deal_id;
}
