package is.toxic.db.common.repository;

import is.toxic.db.common.dto.JiraCred;
import is.toxic.db.data.tables.JiraCreds;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JiraCredRepository implements CrudRepository<Long, JiraCred> {

    private final DSLContext dsl;

    @Autowired
    public JiraCredRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public JiraCred insert(JiraCred jiraCred) {
        return dsl.insertInto(JiraCreds.JIRA_CREDS)
                .set(dsl.newRecord(JiraCreds.JIRA_CREDS, jiraCred))
                .returning()
                .fetchOne()
                .into(JiraCred.class);
    }

    @Override
    public JiraCred update(JiraCred jiraCred) {
        return dsl.update(JiraCreds.JIRA_CREDS)
                .set(dsl.newRecord(JiraCreds.JIRA_CREDS, jiraCred))
                .where(JiraCreds.JIRA_CREDS.ID.eq(jiraCred.getId()))
                .returning()
                .fetchOne()
                .into(JiraCred.class);
    }

    @Override
    public JiraCred find(Long id) {
        return dsl.selectFrom(JiraCreds.JIRA_CREDS)
                .where(JiraCreds.JIRA_CREDS.ID.eq(id))
                .fetchAny()
                .into(JiraCred.class);
    }

    @Override
    public JiraCred find(Condition condition) {
        return dsl.selectFrom(JiraCreds.JIRA_CREDS)
                .where(condition)
                .fetchAny()
                .into(JiraCred.class);
    }

    @Override
    public List<JiraCred> findAll(Condition condition) {
        return dsl.selectFrom(JiraCreds.JIRA_CREDS)
                .where(condition)
                .fetch()
                .into(JiraCred.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(JiraCreds.JIRA_CREDS)
                .where(JiraCreds.JIRA_CREDS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
