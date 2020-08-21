package is.toxic.db.common.repository;

import is.toxic.db.common.dto.VariableMetadata;
import is.toxic.db.data.tables.VariablesMetadata;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VariableMetadataRepository implements CrudRepository<Integer, VariableMetadata> {

    private final DSLContext dsl;

    @Autowired
    public VariableMetadataRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public VariableMetadata insert(VariableMetadata variableMetadata) {
        return dsl.insertInto(VariablesMetadata.VARIABLES_METADATA)
                .set(dsl.newRecord(VariablesMetadata.VARIABLES_METADATA, variableMetadata))
                .returning()
                .fetchOne()
                .into(VariableMetadata.class);
    }

    @Override
    public VariableMetadata update(VariableMetadata variableMetadata) {
        return dsl.update(VariablesMetadata.VARIABLES_METADATA)
                .set(dsl.newRecord(VariablesMetadata.VARIABLES_METADATA, variableMetadata))
                .where(VariablesMetadata.VARIABLES_METADATA.ID.eq(variableMetadata.getId()))
                .returning()
                .fetchOne()
                .into(VariableMetadata.class);
    }

    @Override
    public VariableMetadata find(Integer id) {
        return dsl.selectFrom(VariablesMetadata.VARIABLES_METADATA)
                .where(VariablesMetadata.VARIABLES_METADATA.ID.eq(id))
                .fetchAny()
                .into(VariableMetadata.class);
    }

    @Override
    public VariableMetadata find(Condition condition) {
        return dsl.selectFrom(VariablesMetadata.VARIABLES_METADATA)
                .where(condition)
                .fetchAny()
                .into(VariableMetadata.class);
    }

    @Override
    public List<VariableMetadata> findAll(Condition condition) {
        return dsl.selectFrom(VariablesMetadata.VARIABLES_METADATA)
                .where(condition)
                .fetch()
                .into(VariableMetadata.class);
    }

    @Override
    public Boolean delete(Integer id) {
        return dsl.deleteFrom(VariablesMetadata.VARIABLES_METADATA)
                .where(VariablesMetadata.VARIABLES_METADATA.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
