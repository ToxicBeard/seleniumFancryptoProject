package is.toxic.db.common.repository;

import is.toxic.db.common.dto.AdvertisementSnapshot;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdvertisementSnapshotRepository implements CrudRepository<Long, AdvertisementSnapshot> {

    private final org.jooq.DSLContext dsl;

    @Autowired
    public AdvertisementSnapshotRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

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
    public AdvertisementSnapshot find(Condition condition) {
        return dsl.selectFrom(is.toxic.db.data.tables.AdvertisementSnapshot.ADVERTISEMENT_SNAPSHOT)
                .where(condition)
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
