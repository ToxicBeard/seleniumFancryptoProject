package is.toxic.db.common.repository;

import is.toxic.db.common.dto.TimeTableItemSnapshot;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimeTableItemSnapshotRepository implements CrudRepository<Long, TimeTableItemSnapshot> {

    private final DSLContext dsl;

    @Autowired
    public TimeTableItemSnapshotRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

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
    public TimeTableItemSnapshot find(Condition condition) {
        return dsl.selectFrom(is.toxic.db.data.tables.TimeTableItemSnapshot.TIME_TABLE_ITEM_SNAPSHOT)
                .where(condition)
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
