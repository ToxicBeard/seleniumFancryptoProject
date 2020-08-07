package ru.toxic.stepdefs.pages;

import io.cucumber.java8.Ru;
import org.springframework.beans.factory.annotation.Autowired;
import ru.toxic.page.BillsPage;
import ru.toxic.repository.DriverRepository;

import static io.vavr.control.Try.run;
import static ru.toxic.common.Common.getUsedDriverKey;

public class BillsPageSteps implements Ru {

    @Autowired
    private DriverRepository repository;

    private BillsPage page;

    public BillsPageSteps() {
        Допустим("^ввожу ([^\"]*) в поле номер счёта формы управление счетами на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setBillNum(data))
                        .get()
        );
        Допустим("^выставляю тип \"Платежи\" в форме управление счетами на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setPaymentType())
                        .get()
        );
        Допустим("^выставляю тип \"Счета\" в форме управление счетами на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setBillType())
                        .get()
        );
        Допустим("^нажимаю кнопку \"поиск\" в форме управление счетами на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickSearchButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Счета выставленные мной\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickBillsFromMeButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Счета выставленные мне\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickBillsToMeButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Платежи от меня\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickPaymentsFromMeButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Платежи мне\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickPaymentsToMeButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Публичные счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickPublicBillsButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Выставить счёт\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickSendBillButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Проверить\" на против \"Партнёр\" в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickCheckPartnerNameButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Создать счёт\" в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickCreateBillButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"-\" на против \"Максимум частей\"  в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickMaxPartsMinusButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"+\" на против \"Максимум частей\" в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickMaxPartsPlusButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"-\" на против \"Минимум частей\" в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickMinPartsMinusButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"+\" на против \"Минимум частей\" в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickMinPartsPlusButton())
                        .get()
        );
        Допустим("^включаю чекбокс \"Ограничить ликвидность\" в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableLimitLiquidCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Ограничить ликвидность\" в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableLimitLiquidCheckbox())
                        .get()
        );
        Допустим("^переключаю радио кнопку \"Основная валюта\" в состояние \"Фиатная валюта\" в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableFiatCurrencyRadiobutton())
                        .get()
        );
        Допустим("^переключаю радио кнопку \"Основная валюта\" в состояние \"Криптовалюта\" в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableCryptoCurrencyRadiobutton())
                        .get()
        );
        Допустим("^переключаю радио кнопку \"Тип счета\" в состояние \"Публичный счет\" в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enablePublicBillRadioButton())
                        .get()
        );
        Допустим("^переключаю радио кнопку \"Тип счета\" в состояние \"Приватный счет\" в форме \"Создание и выставление счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enablePrivateBillRadioButton())
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Комментарий к счету\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setCommentsInput(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Время жизни счета\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setLifetimeInput(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Партнер\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setPartnerNameInput(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Сумма счета\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setSumInput(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Цена за часть\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setPartSumInput(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Максимум частей\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setMaxPartsInput(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Минимум частей\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setMinPartsInput(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) в поле \"Использовать курс биржи\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectCourseByText(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) в поле \"Использовать курс биржи\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectCourseByValue(data))
                        .get()
        );
        Допустим("^выставляю значение временных единиц с текстом ([^\"]*) в поле \"Время жизни счета\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectLifetimeTimeUnitByText(data))
                        .get()
        );
        Допустим("^выставляю значение временных единиц ([^\"]*) в поле \"Время жизни счета\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectLifetimeTimeUnitByValue(data))
                        .get()
        );
        Допустим("^выставляю значение валюты ([^\"]*) в поле \"Сумма счета\" в форме \"Создание и выставление счета\" на странице Счета$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectCurrency(data))
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Счета\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBillsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Покупка/Продажа\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBuySaleLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"fancrypto.ru\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHomeLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Вход/регистрация\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLoginRegistrationLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Панель управления\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDashboardLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Benefits\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBenefitsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Company\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickCompanyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Development\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDevelopmentLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Employee Success\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickEmployeeSuccessLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"facebook\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickFacebookLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Hosting\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHostingLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"instagram\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickInstagramLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Jod Openings\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickJobOpeningsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Legacy\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLegacyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Team\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTeamLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"twitter\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTwitterLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Web Design\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickWebdesignLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Выход\" на странице Счета$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickExitLink())
                        .get()
        );
    }

    private void createIfNotExist() {
        page = (page == null) ? BillsPage.builder().driver(repository.getDriver(getUsedDriverKey())).build() : page;
    }
}
