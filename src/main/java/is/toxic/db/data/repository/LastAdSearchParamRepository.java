package is.toxic.db.data.repository;

import is.toxic.db.data.dto.LastAdSearchParam;
import is.toxic.db.data.tables.LastAdSearchParams;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LastAdSearchParamRepository implements CrudRepository<Long, LastAdSearchParam> {

    private final DSLContext dsl;

    @Override
    public LastAdSearchParam insert(LastAdSearchParam lastAdSearchParam) {
        return dsl.insertInto(LastAdSearchParams.LAST_AD_SEARCH_PARAMS)
                .set(dsl.newRecord(LastAdSearchParams.LAST_AD_SEARCH_PARAMS, lastAdSearchParam))
                .returning()
                .fetchOne()
                .into(LastAdSearchParam.class);
    }

    @Override
    public LastAdSearchParam update(LastAdSearchParam lastAdSearchParam) {
        return dsl.update(LastAdSearchParams.LAST_AD_SEARCH_PARAMS)
                .set(dsl.newRecord(LastAdSearchParams.LAST_AD_SEARCH_PARAMS, lastAdSearchParam))
                .where(LastAdSearchParams.LAST_AD_SEARCH_PARAMS.ID.eq(lastAdSearchParam.getId()))
                .returning()
                .fetchOne()
                .into(LastAdSearchParam.class);
    }

    @Override
    public LastAdSearchParam find(Long id) {
        return dsl.selectFrom(LastAdSearchParams.LAST_AD_SEARCH_PARAMS)
                .where(LastAdSearchParams.LAST_AD_SEARCH_PARAMS.ID.eq(id))
                .fetchAny()
                .into(LastAdSearchParam.class);
    }

    @Override
    public List<LastAdSearchParam> findAll(Condition condition) {
        return dsl.selectFrom(LastAdSearchParams.LAST_AD_SEARCH_PARAMS)
                .where(condition)
                .fetch()
                .into(LastAdSearchParam.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(LastAdSearchParams.LAST_AD_SEARCH_PARAMS)
                .where(LastAdSearchParams.LAST_AD_SEARCH_PARAMS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
