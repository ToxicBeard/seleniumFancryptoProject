package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Feedback {
    private Long id;
    private Long from_id;
    private Long to_id;
    private LocalDateTime created_at;
    private Boolean is_positive;
    private String text;
}
