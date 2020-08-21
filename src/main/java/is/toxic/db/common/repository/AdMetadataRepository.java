package is.toxic.db.common.repository;

import is.toxic.db.common.dto.AdMetadata;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdMetadataRepository implements CrudRepository<Long, AdMetadata> {

    private final DSLContext dsl;

    @Autowired
    public AdMetadataRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

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
    public AdMetadata find(Condition condition) {
        return dsl.selectFrom(is.toxic.db.data.tables.AdMetadata.AD_METADATA)
                .where(condition)
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
