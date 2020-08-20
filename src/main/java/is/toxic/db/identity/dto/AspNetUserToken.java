package is.toxic.db.identity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AspNetUserToken {

    private String user_id;
    private String login_provider;
    private String name;
    private String value;
}
