package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AspNetRole {

    private String id;
    private String name;
    private String normalized_name;
    private String concurrency_stamp;
}
