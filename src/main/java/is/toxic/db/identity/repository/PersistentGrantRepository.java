package is.toxic.db.identity.repository;

import is.toxic.db.identity.dto.PersistentGrant;
import is.toxic.db.identity.tables.PersistedGrants;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PersistentGrantRepository implements CrudRepository<String, PersistentGrant> {

    private final DSLContext dsl;

    @Override
    public PersistentGrant insert(PersistentGrant persistentGrant) {
        return dsl.insertInto(PersistedGrants.PERSISTED_GRANTS)
                .set(dsl.newRecord(PersistedGrants.PERSISTED_GRANTS, persistentGrant))
                .returning()
                .fetchOne()
                .into(PersistentGrant.class);
    }

    @Override
    public PersistentGrant update(PersistentGrant persistentGrant) {
        return dsl.update(PersistedGrants.PERSISTED_GRANTS)
                .set(dsl.newRecord(PersistedGrants.PERSISTED_GRANTS, persistentGrant))
                .where(PersistedGrants.PERSISTED_GRANTS.KEY.eq(persistentGrant.getClient_id()))
                .returning()
                .fetchOne()
                .into(PersistentGrant.class);
    }

    @Override
    public PersistentGrant find(String id) {
        return dsl.selectFrom(PersistedGrants.PERSISTED_GRANTS)
                .where(PersistedGrants.PERSISTED_GRANTS.KEY.eq(id))
                .fetchAny()
                .into(PersistentGrant.class);
    }

    @Override
    public List<PersistentGrant> findAll(Condition condition) {
        return dsl.selectFrom(PersistedGrants.PERSISTED_GRANTS)
                .where(condition)
                .fetch()
                .into(PersistentGrant.class);
    }

    @Override
    public Boolean delete(String id) {
        return dsl.deleteFrom(PersistedGrants.PERSISTED_GRANTS)
                .where(PersistedGrants.PERSISTED_GRANTS.KEY.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
