package is.toxic.stepdefs.pages;

import io.cucumber.java8.Ru;
import static io.vavr.control.Try.run;
import org.springframework.beans.factory.annotation.Autowired;
import static is.toxic.common.Common.getUsedDriverKey;
import is.toxic.page.LoginRegistrationPage;
import is.toxic.repository.DriverRepository;

public class LoginRegistrationSteps implements Ru {

    @Autowired
    private DriverRepository driverRepository;

    private LoginRegistrationPage page;

    public LoginRegistrationSteps() {
        Допустим("^регистрирую пользователя с логином:([^\"]*) и паролем: ([^\"]*)$", (String login, String password) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.registerUser(login,password))
                        .get()
        );
        Допустим("^авторизуюсь пользователем с логином: ([^\"]*) и паролем: ([^\"]*)$", (String login, String password) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.loginUser(login, password))
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Забыли пароль\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickForgetPassLink())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Войти\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickLoginButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Регистрация\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickRegistrationButton())
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле логин формы входа на странице Вход/регистрация$", (String data) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setLoginForLogin(data))
                                .get()
        );
        Допустим("^ввожу ([^\"]*) в поле пароль формы входа на странице Вход/регистрация$", (String data) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setPasswordForLogin(data))
                                .get()
        );
        Допустим("^ввожу ([^\"]*) в поле логин формы регистрации на странице Вход/регистрация$", (String data) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setLoginForRegistration(data))
                                .get()
        );
        Допустим("^ввожу ([^\"]*) в поле пароль формы регистрации на странице Вход/регистрация$", (String data) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setPasswordForRegistration(data))
                                .get()
        );
        Допустим("^ввожу ([^\"]*) в поле подтверждение пароля формы регистрации на странице Вход/регистрация$", (String data) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setConfirmPassword(data))
                                .get()
        );
        Допустим("^нажимаю ссылку перехода \"Счета\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBillsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Покупка/Продажа\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBuySaleLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"fancrypto.ru\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHomeLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Вход/регистрация\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLoginRegistrationLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Панель управления\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDashboardLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Benefits\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBenefitsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Company\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickCompanyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Development\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDevelopmentLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Employee Success\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickEmployeeSuccessLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"facebook\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickFacebookLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Hosting\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHostingLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"instagram\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickInstagramLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Jod Openings\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickJobOpeningsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Legacy\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLegacyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Team\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTeamLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"twitter\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTwitterLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Web Design\" на странице Вход/регистрация$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickWebdesignLink())
                        .get()
        );
    }

    private void createIfNotExist() {
        page = page == null ? LoginRegistrationPage.builder().driver(driverRepository.getDriver(getUsedDriverKey())).build() : page;
    }
}
