package is.toxic.db.data.repository;

import is.toxic.db.data.dto.Disput;
import is.toxic.db.data.tables.Disputes;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DisputesRepository implements CrudRepository<Long, Disput> {

    private final DSLContext dsl;

    @Override
    public Disput insert(Disput disput) {
        return dsl.insertInto(Disputes.DISPUTES)
                .set(dsl.newRecord(Disputes.DISPUTES, disput))
                .returning()
                .fetchOne()
                .into(Disput.class);
    }

    @Override
    public Disput update(Disput disput) {
        return dsl.update(Disputes.DISPUTES)
                .set(dsl.newRecord(Disputes.DISPUTES, disput))
                .where(Disputes.DISPUTES.ID.eq(disput.getId()))
                .returning()
                .fetchOne()
                .into(Disput.class);
    }

    @Override
    public Disput find(Long id) {
        return dsl.selectFrom(Disputes.DISPUTES)
                .where(Disputes.DISPUTES.ID.eq(id))
                .fetchAny()
                .into(Disput.class);
    }

    @Override
    public List<Disput> findAll(Condition condition) {
        return dsl.selectFrom(Disputes.DISPUTES)
                .where(condition)
                .fetch()
                .into(Disput.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(Disputes.DISPUTES)
                .where(Disputes.DISPUTES.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
