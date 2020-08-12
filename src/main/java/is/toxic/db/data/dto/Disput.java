package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Disput {
    private Long id;
    private LocalDateTime created_at;
    private String jira_request_key;
}
