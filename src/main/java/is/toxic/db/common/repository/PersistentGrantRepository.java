package is.toxic.db.common.repository;

import is.toxic.db.common.dto.PersistentGrant;
import is.toxic.db.identity.tables.PersistedGrants;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersistentGrantRepository implements CrudRepository<String, PersistentGrant> {

    private final DSLContext dsl;

    @Autowired
    public PersistentGrantRepository(@Qualifier("dslIdentity") DSLContext dsl) {
        this.dsl = dsl;
    }

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
    public PersistentGrant find(Condition condition) {
        return dsl.selectFrom(PersistedGrants.PERSISTED_GRANTS)
                .where(condition)
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
