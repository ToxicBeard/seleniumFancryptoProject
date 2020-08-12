package is.toxic.db.data.repository;

import is.toxic.db.data.dto.UserSnapshot;
import is.toxic.db.data.tables.UserDataSnapshot;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserSnapshotRepository implements CrudRepository<Long, UserSnapshot> {

    private final DSLContext dsl;


    @Override
    public UserSnapshot insert(UserSnapshot userSnapshot) {
        return dsl.insertInto(UserDataSnapshot.USER_DATA_SNAPSHOT)
                .set(dsl.newRecord(UserDataSnapshot.USER_DATA_SNAPSHOT, userSnapshot))
                .returning()
                .fetchOne()
                .into(UserSnapshot.class);
    }

    @Override
    public UserSnapshot update(UserSnapshot userSnapshot) {
        return dsl.update(UserDataSnapshot.USER_DATA_SNAPSHOT)
                .set(dsl.newRecord(UserDataSnapshot.USER_DATA_SNAPSHOT, userSnapshot))
                .where(UserDataSnapshot.USER_DATA_SNAPSHOT.ID.eq(userSnapshot.getId()))
                .returning()
                .fetchOne()
                .into(UserSnapshot.class);
    }

    @Override
    public UserSnapshot find(Long id) {
        return dsl.selectFrom(UserDataSnapshot.USER_DATA_SNAPSHOT)
                .where(UserDataSnapshot.USER_DATA_SNAPSHOT.ID.eq(id))
                .fetchAny()
                .into(UserSnapshot.class);
    }

    @Override
    public List<UserSnapshot> findAll(Condition condition) {
        return dsl.selectFrom(UserDataSnapshot.USER_DATA_SNAPSHOT)
                .where(condition)
                .fetch()
                .into(UserSnapshot.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(UserDataSnapshot.USER_DATA_SNAPSHOT)
                .where(UserDataSnapshot.USER_DATA_SNAPSHOT.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
