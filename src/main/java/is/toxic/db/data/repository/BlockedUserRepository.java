package is.toxic.db.data.repository;

import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import is.toxic.db.data.tables.BlockedUsers;
import is.toxic.db.data.dto.BlockedUser;
import is.toxic.repository.CrudRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BlockedUserRepository implements CrudRepository<Long, BlockedUser> {

    private final DSLContext dsl;


    @Override
    public BlockedUser insert(BlockedUser blockedUser) {
        return dsl.insertInto(BlockedUsers.BLOCKED_USERS)
                .set(dsl.newRecord(BlockedUsers.BLOCKED_USERS, blockedUser))
                .returning()
                .fetchOne()
                .into(BlockedUser.class);
    }

    @Override
    public BlockedUser update(BlockedUser blockedUser) {
        return dsl.update(BlockedUsers.BLOCKED_USERS)
                .set(dsl.newRecord(BlockedUsers.BLOCKED_USERS, blockedUser))
                .where(BlockedUsers.BLOCKED_USERS.ID.eq(blockedUser.getId()))
                .returning()
                .fetchOne()
                .into(BlockedUser.class);
    }

    @Override
    public BlockedUser find(Long id) {
        return dsl.selectFrom(BlockedUsers.BLOCKED_USERS)
                .where(BlockedUsers.BLOCKED_USERS.ID.eq(id))
                .fetchAny()
                .into(BlockedUser.class);
    }

    @Override
    public List<BlockedUser> findAll(Condition condition) {
        return dsl.selectFrom(BlockedUsers.BLOCKED_USERS)
                .where(condition)
                .fetch()
                .into(BlockedUser.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(BlockedUsers.BLOCKED_USERS)
                .where(BlockedUsers.BLOCKED_USERS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
