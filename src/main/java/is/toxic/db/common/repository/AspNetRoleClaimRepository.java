package is.toxic.db.common.repository;

import is.toxic.db.common.dto.AspNetRoleClaim;
import is.toxic.db.identity.tables.AspNetRoleClaims;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AspNetRoleClaimRepository implements CrudRepository<Integer, AspNetRoleClaim> {

    private final DSLContext dsl;

    @Autowired
    public AspNetRoleClaimRepository(@Qualifier("dslIdentity") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public AspNetRoleClaim insert(AspNetRoleClaim aspNetRoleClaim) {
        return dsl.insertInto(AspNetRoleClaims.ASP_NET_ROLE_CLAIMS)
                .set(dsl.newRecord(AspNetRoleClaims.ASP_NET_ROLE_CLAIMS, aspNetRoleClaim))
                .returning()
                .fetchOne()
                .into(AspNetRoleClaim.class);
    }

    @Override
    public AspNetRoleClaim update(AspNetRoleClaim aspNetRoleClaim) {
        return dsl.update(AspNetRoleClaims.ASP_NET_ROLE_CLAIMS)
                .set(dsl.newRecord(AspNetRoleClaims.ASP_NET_ROLE_CLAIMS, aspNetRoleClaim))
                .where(AspNetRoleClaims.ASP_NET_ROLE_CLAIMS.ID.eq(aspNetRoleClaim.getId()))
                .returning()
                .fetchOne()
                .into(AspNetRoleClaim.class);
    }

    @Override
    public AspNetRoleClaim find(Integer id) {
        return dsl.selectFrom(AspNetRoleClaims.ASP_NET_ROLE_CLAIMS)
                .where(AspNetRoleClaims.ASP_NET_ROLE_CLAIMS.ID.eq(id))
                .fetchAny()
                .into(AspNetRoleClaim.class);
    }

    @Override
    public AspNetRoleClaim find(Condition condition) {
        return dsl.selectFrom(AspNetRoleClaims.ASP_NET_ROLE_CLAIMS)
                .where(condition)
                .fetchAny()
                .into(AspNetRoleClaim.class);
    }

    @Override
    public List<AspNetRoleClaim> findAll(Condition condition) {
        return dsl.selectFrom(AspNetRoleClaims.ASP_NET_ROLE_CLAIMS)
                .where(condition)
                .fetch()
                .into(AspNetRoleClaim.class);
    }

    @Override
    public Boolean delete(Integer id) {
        return dsl.deleteFrom(AspNetRoleClaims.ASP_NET_ROLE_CLAIMS)
                .where(AspNetRoleClaims.ASP_NET_ROLE_CLAIMS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
