package is.toxic.db.common.repository;

import is.toxic.db.common.dto.CryptoExchangeVariable;
import is.toxic.db.data.tables.CryptoExchangeVariables;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CryptoExchangeVariableRepository implements CrudRepository<Integer, CryptoExchangeVariable> {

    private final DSLContext dsl;

    @Autowired
    public CryptoExchangeVariableRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public CryptoExchangeVariable insert(CryptoExchangeVariable cryptoExchangeVariable) {
        return dsl.insertInto(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES)
                .set(dsl.newRecord(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES, cryptoExchangeVariable))
                .returning()
                .fetchOne()
                .into(CryptoExchangeVariable.class);
    }

    @Override
    public CryptoExchangeVariable update(CryptoExchangeVariable cryptoExchangeVariable) {
        return dsl.update(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES)
                .set(dsl.newRecord(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES, cryptoExchangeVariable))
                .where(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES.KEY.eq(cryptoExchangeVariable.getKey()))
                .returning()
                .fetchOne()
                .into(CryptoExchangeVariable.class);
    }

    @Override
    public CryptoExchangeVariable find(Integer key) {
        return dsl.selectFrom(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES)
                .where(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES.KEY.eq(key))
                .fetchAny()
                .into(CryptoExchangeVariable.class);
    }

    @Override
    public CryptoExchangeVariable find(Condition condition) {
        return dsl.selectFrom(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES)
                .where(condition)
                .fetchAny()
                .into(CryptoExchangeVariable.class);
    }

    @Override
    public List<CryptoExchangeVariable> findAll(Condition condition) {
        return dsl.selectFrom(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES)
                .where(condition)
                .fetch()
                .into(CryptoExchangeVariable.class);
    }

    @Override
    public Boolean delete(Integer id) {
        return dsl.deleteFrom(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES)
                .where(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES.KEY.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
