package is.toxic.db.common.repository;

import is.toxic.db.common.dto.OutTransactionRequest;
import is.toxic.db.data.tables.OutTransactionRequests;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OutTransactionRequestRepository implements CrudRepository<Long, OutTransactionRequest> {

    private final DSLContext dsl;

    @Autowired
    public OutTransactionRequestRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public OutTransactionRequest insert(OutTransactionRequest outTransactionRequest) {
        return dsl.insertInto(OutTransactionRequests.OUT_TRANSACTION_REQUESTS)
                .set(dsl.newRecord(OutTransactionRequests.OUT_TRANSACTION_REQUESTS, outTransactionRequest))
                .returning()
                .fetchOne()
                .into(OutTransactionRequest.class);
    }

    @Override
    public OutTransactionRequest update(OutTransactionRequest outTransactionRequest) {
        return dsl.update(OutTransactionRequests.OUT_TRANSACTION_REQUESTS)
                .set(dsl.newRecord(OutTransactionRequests.OUT_TRANSACTION_REQUESTS, outTransactionRequest))
                .where(OutTransactionRequests.OUT_TRANSACTION_REQUESTS.ID.eq(outTransactionRequest.getId()))
                .returning()
                .fetchOne()
                .into(OutTransactionRequest.class);
    }

    @Override
    public OutTransactionRequest find(Long id) {
        return dsl.selectFrom(OutTransactionRequests.OUT_TRANSACTION_REQUESTS)
                .where(OutTransactionRequests.OUT_TRANSACTION_REQUESTS.ID.eq(id))
                .fetchAny()
                .into(OutTransactionRequest.class);
    }

    @Override
    public OutTransactionRequest find(Condition condition) {
        return dsl.selectFrom(OutTransactionRequests.OUT_TRANSACTION_REQUESTS)
                .where(condition)
                .fetchAny()
                .into(OutTransactionRequest.class);
    }

    @Override
    public List<OutTransactionRequest> findAll(Condition condition) {
        return dsl.selectFrom(OutTransactionRequests.OUT_TRANSACTION_REQUESTS)
                .where(condition)
                .fetch()
                .into(OutTransactionRequest.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(OutTransactionRequests.OUT_TRANSACTION_REQUESTS)
                .where(OutTransactionRequests.OUT_TRANSACTION_REQUESTS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
