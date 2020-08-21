package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PersistentGrant {

    private String key;
    private String type;
    private String subject_id;
    private String client_id;
    private LocalDateTime creation_time;
    private LocalDateTime expiration;
    private String data;
    private String remote_ip;
    private LocalDateTime last_modifed;
}
