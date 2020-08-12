package is.toxic.db.data.repository;

import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import is.toxic.db.data.tables.Balances;
import is.toxic.db.data.dto.Balance;
import is.toxic.repository.CrudRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BalanceRepository implements CrudRepository<Long, Balance> {

    private final DSLContext dsl;
    
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
