package is.toxic.stepdefs;

import io.cucumber.java8.Ru;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import is.toxic.common.BrowserDriver;
import static is.toxic.common.Common.getUsedDriverKey;
import is.toxic.repository.DriverRepository;

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