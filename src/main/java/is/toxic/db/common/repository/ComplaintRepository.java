package is.toxic.db.common.repository;

import is.toxic.db.common.dto.Complaint;
import is.toxic.db.data.tables.Balances;
import is.toxic.db.data.tables.Complaints;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComplaintRepository implements CrudRepository<Long, Complaint> {

    private final DSLContext dsl;

    @Autowired
    public ComplaintRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

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
    public Complaint find(Condition condition) {
        return dsl.selectFrom(Complaints.COMPLAINTS)
                .where(condition)
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
