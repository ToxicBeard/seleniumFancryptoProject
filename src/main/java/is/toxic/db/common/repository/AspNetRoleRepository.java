package is.toxic.db.common.repository;

import is.toxic.db.common.dto.AspNetRole;
import is.toxic.db.identity.tables.AspNetRoles;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AspNetRoleRepository implements CrudRepository<String, AspNetRole> {

    private final DSLContext dsl;

    @Autowired
    public AspNetRoleRepository(@Qualifier("dslIdentity") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public AspNetRole insert(AspNetRole aspNetRole) {
        return dsl.insertInto(AspNetRoles.ASP_NET_ROLES)
                .set(dsl.newRecord(AspNetRoles.ASP_NET_ROLES, aspNetRole))
                .returning()
                .fetchOne()
                .into(AspNetRole.class);
    }

    @Override
    public AspNetRole update(AspNetRole aspNetRole) {
        return dsl.update(AspNetRoles.ASP_NET_ROLES)
                .set(dsl.newRecord(AspNetRoles.ASP_NET_ROLES, aspNetRole))
                .where(AspNetRoles.ASP_NET_ROLES.ID.eq(aspNetRole.getId()))
                .returning()
                .fetchOne()
                .into(AspNetRole.class);
    }

    @Override
    public AspNetRole find(String id) {
        return dsl.selectFrom(AspNetRoles.ASP_NET_ROLES)
                .where(AspNetRoles.ASP_NET_ROLES.ID.eq(id))
                .fetchAny()
                .into(AspNetRole.class);
    }

    @Override
    public AspNetRole find(Condition condition) {
        return dsl.selectFrom(AspNetRoles.ASP_NET_ROLES)
                .where(condition)
                .fetchAny()
                .into(AspNetRole.class);
    }

    @Override
    public List<AspNetRole> findAll(Condition condition) {
        return dsl.selectFrom(AspNetRoles.ASP_NET_ROLES)
                .where(condition)
                .fetch()
                .into(AspNetRole.class);
    }

    @Override
    public Boolean delete(String id) {
        return dsl.deleteFrom(AspNetRoles.ASP_NET_ROLES)
                .where(AspNetRoles.ASP_NET_ROLES.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
