package is.toxic.db.common.repository;

import is.toxic.db.common.dto.DealMessage;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DealMessageRepository implements CrudRepository<Long, DealMessage> {

    private final DSLContext dsl;

    @Autowired
    public DealMessageRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public DealMessage insert(DealMessage dealMessage) {
        return dsl.insertInto(is.toxic.db.data.tables.DealMessage.DEAL_MESSAGE)
                .set(dsl.newRecord(is.toxic.db.data.tables.DealMessage.DEAL_MESSAGE, dealMessage))
                .returning()
                .fetchOne()
                .into(DealMessage.class);
    }

    @Override
    public DealMessage update(DealMessage dealMessage) {
        return dsl.update(is.toxic.db.data.tables.DealMessage.DEAL_MESSAGE)
                .set(dsl.newRecord(is.toxic.db.data.tables.DealMessage.DEAL_MESSAGE, dealMessage))
                .where(is.toxic.db.data.tables.DealMessage.DEAL_MESSAGE.ID.eq(dealMessage.getId()))
                .returning()
                .fetchOne()
                .into(DealMessage.class);
    }

    @Override
    public DealMessage find(Long id) {
        return dsl.selectFrom(is.toxic.db.data.tables.DealMessage.DEAL_MESSAGE)
                .where(is.toxic.db.data.tables.DealMessage.DEAL_MESSAGE.ID.eq(id))
                .fetchAny()
                .into(DealMessage.class);
    }

    @Override
    public DealMessage find(Condition condition) {
        return dsl.selectFrom(is.toxic.db.data.tables.DealMessage.DEAL_MESSAGE)
                .where(condition)
                .fetchAny()
                .into(DealMessage.class);
    }

    @Override
    public List<DealMessage> findAll(Condition condition) {
        return dsl.selectFrom(is.toxic.db.data.tables.DealMessage.DEAL_MESSAGE)
                .where(condition)
                .fetch()
                .into(DealMessage.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(is.toxic.db.data.tables.DealMessage.DEAL_MESSAGE)
                .where(is.toxic.db.data.tables.DealMessage.DEAL_MESSAGE.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
