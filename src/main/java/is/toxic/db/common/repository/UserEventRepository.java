package is.toxic.db.common.repository;

import is.toxic.db.common.dto.UserEvent;
import is.toxic.db.data.tables.UserEvents;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserEventRepository implements CrudRepository<Long, UserEvent> {

    private final DSLContext dsl;

    @Autowired
    public UserEventRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public UserEvent insert(UserEvent userEvent) {
        return dsl.insertInto(UserEvents.USER_EVENTS)
                .set(dsl.newRecord(UserEvents.USER_EVENTS, userEvent))
                .returning()
                .fetchOne()
                .into(UserEvent.class);
    }

    @Override
    public UserEvent update(UserEvent userEvent) {
        return dsl.update(UserEvents.USER_EVENTS)
                .set(dsl.newRecord(UserEvents.USER_EVENTS, userEvent))
                .where(UserEvents.USER_EVENTS.ID.eq(userEvent.getId()))
                .returning()
                .fetchOne()
                .into(UserEvent.class);
    }

    @Override
    public UserEvent find(Long id) {
        return dsl.selectFrom(UserEvents.USER_EVENTS)
                .where(UserEvents.USER_EVENTS.ID.eq(id))
                .fetchAny()
                .into(UserEvent.class);
    }

    @Override
    public UserEvent find(Condition condition) {
        return dsl.selectFrom(UserEvents.USER_EVENTS)
                .where(condition)
                .fetchAny()
                .into(UserEvent.class);
    }

    @Override
    public List<UserEvent> findAll(Condition condition) {
        return dsl.selectFrom(UserEvents.USER_EVENTS)
                .where(condition)
                .fetch()
                .into(UserEvent.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(UserEvents.USER_EVENTS)
                .where(UserEvents.USER_EVENTS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
