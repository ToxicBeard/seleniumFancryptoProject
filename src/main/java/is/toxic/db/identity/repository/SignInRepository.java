package is.toxic.db.identity.repository;

import is.toxic.db.identity.dto.SignIn;
import is.toxic.db.identity.tables.SignIns;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SignInRepository implements CrudRepository<Long, SignIn> {

    private final DSLContext dsl;

    @Override
    public SignIn insert(SignIn signIn) {
        return dsl.insertInto(SignIns.SIGN_INS)
                .set(dsl.newRecord(SignIns.SIGN_INS, signIn))
                .returning()
                .fetchOne()
                .into(SignIn.class);
    }

    @Override
    public SignIn update(SignIn signIn) {
        return dsl.update(SignIns.SIGN_INS)
                .set(dsl.newRecord(SignIns.SIGN_INS, signIn))
                .where(SignIns.SIGN_INS.ID.eq(signIn.getId()))
                .returning()
                .fetchOne()
                .into(SignIn.class);
    }

    @Override
    public SignIn find(Long id) {
        return dsl.selectFrom(SignIns.SIGN_INS)
                .where(SignIns.SIGN_INS.ID.eq(id))
                .fetchAny()
                .into(SignIn.class);
    }

    @Override
    public List<SignIn> findAll(Condition condition) {
        return dsl.selectFrom(SignIns.SIGN_INS)
                .where(condition)
                .fetch()
                .into(SignIn.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(SignIns.SIGN_INS)
                .where(SignIns.SIGN_INS.ID.eq(id))
                .execute() == SUCCESS_CODE;    }
}
