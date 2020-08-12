package is.toxic.db.data.repository;

import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import is.toxic.db.data.tables.AvgPrices;
import is.toxic.db.data.dto.AvgPrice;
import is.toxic.repository.CrudRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AvgPriceRepository implements CrudRepository<Integer, AvgPrice> {

    private final DSLContext dsl;


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
