package is.toxic.db.identity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AspNetUserClaim {
    private Integer id;
    private String user_id;
    private String claim_type;
    private String claim_value;
}
