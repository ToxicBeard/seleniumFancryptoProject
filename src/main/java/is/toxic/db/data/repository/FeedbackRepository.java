package is.toxic.db.data.repository;

import is.toxic.db.data.dto.Feedback;
import is.toxic.db.data.tables.Feedbacks;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FeedbackRepository implements CrudRepository<Long, Feedback> {

    private final DSLContext dsl;

    @Override
    public Feedback insert(Feedback feedback) {
        return dsl.insertInto(Feedbacks.FEEDBACKS)
                .set(dsl.newRecord(Feedbacks.FEEDBACKS, feedback))
                .returning()
                .fetchOne()
                .into(Feedback.class);
    }

    @Override
    public Feedback update(Feedback feedback) {
        return dsl.update(Feedbacks.FEEDBACKS)
                .set(dsl.newRecord(Feedbacks.FEEDBACKS, feedback))
                .where(Feedbacks.FEEDBACKS.ID.eq(feedback.getId()))
                .returning()
                .fetchOne()
                .into(Feedback.class);
    }

    @Override
    public Feedback find(Long id) {
        return dsl.selectFrom(Feedbacks.FEEDBACKS)
                .where(Feedbacks.FEEDBACKS.ID.eq(id))
                .fetchAny()
                .into(Feedback.class);
    }

    @Override
    public List<Feedback> findAll(Condition condition) {
        return dsl.selectFrom(Feedbacks.FEEDBACKS)
                .where(condition)
                .fetch()
                .into(Feedback.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(Feedbacks.FEEDBACKS)
                .where(Feedbacks.FEEDBACKS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
