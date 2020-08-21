package is.toxic.db.common.repository;

import is.toxic.db.common.dto.AspNetUserToken;
import is.toxic.db.identity.tables.AspNetUserTokens;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AspNetUserTokenRepository implements CrudRepository<String, AspNetUserToken> {

    private final DSLContext dsl;

    @Autowired
    public AspNetUserTokenRepository(@Qualifier("dslIdentity") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public AspNetUserToken insert(AspNetUserToken aspNetUserToken) {
        return dsl.insertInto(AspNetUserTokens.ASP_NET_USER_TOKENS)
                .set(dsl.newRecord(AspNetUserTokens.ASP_NET_USER_TOKENS, aspNetUserToken))
                .returning()
                .fetchOne()
                .into(AspNetUserToken.class);
    }

    @Override
    public AspNetUserToken update(AspNetUserToken aspNetUserToken) {
        return dsl.update(AspNetUserTokens.ASP_NET_USER_TOKENS)
                .set(dsl.newRecord(AspNetUserTokens.ASP_NET_USER_TOKENS, aspNetUserToken))
                .where(AspNetUserTokens.ASP_NET_USER_TOKENS.USER_ID.eq(aspNetUserToken.getUser_id()))
                .returning()
                .fetchOne()
                .into(AspNetUserToken.class);
    }

    @Override
    public AspNetUserToken find(String id) {
        return dsl.selectFrom(AspNetUserTokens.ASP_NET_USER_TOKENS)
                .where(AspNetUserTokens.ASP_NET_USER_TOKENS.USER_ID.eq(id))
                .fetchAny()
                .into(AspNetUserToken.class);
    }

    @Override
    public AspNetUserToken find(Condition condition) {
        return dsl.selectFrom(AspNetUserTokens.ASP_NET_USER_TOKENS)
                .where(condition)
                .fetchAny()
                .into(AspNetUserToken.class);
    }

    @Override
    public List<AspNetUserToken> findAll(Condition condition) {
        return dsl.selectFrom(AspNetUserTokens.ASP_NET_USER_TOKENS)
                .where(condition)
                .fetch()
                .into(AspNetUserToken.class);
    }

    @Override
    public Boolean delete(String id) {
        return dsl.deleteFrom(AspNetUserTokens.ASP_NET_USER_TOKENS)
                .where(AspNetUserTokens.ASP_NET_USER_TOKENS.USER_ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
