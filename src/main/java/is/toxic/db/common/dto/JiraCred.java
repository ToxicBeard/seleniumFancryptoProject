package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JiraCred {
    private Long id;
    private String username;
    private String key;
    private String password;
}
