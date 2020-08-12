package is.toxic.db.data.repository;

import is.toxic.db.data.dto.InTransaction;
import is.toxic.db.data.tables.InTransactions;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class InTransactionRepository implements CrudRepository<Long, InTransaction> {

    private final DSLContext dsl;

    @Override
    public InTransaction insert(InTransaction inTransaction) {
        return dsl.insertInto(InTransactions.IN_TRANSACTIONS)
                .set(dsl.newRecord(InTransactions.IN_TRANSACTIONS, inTransaction))
                .returning()
                .fetchOne()
                .into(InTransaction.class);
    }

    @Override
    public InTransaction update(InTransaction inTransaction) {
        return dsl.update(InTransactions.IN_TRANSACTIONS)
                .set(dsl.newRecord(InTransactions.IN_TRANSACTIONS, inTransaction))
                .where(InTransactions.IN_TRANSACTIONS.ID.eq(inTransaction.getId()))
                .returning()
                .fetchOne()
                .into(InTransaction.class);
    }

    @Override
    public InTransaction find(Long id) {
        return dsl.selectFrom(InTransactions.IN_TRANSACTIONS)
                .where(InTransactions.IN_TRANSACTIONS.ID.eq(id))
                .fetchAny()
                .into(InTransaction.class);
    }

    @Override
    public List<InTransaction> findAll(Condition condition) {
        return dsl.selectFrom(InTransactions.IN_TRANSACTIONS)
                .where(condition)
                .fetch()
                .into(InTransaction.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(InTransactions.IN_TRANSACTIONS)
                .where(InTransactions.IN_TRANSACTIONS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
