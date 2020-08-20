package is.toxic.db.identity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AspNetUserLogin {

    private String login_provider;
    private String provider_key;
    private String provider_display_name;
    private String user_id;
}
