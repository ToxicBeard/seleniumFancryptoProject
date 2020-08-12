package is.toxic.db.data.repository;

import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import is.toxic.db.data.dto.AdMetadata;
import is.toxic.repository.CrudRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdMetadataRepository implements CrudRepository<Long, AdMetadata> {

    private final org.jooq.DSLContext dsl;

    @Override
    public AdMetadata insert(AdMetadata adMetadata) {
        return dsl.insertInto(is.toxic.db.data.tables.AdMetadata.AD_METADATA)
                .set(dsl.newRecord(is.toxic.db.data.tables.AdMetadata.AD_METADATA, adMetadata))
                .returning()
                .fetchOne()
                .into(AdMetadata.class);
    }

    @Override
    public AdMetadata update(AdMetadata adMetadata) {
        return dsl.update(is.toxic.db.data.tables.AdMetadata.AD_METADATA)
                .set(dsl.newRecord(is.toxic.db.data.tables.AdMetadata.AD_METADATA, adMetadata))
                .where(is.toxic.db.data.tables.AdMetadata.AD_METADATA.ID.eq(adMetadata.getId()))
                .returning()
                .fetchOne()
                .into(AdMetadata.class);
    }

    @Override
    public AdMetadata find(Long id) {
        return dsl.selectFrom(is.toxic.db.data.tables.AdMetadata.AD_METADATA)
                .where(is.toxic.db.data.tables.AdMetadata.AD_METADATA.ID.eq(id))
                .fetchAny()
                .into(AdMetadata.class);
    }

    @Override
    public List<AdMetadata> findAll(Condition condition) {
        return dsl.selectFrom(is.toxic.db.data.tables.AdMetadata.AD_METADATA)
                .where(condition)
                .fetch()
                .into(AdMetadata.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(is.toxic.db.data.tables.AdMetadata.AD_METADATA)
                .where(is.toxic.db.data.tables.AdMetadata.AD_METADATA.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
