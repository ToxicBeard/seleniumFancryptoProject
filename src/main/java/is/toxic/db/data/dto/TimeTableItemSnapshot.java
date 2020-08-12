package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimeTableItemSnapshot {
    private Long key;
    private Integer day;
    private Short start;
    private Short end;
    private Long advertisement_snapshot_key;
}
