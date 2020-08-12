package is.toxic.db.data.repository;

import is.toxic.db.data.dto.User;
import is.toxic.db.data.tables.UserDatas;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserDataRepository implements CrudRepository< Long,User> {

    private final DSLContext dsl;

    @Override
    public User insert(User user) {
        return dsl.insertInto(UserDatas.USER_DATAS)
                .set(dsl.newRecord(UserDatas.USER_DATAS, user))
                .returning()
                .fetchOne()
                .into(User.class);
    }

    @Override
    public User update(User user) {
        return dsl.update(UserDatas.USER_DATAS)
                .set(dsl.newRecord(UserDatas.USER_DATAS, user))
                .where(UserDatas.USER_DATAS.ID.eq(user.getId()))
                .returning()
                .fetchOne()
                .into(User.class);
    }

    @Override
    public User find(Long id) {
        return dsl.selectFrom(UserDatas.USER_DATAS)
                .where(UserDatas.USER_DATAS.ID.eq(id))
                .fetchAny()
                .into(User.class);
    }

    @Override
    public List<User> findAll(Condition condition) {
        return dsl.selectFrom(UserDatas.USER_DATAS)
                .where(condition)
                .fetch()
                .into(User.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(UserDatas.USER_DATAS)
                .where(UserDatas.USER_DATAS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
