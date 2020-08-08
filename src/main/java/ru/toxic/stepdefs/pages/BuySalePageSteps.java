package ru.toxic.stepdefs.pages;

import io.cucumber.java8.Ru;
import org.springframework.beans.factory.annotation.Autowired;
import ru.toxic.page.BuySalePage;
import ru.toxic.repository.DriverRepository;

import static io.vavr.control.Try.run;
import static ru.toxic.common.Common.getUsedDriverKey;

public class BuySalePageSteps implements Ru {

    @Autowired
    private DriverRepository driverRepository;

    private BuySalePage page;

    public BuySalePageSteps() {
        Допустим("^ввожу ([^\"]*) в поле поиска формы на странице Покупка/Продажа$", (String value) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setSum(value))
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Поиск\" поиска  формы на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickSearchButton())
                        .get()
        );
        Допустим("переключаю на тип сделки (продажа|покупка)  форму на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickAnotherDealType())
                        .get()
        );
        Допустим("^выбираю в списке поиска формы Покупка/Продажа страну с названием ([^\"]*)  на странице Покупка/Продажа$", (String countryName) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setCountryByText(countryName))
                                .get()
        );
        Допустим("^выбираю в списке поиска формы Покупка/Продажа страну с кодом ([^\"]*) на странице Покупка/Продажа$", (String countryValue) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setCountryByValue(countryValue))
                                .get()
        );
        Допустим("^выбираю в списке поиска формы Покупка/Продажа валюту ([^\"]*) на странице Покупка/Продажа$", (String currency) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setCurrency(currency))
                                .get()
        );
        Допустим("^выбираю в списке поиска формы Покупка/Продажа систему оплаты с названием ([^\"]*) на странице Покупка/Продажа$", (String paySystem) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setPaySystemByText(paySystem))
                                .get()
        );
        Допустим("^выбираю в списке поиска формы Покупка/Продажа систему оплаты с кодом ([^\"]*) на странице Покупка/Продажа$", (String paySystem) ->
                        run(this::createIfNotExist)
                                .andThen(() -> page.setPaySystemByValue(paySystem))
                                .get()
        );
        Допустим("^нажимаю ссылку перехода \"Счета\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBillsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Покупка/Продажа\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBuySaleLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"fancrypto.ru\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHomeLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Вход/регистрация\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLoginRegistrationLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Панель управления\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDashboardLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Benefits\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBenefitsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Company\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickCompanyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Development\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDevelopmentLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Employee Success\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickEmployeeSuccessLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"facebook\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickFacebookLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Hosting\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHostingLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"instagram\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickInstagramLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Jod Openings\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickJobOpeningsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Legacy\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLegacyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Team\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTeamLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"twitter\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTwitterLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Web Design\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickWebdesignLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Выход\" на странице Покупка/Продажа$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickExitLink())
                        .get()
        );
    }

    private void createIfNotExist() {
        page = page == null ? BuySalePage.builder().driver(driverRepository.getDriver(getUsedDriverKey())).build() : page;
    }
}
