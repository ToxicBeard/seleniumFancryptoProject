package is.toxic.db.identity.repository;

import is.toxic.db.identity.dto.AspNetUser;
import is.toxic.db.identity.tables.AspNetUsers;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AspNetUserRepository implements CrudRepository<String, AspNetUser> {

    private final DSLContext dsl;

    @Override
    public AspNetUser insert(AspNetUser aspNetUser) {
        return dsl.insertInto(AspNetUsers.ASP_NET_USERS)
                .set(dsl.newRecord(AspNetUsers.ASP_NET_USERS, aspNetUser))
                .returning()
                .fetchOne()
                .into(AspNetUser.class);
    }

    @Override
    public AspNetUser update(AspNetUser aspNetUser) {
        return dsl.update(AspNetUsers.ASP_NET_USERS)
                .set(dsl.newRecord(AspNetUsers.ASP_NET_USERS, aspNetUser))
                .where(AspNetUsers.ASP_NET_USERS.ID.eq(aspNetUser.getId()))
                .returning()
                .fetchOne()
                .into(AspNetUser.class);
    }

    @Override
    public AspNetUser find(String id) {
        return dsl.selectFrom(AspNetUsers.ASP_NET_USERS)
                .where(AspNetUsers.ASP_NET_USERS.ID.eq(id))
                .fetchAny()
                .into(AspNetUser.class);
    }

    @Override
    public List<AspNetUser> findAll(Condition condition) {
        return dsl.selectFrom(AspNetUsers.ASP_NET_USERS)
                .where(condition)
                .fetch()
                .into(AspNetUser.class);
    }

    @Override
    public Boolean delete(String id) {
        return dsl.deleteFrom(AspNetUsers.ASP_NET_USERS)
                .where(AspNetUsers.ASP_NET_USERS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
