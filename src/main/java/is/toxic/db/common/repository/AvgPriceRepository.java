package is.toxic.db.common.repository;

import is.toxic.db.common.dto.AvgPrice;
import is.toxic.db.data.tables.AvgPrices;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvgPriceRepository implements CrudRepository<Integer, AvgPrice> {

    private final DSLContext dsl;

    @Autowired
    public AvgPriceRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public AvgPrice insert(AvgPrice avgPrice) {
        return dsl.insertInto(AvgPrices.AVG_PRICES)
                .set(dsl.newRecord(AvgPrices.AVG_PRICES, avgPrice))
                .returning()
                .fetchOne()
                .into(AvgPrice.class);
    }

    @Override
    public AvgPrice update(AvgPrice avgPrice) {
        return dsl.update(AvgPrices.AVG_PRICES)
                .set(dsl.newRecord(AvgPrices.AVG_PRICES, avgPrice))
                .where(AvgPrices.AVG_PRICES.ID.eq(avgPrice.getId()))
                .returning()
                .fetchOne()
                .into(AvgPrice.class);
    }

    @Override
    public AvgPrice find(Integer id) {
        return dsl.selectFrom(AvgPrices.AVG_PRICES)
                .where(AvgPrices.AVG_PRICES.ID.eq(id))
                .fetchAny()
                .into(AvgPrice.class);
    }

    @Override
    public AvgPrice find(Condition condition) {
        return dsl.selectFrom(AvgPrices.AVG_PRICES)
                .where(condition)
                .fetchAny()
                .into(AvgPrice.class);
    }

    @Override
    public List<AvgPrice> findAll(Condition condition) {
        return dsl.selectFrom(AvgPrices.AVG_PRICES)
                .where(condition)
                .fetch()
                .into(AvgPrice.class);
    }

    @Override
    public Boolean delete(Integer id) {
        return dsl.deleteFrom(AvgPrices.AVG_PRICES)
                .where(AvgPrices.AVG_PRICES.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
