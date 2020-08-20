package is.toxic.db.identity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AspNetRoleClaim {

    private Integer id;
    private String role_id;
    private String claim_type;
    private String claim_value;
}
