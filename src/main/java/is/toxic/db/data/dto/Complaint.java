package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Complaint {

    private Long id;
    private String text;
    private String from_contact;
    private LocalDateTime created_at;
    private Integer status;
}
