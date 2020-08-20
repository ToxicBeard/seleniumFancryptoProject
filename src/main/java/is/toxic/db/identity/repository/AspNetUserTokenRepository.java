package is.toxic.db.identity.repository;

import is.toxic.db.identity.dto.AspNetUserToken;
import is.toxic.db.identity.tables.AspNetUserTokens;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AspNetUserTokenRepository implements CrudRepository<String, AspNetUserToken> {

    private final DSLContext dsl;

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
