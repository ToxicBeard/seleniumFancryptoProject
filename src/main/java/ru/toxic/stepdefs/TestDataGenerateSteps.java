package ru.toxic.stepdefs;

import io.cucumber.java8.Ru;
import org.springframework.beans.factory.annotation.Autowired;
import ru.toxic.page.LoginRegistrationPage;
import ru.toxic.repository.DriverRepository;

import static ru.toxic.common.Common.getUsedDriverKey;


public class TestDataGenerateSteps implements Ru {

    @Autowired
    private DriverRepository repository;

    public TestDataGenerateSteps() {
        Допустим("^регистрирую ([^\"]*) пользователей с префиксом ([^\"]*) и паролем ([^\"]*)$",
                (Integer userCount, String userName, String password) -> {
                    for (int i = 0; i < userCount; i++) {
                        new LoginRegistrationPage(repository.getDriver(getUsedDriverKey()))
                                .registerUser(userName.concat(String.valueOf(i)), password);
                    }
                }
        );
    }
}
