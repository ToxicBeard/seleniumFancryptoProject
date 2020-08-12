package is.toxic.db.data.repository;

import is.toxic.db.data.dto.FiatExchangeVariable;
import is.toxic.db.data.tables.FiatExchangeVariables;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FiatExchangeVariableRepository implements CrudRepository<Integer, FiatExchangeVariable> {

    private final DSLContext dsl;

    @Override
    public FiatExchangeVariable insert(FiatExchangeVariable fiatExchangeVariable) {
        return dsl.insertInto(FiatExchangeVariables.FIAT_EXCHANGE_VARIABLES)
                .set(dsl.newRecord(FiatExchangeVariables.FIAT_EXCHANGE_VARIABLES, fiatExchangeVariable))
                .returning()
                .fetchOne()
                .into(FiatExchangeVariable.class);
    }

    @Override
    public FiatExchangeVariable update(FiatExchangeVariable fiatExchangeVariable) {
        return dsl.update(FiatExchangeVariables.FIAT_EXCHANGE_VARIABLES)
                .set(dsl.newRecord(FiatExchangeVariables.FIAT_EXCHANGE_VARIABLES, fiatExchangeVariable))
                .where(FiatExchangeVariables.FIAT_EXCHANGE_VARIABLES.KEY.eq(fiatExchangeVariable.getKey()))
                .returning()
                .fetchOne()
                .into(FiatExchangeVariable.class);
    }

    @Override
    public FiatExchangeVariable find(Integer id) {
        return dsl.selectFrom(FiatExchangeVariables.FIAT_EXCHANGE_VARIABLES)
                .where(FiatExchangeVariables.FIAT_EXCHANGE_VARIABLES.KEY.eq(id))
                .fetchAny()
                .into(FiatExchangeVariable.class);
    }

    @Override
    public List<FiatExchangeVariable> findAll(Condition condition) {
        return dsl.selectFrom(FiatExchangeVariables.FIAT_EXCHANGE_VARIABLES)
                .where(condition)
                .fetch()
                .into(FiatExchangeVariable.class);
    }

    @Override
    public Boolean delete(Integer id) {
        return dsl.deleteFrom(FiatExchangeVariables.FIAT_EXCHANGE_VARIABLES)
                .where(FiatExchangeVariables.FIAT_EXCHANGE_VARIABLES.KEY.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
