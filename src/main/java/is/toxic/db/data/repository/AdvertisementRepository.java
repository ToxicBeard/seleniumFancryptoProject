package is.toxic.db.data.repository;

import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import is.toxic.db.data.tables.Advertisements;
import is.toxic.db.data.dto.Advertisement;
import is.toxic.repository.CrudRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdvertisementRepository implements CrudRepository<Long, Advertisement> {

    private final org.jooq.DSLContext dsl;

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
