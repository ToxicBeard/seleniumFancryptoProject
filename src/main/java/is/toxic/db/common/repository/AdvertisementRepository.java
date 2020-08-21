package is.toxic.db.common.repository;

import is.toxic.db.common.dto.Advertisement;
import is.toxic.db.data.tables.Advertisements;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdvertisementRepository implements CrudRepository<Long, Advertisement> {

    private final DSLContext dsl;

    @Autowired
    public AdvertisementRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public Advertisement insert(Advertisement advertisement) {
        return dsl.insertInto(Advertisements.ADVERTISEMENTS)
                .set(dsl.newRecord(Advertisements.ADVERTISEMENTS, advertisement))
                .returning()
                .fetchOne()
                .into(Advertisement.class);
    }

    @Override
    public Advertisement update(Advertisement advertisement) {
        return dsl.update(Advertisements.ADVERTISEMENTS)
                .set(dsl.newRecord(Advertisements.ADVERTISEMENTS, advertisement))
                .where(Advertisements.ADVERTISEMENTS.ID.eq(advertisement.getId()))
                .returning()
                .fetchOne()
                .into(Advertisement.class);
    }

    @Override
    public Advertisement find(Long id) {
        return dsl.selectFrom(Advertisements.ADVERTISEMENTS)
                .where(Advertisements.ADVERTISEMENTS.ID.eq(id))
                .fetchAny()
                .into(Advertisement.class);
    }

    @Override
    public Advertisement find(Condition condition) {
        return dsl.selectFrom(Advertisements.ADVERTISEMENTS)
                .where(condition)
                .fetchAny()
                .into(Advertisement.class);
    }

    @Override
    public List<Advertisement> findAll(Condition condition) {
        return dsl.selectFrom(Advertisements.ADVERTISEMENTS)
                .where(condition)
                .fetch()
                .into(Advertisement.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(Advertisements.ADVERTISEMENTS)
                .where(Advertisements.ADVERTISEMENTS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
