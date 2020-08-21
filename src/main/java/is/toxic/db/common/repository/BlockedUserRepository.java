package is.toxic.db.common.repository;

import is.toxic.db.common.dto.BlockedUser;
import is.toxic.db.data.tables.BlockedUsers;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlockedUserRepository implements CrudRepository<Long, BlockedUser> {

    private final DSLContext dsl;

    @Autowired
    public BlockedUserRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

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
    public BlockedUser find(Condition condition) {
        return dsl.selectFrom(BlockedUsers.BLOCKED_USERS)
                .where(condition)
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
