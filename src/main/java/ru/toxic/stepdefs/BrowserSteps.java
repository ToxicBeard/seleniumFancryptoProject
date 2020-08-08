package ru.toxic.stepdefs;

import io.cucumber.java8.Ru;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.toxic.common.BrowserDriver;
import ru.toxic.repository.DriverRepository;

import static ru.toxic.common.Common.getUsedDriverKey;

@Slf4j
public class BrowserSteps implements Ru {

    @Autowired
    private DriverRepository repository;

    public BrowserSteps() {
        Дано("выбираю {string} браузер", (String browserName) ->
                repository.save(BrowserDriver.valueOf(browserName).create())
        );
        Допустим("завершаю сессию браузера", () ->
                repository.getDriver(getUsedDriverKey()).quit()
        );
        Допустим("завершаю сессию IE", () ->
                Try.of(() -> Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe")).get()
        );
        After(scenario -> {
                    if (scenario.isFailed()) repository.getDriver(getUsedDriverKey()).quit();
                }
        );
    }
}