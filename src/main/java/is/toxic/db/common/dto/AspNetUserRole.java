package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AspNetUserRole {

    private String user_id;
    private String role_id;
}
