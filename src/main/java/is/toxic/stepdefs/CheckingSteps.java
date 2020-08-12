package is.toxic.stepdefs;

import io.cucumber.java8.Ru;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import static is.toxic.common.Common.getUsedDriverKey;
import is.toxic.repository.DriverRepository;

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
