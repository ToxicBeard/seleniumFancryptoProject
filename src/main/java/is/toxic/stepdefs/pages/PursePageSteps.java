package is.toxic.stepdefs.pages;

import io.cucumber.java8.Ru;
import static io.vavr.control.Try.run;
import org.springframework.beans.factory.annotation.Autowired;
import static is.toxic.common.Common.getUsedDriverKey;
import is.toxic.page.PursePage;
import is.toxic.repository.DriverRepository;

public class PursePageSteps implements Ru {

    @Autowired
    private DriverRepository driverRepository;

    private PursePage page;

    public PursePageSteps() {
        Допустим("^выбираю в списке тип операции \"Исходящие\" на вкладке \"Транзакции\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setOutgoingType())
                        .get()
        );
        Допустим("^выбираю в списке тип операции \"Входящие\" на вкладке \"Транзакции\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setIncomingType())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Баланс\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickBalanceButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Транзакции\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickTransactionButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Получить\" на вкладке \"Баланс\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickGetButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Отправить\" на вкладке \"Баланс\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickSendButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Найти\" на вкладке \"Транзакции\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickSearchButton())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Счета\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBillsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Покупка/Продажа\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBuySaleLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"fancrypto.ru\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHomeLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Вход/регистрация\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLoginRegistrationLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Панель управления\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDashboardLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Benefits\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBenefitsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Company\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickCompanyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Development\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDevelopmentLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Employee Success\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickEmployeeSuccessLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"facebook\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickFacebookLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Hosting\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHostingLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"instagram\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickInstagramLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Jod Openings\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickJobOpeningsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Legacy\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLegacyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Team\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTeamLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"twitter\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTwitterLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Web Design\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickWebdesignLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Выход\" на странице Кошелёк$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickExitLink())
                        .get()
        );
    }

    private void createIfNotExist() {
        page = page == null ? PursePage.builder().driver(driverRepository.getDriver(getUsedDriverKey())).build() : page;
    }
}
