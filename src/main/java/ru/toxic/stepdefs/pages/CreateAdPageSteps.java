package ru.toxic.stepdefs.pages;

import io.cucumber.java8.Ru;
import org.springframework.beans.factory.annotation.Autowired;
import ru.toxic.page.CreateAdPage;
import ru.toxic.repository.DriverRepository;

import static io.vavr.control.Try.run;
import static ru.toxic.common.Common.getUsedDriverKey;

public class CreateAdPageSteps implements Ru {

    @Autowired
    private DriverRepository driverRepository;

    private CreateAdPage page;

    public CreateAdPageSteps() {
        Допустим("^нажимаю кнопку \"-\" поля \"Прибыль\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickMinusProfitButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"+\" поля \"Прибыль\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickPlusProfitButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Опубликовать объявление\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickReleaseDealButton())
                        .get()
        );
        Допустим("^переключаю радио кнопку \"Я хочу...\" в состояние \"Продать криптовалюту онлайн\" на странице Создание объявления", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableSaleRadioButton())
                        .get()
        );
        Допустим("^переключаю радио кнопку \"Я хочу...\" в состояние \"Купить криптовалюту онлайн\" на странице Создание объявления", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableBuyRadioButton())
                        .get()
        );
        Допустим("^включаю чекбокс \"Следить за ликвидностью\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableLiquidSawCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Следить за ликвидностью\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableLiquidSawCheckbox())
                        .get()
        );
        Допустим("^включаю чекбокс \"Не показывать объявление анонимным пользователям\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableNotForAnonymousCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Не показывать объявление анонимным пользователям\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableNotForAnonymousCheckbox())
                        .get()
        );
        Допустим("^включаю чекбокс \"Номер телефона подтвержден\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enablePhoneVerifiedCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Номер телефона подтвержден\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disablePhoneVerifiedCheckbox())
                        .get()
        );
        Допустим("^включаю чекбокс \"Только доверенные пользователи\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableOnlyTrustedUsersCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Только доверенные пользователи\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableOnlyTrustedUsersCheckbox())
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Заголовок\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setDealHead(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Местоположение\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setCountry(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Окно оплаты\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setTimeForPayment(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Прибыль\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setProfit(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Уравнение цены\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setProfitEquation(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Минимальный лимит транзакции\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setMinTransactionInput(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Максимальный лимит транзакции\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setMaxTransactionInput(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле \"Условия сделки\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setDealInfo(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) в поле \"Валюта\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectCurrency(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) в поле \"Способ оплаты\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectPaySystemForText(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) в поле \"Способ оплаты\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectPaySystemForValue(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) в первом столбце строки \"Вск\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectSundayStartForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) в первом столбце строки \"Вск\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectSundayStart(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) во втором столбце строки \"Вск\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectSundayStopForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) во втором столбце строки \"Вск\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectSundayStop(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) в первом столбце строки \"Пнд\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectMondayStartForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) в первом столбце строки \"Пнд\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectMondayStart(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) во втором столбце строки \"Пнд\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectMondayStopForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) во втором столбце строки \"Пнд\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectMondayStop(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) в первом столбце строки \"Втр\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectTuesdayStartForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) в первом столбце строки \"Втр\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectTuesdayStart(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) во втором столбце строки \"Втр\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectTuesdayStopForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) во втором столбце строки \"Втр\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectTuesdayStop(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) в первом столбце строки \"Срд\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectWednesdayStartForIntervalNum(data))
                        .get()
        );

        Допустим("^выставляю значение ([^\"]*) в первом столбце строки \"Срд\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectWednesdayStart(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) во втором столбце строки \"Срд\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectWednesdayStopForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) во втором столбце строки \"Срд\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectWednesdayStop(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) в первом столбце строки \"Чтв\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectThursdayStartForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) в первом столбце строки \"Чтв\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectThursdayStart(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) во втором столбце строки \"Чтв\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectThursdayStopForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) во втором столбце строки \"Чтв\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectThursdayStop(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) в первом столбце строки \"Птн\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectFridayStartForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) в первом столбце строки \"Птн\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectFridayStart(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) во втором столбце строки \"Птн\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectFridayStopForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) во втором столбце строки \"Птн\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectFridayStop(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) в первом столбце строки \"Сбт\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectSaturdayStartForIntervalNum(data))
                        .get()
        );

        Допустим("^выставляю значение ([^\"]*) в первом столбце строки \"Сбт\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectSaturdayStart(data))
                        .get()
        );
        Допустим("^выставляю значение с текстом ([^\"]*) во втором столбце строки \"Сбт\" поля \"Часы работы\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectSaturdayStopForIntervalNum(data))
                        .get()
        );
        Допустим("^выставляю значение ([^\"]*) во втором столбце строки \"Сбт\" на странице Создание объявления$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.selectSaturdayStop(data))
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Счета\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBillsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Покупка/Продажа\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBuySaleLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"fancrypto.ru\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHomeLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Вход/регистрация\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLoginRegistrationLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Панель управления\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDashboardLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Benefits\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBenefitsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Company\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickCompanyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Development\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDevelopmentLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Employee Success\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickEmployeeSuccessLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"facebook\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickFacebookLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Hosting\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHostingLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"instagram\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickInstagramLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Jod Openings\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickJobOpeningsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Legacy\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLegacyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Team\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTeamLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"twitter\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTwitterLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Web Design\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickWebdesignLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Выход\" на странице Создание объявления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickExitLink())
                        .get()
        );
    }

    private void createIfNotExist() {
        page = page == null ? CreateAdPage.builder().driver(driverRepository.getDriver(getUsedDriverKey())).build() : page;
    }
}