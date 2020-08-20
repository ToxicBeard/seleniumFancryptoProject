package is.toxic.db.identity.repository;

import is.toxic.db.identity.dto.AspNetUserLogin;
import is.toxic.db.identity.tables.AspNetUserLogins;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AspNetUserLoginRepository implements CrudRepository<String, AspNetUserLogin> {

    private final DSLContext dsl;

    @Override
    public AspNetUserLogin insert(AspNetUserLogin aspNetUserLogin) {
        return dsl.insertInto(AspNetUserLogins.ASP_NET_USER_LOGINS)
                .set(dsl.newRecord(AspNetUserLogins.ASP_NET_USER_LOGINS, aspNetUserLogin))
                .returning()
                .fetchOne()
                .into(AspNetUserLogin.class);
    }

    @Override
    public AspNetUserLogin update(AspNetUserLogin aspNetUserLogin) {
        return dsl.update(AspNetUserLogins.ASP_NET_USER_LOGINS)
                .set(dsl.newRecord(AspNetUserLogins.ASP_NET_USER_LOGINS, aspNetUserLogin))
                .where(AspNetUserLogins.ASP_NET_USER_LOGINS.USER_ID.eq(aspNetUserLogin.getUser_id()))
                .returning()
                .fetchOne()
                .into(AspNetUserLogin.class);
    }

    @Override
    public AspNetUserLogin find(String id) {
        return dsl.selectFrom(AspNetUserLogins.ASP_NET_USER_LOGINS)
                .where(AspNetUserLogins.ASP_NET_USER_LOGINS.USER_ID.eq(id))
                .fetchAny()
                .into(AspNetUserLogin.class);
    }

    @Override
    public List<AspNetUserLogin> findAll(Condition condition) {
        return dsl.selectFrom(AspNetUserLogins.ASP_NET_USER_LOGINS)
                .where(condition)
                .fetch()
                .into(AspNetUserLogin.class);
    }

    @Override
    public Boolean delete(String id) {
        return dsl.deleteFrom(AspNetUserLogins.ASP_NET_USER_LOGINS)
                .where(AspNetUserLogins.ASP_NET_USER_LOGINS.USER_ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
