package is.toxic.db.common.repository;

import is.toxic.db.common.dto.AdMetadataSnapshot;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdMetadataSnapshotRepository implements CrudRepository<Long, AdMetadataSnapshot> {

    private final DSLContext dsl;

    @Autowired
    public AdMetadataSnapshotRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public AdMetadataSnapshot insert(AdMetadataSnapshot adMetadataSnapshot) {
        return dsl.insertInto(is.toxic.db.data.tables.AdMetadataSnapshot.AD_METADATA_SNAPSHOT)
                .set(dsl.newRecord(is.toxic.db.data.tables.AdMetadataSnapshot.AD_METADATA_SNAPSHOT, adMetadataSnapshot))
                .returning()
                .fetchOne()
                .into(AdMetadataSnapshot.class);
    }

    @Override
    public AdMetadataSnapshot update(AdMetadataSnapshot adMetadataSnapshot) {
        return dsl.update(is.toxic.db.data.tables.AdMetadataSnapshot.AD_METADATA_SNAPSHOT)
                .set(dsl.newRecord(is.toxic.db.data.tables.AdMetadataSnapshot.AD_METADATA_SNAPSHOT, adMetadataSnapshot))
                .where(is.toxic.db.data.tables.AdMetadataSnapshot.AD_METADATA_SNAPSHOT.KEY.eq(adMetadataSnapshot.getKey()))
                .returning()
                .fetchOne()
                .into(AdMetadataSnapshot.class);
    }

    @Override
    public AdMetadataSnapshot find(Long id) {
        return dsl.selectFrom(is.toxic.db.data.tables.AdMetadataSnapshot.AD_METADATA_SNAPSHOT)
                .where(is.toxic.db.data.tables.AdMetadataSnapshot.AD_METADATA_SNAPSHOT.KEY.eq(id))
                .fetchAny()
                .into(AdMetadataSnapshot.class);
    }

    @Override
    public AdMetadataSnapshot find(Condition condition) {
        return dsl.selectFrom(is.toxic.db.data.tables.AdMetadataSnapshot.AD_METADATA_SNAPSHOT)
                .where(condition)
                .fetchAny()
                .into(AdMetadataSnapshot.class);
    }

    @Override
    public List<AdMetadataSnapshot> findAll(Condition condition) {
        return dsl.selectFrom(is.toxic.db.data.tables.AdMetadataSnapshot.AD_METADATA_SNAPSHOT)
                .where(condition)
                .fetch()
                .into(AdMetadataSnapshot.class);
    }

    @Override
    public Boolean delete(Long key) {
        return dsl.deleteFrom(is.toxic.db.data.tables.AdMetadataSnapshot.AD_METADATA_SNAPSHOT)
                .where(is.toxic.db.data.tables.AdMetadataSnapshot.AD_METADATA_SNAPSHOT.KEY.eq(key))
                .execute() == SUCCESS_CODE;
    }
}
