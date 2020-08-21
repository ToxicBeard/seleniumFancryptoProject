package is.toxic.stepdefs;

import io.cucumber.java8.Ru;
import io.vavr.control.Try;
import is.toxic.db.common.repository.UserDataRepository;
import is.toxic.db.data.tables.UserDatas;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDataCheckSteps implements Ru {

    @Autowired
    private UserDataRepository userDataRepository;

    public UserDataCheckSteps() {
        Допустим("проверяю, что в таблице userDatas есть пользователь с логином {string}", (String login) ->
                Try.of(() -> userDataRepository.findAll(UserDatas.USER_DATAS.USER_NAME.eq(login)))
                        .andThen(rows -> Assert.assertEquals(String.format("Количество найденых записей для логина %s !=1", login), 1, rows.size()))
        );
        Допустим("проверяю, что в таблице userDatas нет пользователя с логином {string}", (String login) ->
                Try.of(() -> userDataRepository.findAll(UserDatas.USER_DATAS.USER_NAME.eq(login)))
                        .andThen(rows -> Assert.assertEquals(String.format("Количество найденых записей для логина %s != 0", login), 0, rows.size()))
        );
    }
}
