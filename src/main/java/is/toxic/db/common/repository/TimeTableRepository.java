package is.toxic.db.common.repository;

import is.toxic.db.common.dto.TimeTable;
import is.toxic.db.data.tables.TimeTables;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimeTableRepository implements CrudRepository<Long, TimeTable> {

    private final DSLContext dsl;

    @Autowired
    public TimeTableRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public TimeTable insert(TimeTable timeTable) {
        return dsl.insertInto(TimeTables.TIME_TABLES)
                .set(dsl.newRecord(TimeTables.TIME_TABLES, timeTable))
                .returning()
                .fetchOne()
                .into(TimeTable.class);
    }

    @Override
    public TimeTable update(TimeTable timeTable) {
        return dsl.update(TimeTables.TIME_TABLES)
                .set(dsl.newRecord(TimeTables.TIME_TABLES, timeTable))
                .where(TimeTables.TIME_TABLES.ID.eq(timeTable.getId()))
                .returning()
                .fetchOne()
                .into(TimeTable.class);
    }

    @Override
    public TimeTable find(Long id) {
        return dsl.selectFrom(TimeTables.TIME_TABLES)
                .where(TimeTables.TIME_TABLES.ID.eq(id))
                .fetchAny()
                .into(TimeTable.class);
    }

    @Override
    public TimeTable find(Condition condition) {
        return dsl.selectFrom(TimeTables.TIME_TABLES)
                .where(condition)
                .fetchAny()
                .into(TimeTable.class);
    }

    @Override
    public List<TimeTable> findAll(Condition condition) {
        return dsl.selectFrom(TimeTables.TIME_TABLES)
                .where(condition)
                .fetch()
                .into(TimeTable.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(TimeTables.TIME_TABLES)
                .where(TimeTables.TIME_TABLES.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
