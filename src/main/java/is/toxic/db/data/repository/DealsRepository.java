package is.toxic.db.data.repository;

import is.toxic.db.data.dto.Deal;
import is.toxic.db.data.tables.Deals;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)

public class DealsRepository implements CrudRepository<Long, Deal> {

    private final DSLContext dsl;

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
