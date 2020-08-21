package is.toxic.stepdefs;

import io.cucumber.java8.Ru;
import io.vavr.control.Try;
import is.toxic.db.common.repository.UserDataRepository;
import is.toxic.db.data.tables.UserDatas;
import is.toxic.page.LoginRegistrationPage;
import is.toxic.page.ProfilePage;
import is.toxic.repository.DriverRepository;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import static is.toxic.common.Common.getUsedDriverKey;


public class TestDataGenerateSteps implements Ru {

    @Autowired
    private DriverRepository repository;

    @Autowired
    private UserDataRepository userDataRepository;

    public TestDataGenerateSteps() {
        Допустим("^регистрирую ([^\"]*) пользователей с префиксом ([^\"]*) и паролем ([^\"]*)$",
                (Integer userCount, String userName, String password) -> {
                    for (int i = 0; i < userCount; i++) {
                        String login = userName.concat(String.valueOf(i));
                        new LoginRegistrationPage(repository.getDriver(getUsedDriverKey()))
                                .registerUser(login, password);
                        Try.of(() -> userDataRepository.findAll(UserDatas.USER_DATAS.USER_NAME.eq(login)))
                                .andThen(rows ->
                                        Assert.assertEquals(String.format("Количество найденых записей для логина %s !=1", login), 1, rows.size()))
                                .get();
                        new ProfilePage(repository.getDriver(getUsedDriverKey())).getMainPage().clickExitLink();
                        Thread.sleep(1000L);
                    }
                }
        );
    }
}
