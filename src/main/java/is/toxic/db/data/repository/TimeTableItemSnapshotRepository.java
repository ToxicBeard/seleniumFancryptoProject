package is.toxic.db.data.repository;

import is.toxic.db.data.dto.TimeTableItemSnapshot;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TimeTableItemSnapshotRepository implements CrudRepository<Long, TimeTableItemSnapshot> {

    private final DSLContext dsl;


    @Override
    public TimeTableItemSnapshot insert(TimeTableItemSnapshot timeTableItemSnapshot) {
        return dsl.insertInto(is.toxic.db.data.tables.TimeTableItemSnapshot.TIME_TABLE_ITEM_SNAPSHOT)
                .set(dsl.newRecord(is.toxic.db.data.tables.TimeTableItemSnapshot.TIME_TABLE_ITEM_SNAPSHOT, timeTableItemSnapshot))
                .returning()
                .fetchOne()
                .into(TimeTableItemSnapshot.class);
    }

    @Override
    public TimeTableItemSnapshot update(TimeTableItemSnapshot timeTableItemSnapshot) {
        return dsl.update(is.toxic.db.data.tables.TimeTableItemSnapshot.TIME_TABLE_ITEM_SNAPSHOT)
                .set(dsl.newRecord(is.toxic.db.data.tables.TimeTableItemSnapshot.TIME_TABLE_ITEM_SNAPSHOT, timeTableItemSnapshot))
                .where(is.toxic.db.data.tables.TimeTableItemSnapshot.TIME_TABLE_ITEM_SNAPSHOT.KEY.eq(timeTableItemSnapshot.getKey()))
                .returning()
                .fetchOne()
                .into(TimeTableItemSnapshot.class);
    }

    @Override
    public TimeTableItemSnapshot find(Long id) {
        return dsl.selectFrom(is.toxic.db.data.tables.TimeTableItemSnapshot.TIME_TABLE_ITEM_SNAPSHOT)
                .where(is.toxic.db.data.tables.TimeTableItemSnapshot.TIME_TABLE_ITEM_SNAPSHOT.KEY.eq(id))
                .fetchAny()
                .into(TimeTableItemSnapshot.class);
    }

    @Override
    public List<TimeTableItemSnapshot> findAll(Condition condition) {
        return dsl.selectFrom(is.toxic.db.data.tables.TimeTableItemSnapshot.TIME_TABLE_ITEM_SNAPSHOT)
                .where(condition)
                .fetch()
                .into(TimeTableItemSnapshot.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(is.toxic.db.data.tables.TimeTableItemSnapshot.TIME_TABLE_ITEM_SNAPSHOT)
                .where(is.toxic.db.data.tables.TimeTableItemSnapshot.TIME_TABLE_ITEM_SNAPSHOT.KEY.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
