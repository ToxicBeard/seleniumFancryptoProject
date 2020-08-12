package is.toxic.db.data.repository;

import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import is.toxic.db.data.tables.Balances;
import is.toxic.db.data.tables.Complaints;
import is.toxic.db.data.dto.Complaint;
import is.toxic.repository.CrudRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ComplaintRepository implements CrudRepository<Long,Complaint> {

    private final DSLContext dsl;

    @Override
    public Complaint insert(Complaint complaint) {
        return dsl.insertInto(Complaints.COMPLAINTS)
                .set(dsl.newRecord(Complaints.COMPLAINTS, complaint))
                .returning()
                .fetchOne()
                .into(Complaint.class);
    }

    @Override
    public Complaint update(Complaint complaint) {
        return dsl.update(Complaints.COMPLAINTS)
                .set(dsl.newRecord(Complaints.COMPLAINTS, complaint))
                .where(Complaints.COMPLAINTS.ID.eq(complaint.getId()))
                .returning()
                .fetchOne()
                .into(Complaint.class);
    }

    @Override
    public Complaint find(Long id) {
        return dsl.selectFrom(Complaints.COMPLAINTS)
                .where(Complaints.COMPLAINTS.ID.eq(id))
                .fetchAny()
                .into(Complaint.class);
    }

    @Override
    public List<Complaint> findAll(Condition condition) {
        return dsl.selectFrom(Complaints.COMPLAINTS)
                .where(condition)
                .fetch()
                .into(Complaint.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(Complaints.COMPLAINTS)
                .where(Balances.BALANCES.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
