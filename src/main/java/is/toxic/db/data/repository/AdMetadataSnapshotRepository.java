package is.toxic.db.data.repository;

import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import is.toxic.db.data.dto.AdMetadataSnapshot;
import is.toxic.repository.CrudRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdMetadataSnapshotRepository implements CrudRepository<Long, AdMetadataSnapshot> {

    private final org.jooq.DSLContext dsl;

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
