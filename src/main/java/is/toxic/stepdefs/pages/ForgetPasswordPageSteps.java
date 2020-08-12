package is.toxic.stepdefs.pages;

import io.cucumber.java8.Ru;
import static io.vavr.control.Try.run;
import org.springframework.beans.factory.annotation.Autowired;
import static is.toxic.common.Common.getUsedDriverKey;
import is.toxic.page.ForgetPasswordPage;
import is.toxic.repository.DriverRepository;

public class ForgetPasswordPageSteps implements Ru {

    @Autowired
    private DriverRepository driverRepository;

    private ForgetPasswordPage page;

    public ForgetPasswordPageSteps() {
        Допустим("^ввожу ([^\"]*) в поле email/номер телефона формы на странице Восстановление пароля$", (String data) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setPhoneEmail(data))
                                .get()
        );
        Допустим("^ввожу ([^\"]*) в поле пароль формы на странице Восстановление пароля$", (String data) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setPassword(data))
                                .get()
        );
        Допустим("^ввожу ([^\"]*) в поле подтверждение пароля формы на странице Восстановление пароля$", (String data) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setConfirmPassword(data))
                                .get()
        );
        Допустим("^ввожу ([^\"]*) в поле код восстановления формы на странице Восстановление пароля$", (String data) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setRecoveryCode(data))
                                .get()
        );
        Допустим("^нажимаю на кнопку \"Отправить код\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickSendRecoveryCodeButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Изменить пароль\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickChangePasswordButton())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Счета\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBillsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Покупка/Продажа\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBuySaleLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"fancrypto.ru\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHomeLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Вход/регистрация\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLoginRegistrationLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Панель управления\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDashboardLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Benefits\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBenefitsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Company\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickCompanyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Development\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDevelopmentLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Employee Success\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickEmployeeSuccessLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"facebook\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickFacebookLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Hosting\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHostingLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"instagram\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickInstagramLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Jod Openings\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickJobOpeningsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Legacy\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLegacyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Team\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTeamLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"twitter\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTwitterLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Web Design\" на странице Восстановление пароля$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickWebdesignLink())
                        .get()
        );
    }

    private void createIfNotExist() {
        page = page == null ? ForgetPasswordPage.builder().driver(driverRepository.getDriver(getUsedDriverKey())).build() : page;
    }
}
