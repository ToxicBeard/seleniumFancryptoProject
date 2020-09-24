package is.toxic.db.common.repository;

import is.toxic.db.common.dto.Balance;
import is.toxic.db.data.tables.Balances;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BalanceRepository implements CrudRepository<Long, Balance> {

    private final DSLContext dsl;

    @Autowired
    public BalanceRepository(@Qualifier("dataSourceData") DefaultDSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public Balance insert(Balance balance) {
        return dsl.insertInto(Balances.BALANCES)
                .set(dsl.newRecord(Balances.BALANCES, balance))
                .returning()
                .fetchOne()
                .into(Balance.class);
    }

    @Override
    public Balance update(Balance balance) {
        return dsl.update(Balances.BALANCES)
                .set(dsl.newRecord(Balances.BALANCES, balance))
                .where(Balances.BALANCES.ID.eq(balance.getId()))
                .returning()
                .fetchOne()
                .into(Balance.class);
    }

    @Override
    public Balance find(Long id) {
        return dsl.selectFrom(Balances.BALANCES)
                .where(Balances.BALANCES.ID.eq(id))
                .fetchAny()
                .into(Balance.class);
    }

    @Override
    public Balance find(Condition condition) {
        return dsl.selectFrom(Balances.BALANCES)
                .where(condition)
                .fetchAny()
                .into(Balance.class);
    }

    @Override
    public List<Balance> findAll(Condition condition) {
        return dsl.selectFrom(Balances.BALANCES)
                .where(condition)
                .fetch()
                .into(Balance.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(Balances.BALANCES)
                .where(Balances.BALANCES.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
