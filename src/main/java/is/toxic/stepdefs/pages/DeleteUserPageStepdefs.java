package is.toxic.stepdefs.pages;

import io.cucumber.java8.Ru;
import is.toxic.page.DeleteUserPage;
import is.toxic.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static io.vavr.control.Try.run;
import static is.toxic.common.Common.getUsedDriverKey;

public class DeleteUserPageStepdefs implements Ru {

    @Autowired
    private DriverRepository driverRepository;

    private DeleteUserPage page;

    public DeleteUserPageStepdefs() {
        Допустим("ввожу {string} в поле \"Ваш текущий пароль\" на странице Удаление пользователя", (String pass) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setPassword(pass))
                        .get()
        );
        Допустим("нажимаю кнопку \"удалить\" на странице Удаление пользователя", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickDeleteButton())
                        .get()
        );
    }

    private void createIfNotExist() {
        page = page == null ? DeleteUserPage.builder().driver(driverRepository.getDriver(getUsedDriverKey())).build() : page;
    }

}
