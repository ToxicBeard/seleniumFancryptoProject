package is.toxic.db.data.repository;

import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import is.toxic.db.data.dto.AdvertisementSnapshot;
import is.toxic.repository.CrudRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdvertisementSnapshotRepository implements CrudRepository<Long, AdvertisementSnapshot> {

    private final org.jooq.DSLContext dsl;

    @Override
    public AdvertisementSnapshot insert(AdvertisementSnapshot advertisementSnapshot) {
        return dsl.insertInto(is.toxic.db.data.tables.AdvertisementSnapshot.ADVERTISEMENT_SNAPSHOT)
                .set(dsl.newRecord(is.toxic.db.data.tables.AdvertisementSnapshot.ADVERTISEMENT_SNAPSHOT, advertisementSnapshot))
                .returning()
                .fetchOne()
                .into(AdvertisementSnapshot.class);
    }

    @Override
    public AdvertisementSnapshot update(AdvertisementSnapshot advertisementSnapshot) {
        return dsl.update(is.toxic.db.data.tables.AdvertisementSnapshot.ADVERTISEMENT_SNAPSHOT)
                .set(dsl.newRecord(is.toxic.db.data.tables.AdvertisementSnapshot.ADVERTISEMENT_SNAPSHOT, advertisementSnapshot))
                .where(is.toxic.db.data.tables.AdvertisementSnapshot.ADVERTISEMENT_SNAPSHOT.ID.eq(advertisementSnapshot.getId()))
                .returning()
                .fetchOne()
                .into(AdvertisementSnapshot.class);
    }

    @Override
    public AdvertisementSnapshot find(Long id) {
        return dsl.selectFrom(is.toxic.db.data.tables.AdvertisementSnapshot.ADVERTISEMENT_SNAPSHOT)
                .where(is.toxic.db.data.tables.AdvertisementSnapshot.ADVERTISEMENT_SNAPSHOT.ID.eq(id))
                .fetchAny()
                .into(AdvertisementSnapshot.class);
    }

    @Override
    public List<AdvertisementSnapshot> findAll(Condition condition) {
        return dsl.selectFrom(is.toxic.db.data.tables.AdvertisementSnapshot.ADVERTISEMENT_SNAPSHOT)
                .where(condition)
                .fetch()
                .into(AdvertisementSnapshot.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(is.toxic.db.data.tables.AdvertisementSnapshot.ADVERTISEMENT_SNAPSHOT)
                .where(is.toxic.db.data.tables.AdvertisementSnapshot.ADVERTISEMENT_SNAPSHOT.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
