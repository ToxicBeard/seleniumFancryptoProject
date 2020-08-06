package ru.toxic.stepdefs;

import io.cucumber.java8.Ru;
import org.springframework.beans.factory.annotation.Autowired;
import ru.toxic.repository.DriverRepository;

import static org.junit.Assert.assertEquals;
import static ru.toxic.common.Common.getUsedDriverKey;

public class CheckingSteps implements Ru {

    @Autowired
    private DriverRepository repository;

    public CheckingSteps() {
        Допустим("^проверяю, что выполнен переход на страницу с URL ([^\"]*)$", (String url) ->
                assertEquals("Переход не выполнен, либо выполнен на другую страницу",
                        url,
                        repository.getDriver(getUsedDriverKey()).getCurrentUrl()
                )
        );
    }

}
