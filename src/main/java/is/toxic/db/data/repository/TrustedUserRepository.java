package is.toxic.db.data.repository;

import is.toxic.db.data.dto.TrustedUser;
import is.toxic.db.data.tables.TrustedUsers;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TrustedUserRepository implements CrudRepository<Long, TrustedUser> {

    private final DSLContext dsl;


    @Override
    public TrustedUser insert(TrustedUser trustedUser) {
        return dsl.insertInto(TrustedUsers.TRUSTED_USERS)
                .set(dsl.newRecord(TrustedUsers.TRUSTED_USERS, trustedUser))
                .returning()
                .fetchOne()
                .into(TrustedUser.class);
    }

    @Override
    public TrustedUser update(TrustedUser trustedUser) {
        return dsl.update(TrustedUsers.TRUSTED_USERS)
                .set(dsl.newRecord(TrustedUsers.TRUSTED_USERS, trustedUser))
                .where(TrustedUsers.TRUSTED_USERS.ID.eq(trustedUser.getId()))
                .returning()
                .fetchOne()
                .into(TrustedUser.class);
    }

    @Override
    public TrustedUser find(Long id) {
        return dsl.selectFrom(TrustedUsers.TRUSTED_USERS)
                .where(TrustedUsers.TRUSTED_USERS.ID.eq(id))
                .fetchAny()
                .into(TrustedUser.class);
    }

    @Override
    public List<TrustedUser> findAll(Condition condition) {
        return dsl.selectFrom(TrustedUsers.TRUSTED_USERS)
                .where(condition)
                .fetch()
                .into(TrustedUser.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(TrustedUsers.TRUSTED_USERS)
                .where(TrustedUsers.TRUSTED_USERS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
