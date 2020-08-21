package is.toxic.db.common.repository;

import is.toxic.db.common.dto.AspNetUserClaim;
import is.toxic.db.identity.tables.AspNetUserClaims;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AspNetUserClaimRepository implements CrudRepository<Integer, AspNetUserClaim> {

    private final DSLContext dsl;

    @Autowired
    public AspNetUserClaimRepository(@Qualifier("dslIdentity") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public AspNetUserClaim insert(AspNetUserClaim aspNetUserClaim) {
        return dsl.insertInto(AspNetUserClaims.ASP_NET_USER_CLAIMS)
                .set(dsl.newRecord(AspNetUserClaims.ASP_NET_USER_CLAIMS, aspNetUserClaim))
                .returning()
                .fetchOne()
                .into(AspNetUserClaim.class);
    }

    @Override
    public AspNetUserClaim update(AspNetUserClaim aspNetUserClaim) {
        return dsl.update(AspNetUserClaims.ASP_NET_USER_CLAIMS)
                .set(dsl.newRecord(AspNetUserClaims.ASP_NET_USER_CLAIMS, aspNetUserClaim))
                .where(AspNetUserClaims.ASP_NET_USER_CLAIMS.ID.eq(aspNetUserClaim.getId()))
                .returning()
                .fetchOne()
                .into(AspNetUserClaim.class);
    }

    @Override
    public AspNetUserClaim find(Integer id) {
        return dsl.selectFrom(AspNetUserClaims.ASP_NET_USER_CLAIMS)
                .where(AspNetUserClaims.ASP_NET_USER_CLAIMS.ID.eq(id))
                .fetchAny()
                .into(AspNetUserClaim.class);
    }

    @Override
    public AspNetUserClaim find(Condition condition) {
        return dsl.selectFrom(AspNetUserClaims.ASP_NET_USER_CLAIMS)
                .where(condition)
                .fetchAny()
                .into(AspNetUserClaim.class);
    }

    @Override
    public List<AspNetUserClaim> findAll(Condition condition) {
        return dsl.selectFrom(AspNetUserClaims.ASP_NET_USER_CLAIMS)
                .where(condition)
                .fetch()
                .into(AspNetUserClaim.class);
    }

    @Override
    public Boolean delete(Integer id) {
        return dsl.deleteFrom(AspNetUserClaims.ASP_NET_USER_CLAIMS)
                .where(AspNetUserClaims.ASP_NET_USER_CLAIMS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
