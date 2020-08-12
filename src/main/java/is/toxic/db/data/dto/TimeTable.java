package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimeTable {
    private Long id;
    private Integer day;
    private Short start;
    private Short end;
    private Long advertisement_id;
}
