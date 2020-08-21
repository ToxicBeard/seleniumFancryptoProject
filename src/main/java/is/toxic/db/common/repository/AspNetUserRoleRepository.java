package is.toxic.db.common.repository;

import is.toxic.db.common.dto.AspNetUserRole;
import is.toxic.db.identity.tables.AspNetUserRoles;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AspNetUserRoleRepository implements CrudRepository<String, AspNetUserRole> {

    private final DSLContext dsl;

    @Autowired
    public AspNetUserRoleRepository(@Qualifier("dslIdentity") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public AspNetUserRole insert(AspNetUserRole aspNetUserRole) {
        return dsl.insertInto(AspNetUserRoles.ASP_NET_USER_ROLES)
                .set(dsl.newRecord(AspNetUserRoles.ASP_NET_USER_ROLES, aspNetUserRole))
                .returning()
                .fetchOne()
                .into(AspNetUserRole.class);
    }

    @Override
    public AspNetUserRole update(AspNetUserRole aspNetUserRole) {
        return dsl.update(AspNetUserRoles.ASP_NET_USER_ROLES)
                .set(dsl.newRecord(AspNetUserRoles.ASP_NET_USER_ROLES, aspNetUserRole))
                .where(AspNetUserRoles.ASP_NET_USER_ROLES.USER_ID.eq(aspNetUserRole.getUser_id()))
                .returning()
                .fetchOne()
                .into(AspNetUserRole.class);
    }

    @Override
    public AspNetUserRole find(String id) {
        return dsl.selectFrom(AspNetUserRoles.ASP_NET_USER_ROLES)
                .where(AspNetUserRoles.ASP_NET_USER_ROLES.USER_ID.eq(id))
                .fetchAny()
                .into(AspNetUserRole.class);
    }

    @Override
    public AspNetUserRole find(Condition condition) {
        return dsl.selectFrom(AspNetUserRoles.ASP_NET_USER_ROLES)
                .where(condition)
                .fetchAny()
                .into(AspNetUserRole.class);
    }

    @Override
    public List<AspNetUserRole> findAll(Condition condition) {
        return dsl.selectFrom(AspNetUserRoles.ASP_NET_USER_ROLES)
                .where(condition)
                .fetch()
                .into(AspNetUserRole.class);
    }

    @Override
    public Boolean delete(String id) {
        return dsl.deleteFrom(AspNetUserRoles.ASP_NET_USER_ROLES)
                .where(AspNetUserRoles.ASP_NET_USER_ROLES.USER_ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
