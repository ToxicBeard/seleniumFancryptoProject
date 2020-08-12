package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BlockedUser {

    private Long id;
    private Long owner_id;
    private Long user_id;
}
