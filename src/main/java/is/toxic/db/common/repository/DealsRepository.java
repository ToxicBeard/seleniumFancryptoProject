package is.toxic.db.common.repository;

import is.toxic.db.common.dto.Deal;
import is.toxic.db.data.tables.Deals;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DealsRepository implements CrudRepository<Long, Deal> {

    private final DSLContext dsl;

    @Autowired
    public DealsRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public Deal insert(Deal deal) {
        return dsl.insertInto(Deals.DEALS)
                .set(dsl.newRecord(Deals.DEALS, deal))
                .returning()
                .fetchOne()
                .into(Deal.class);
    }

    @Override
    public Deal update(Deal deal) {
        return dsl.update(Deals.DEALS)
                .set(dsl.newRecord(Deals.DEALS, deal))
                .where(Deals.DEALS.ID.eq(deal.getId()))
                .returning()
                .fetchOne()
                .into(Deal.class);
    }

    @Override
    public Deal find(Long id) {
        return dsl.selectFrom(Deals.DEALS)
                .where(Deals.DEALS.ID.eq(id))
                .fetchAny()
                .into(Deal.class);
    }

    @Override
    public Deal find(Condition condition) {
        return dsl.selectFrom(Deals.DEALS)
                .where(condition)
                .fetchAny()
                .into(Deal.class);
    }

    @Override
    public List<Deal> findAll(Condition condition) {
        return dsl.selectFrom(Deals.DEALS)
                .where(condition)
                .fetch()
                .into(Deal.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(Deals.DEALS)
                .where(Deals.DEALS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
