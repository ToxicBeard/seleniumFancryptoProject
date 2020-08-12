package is.toxic.db.data.repository;

import is.toxic.db.data.dto.OutTransaction;
import is.toxic.db.data.tables.OutTransactions;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OutTransactionRepository implements CrudRepository<Long, OutTransaction> {

    private final DSLContext dsl;

    @Override
    public OutTransaction insert(OutTransaction outTransaction) {
        return dsl.insertInto(OutTransactions.OUT_TRANSACTIONS)
                .set(dsl.newRecord(OutTransactions.OUT_TRANSACTIONS, outTransaction))
                .returning()
                .fetchOne()
                .into(OutTransaction.class);
    }

    @Override
    public OutTransaction update(OutTransaction outTransaction) {
        return dsl.update(OutTransactions.OUT_TRANSACTIONS)
                .set(dsl.newRecord(OutTransactions.OUT_TRANSACTIONS, outTransaction))
                .where(OutTransactions.OUT_TRANSACTIONS.ID.eq(outTransaction.getId()))
                .returning()
                .fetchOne()
                .into(OutTransaction.class);
    }

    @Override
    public OutTransaction find(Long id) {
        return dsl.selectFrom(OutTransactions.OUT_TRANSACTIONS)
                .where(OutTransactions.OUT_TRANSACTIONS.ID.eq(id))
                .fetchAny()
                .into(OutTransaction.class);
    }

    @Override
    public List<OutTransaction> findAll(Condition condition) {
        return dsl.selectFrom(OutTransactions.OUT_TRANSACTIONS)
                .where(condition)
                .fetch()
                .into(OutTransaction.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(OutTransactions.OUT_TRANSACTIONS)
                .where(OutTransactions.OUT_TRANSACTIONS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
