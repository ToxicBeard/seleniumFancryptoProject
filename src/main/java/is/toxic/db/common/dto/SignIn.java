package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SignIn {

    private Long id;
    private String username;
    private String client_name;
    private LocalDateTime created_at;
    private String ip;
    private String result;
}
