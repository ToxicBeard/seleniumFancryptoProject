package ru.toxic.stepdefs.pages;

import io.cucumber.java8.Ru;
import org.springframework.beans.factory.annotation.Autowired;
import ru.toxic.page.ProfilePage;
import ru.toxic.repository.DriverRepository;

import static io.vavr.control.Try.run;
import static ru.toxic.common.Common.getUsedDriverKey;

public class ProfilePageSteps implements Ru {

    @Autowired
    private DriverRepository driverRepository;

    private ProfilePage page;

    public ProfilePageSteps() {
        Допустим("^ввожу ([^\"]*) в поле о себе на странице Профиль$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setIntroduction(data))
                        .get()
        );
        Допустим("^ввожу ([^\"]*) в поле сайт на странице Профиль$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setUserSite(data))
                        .get()
        );
        Допустим("^выбираю в списке Часовой пояс ([^\"]*) на странице Профиль$", (String data) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.setTimezone(data))
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Изменить\" на уровне \"Email\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickChangeEmailButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Изменить\" на уровне \"Пароль\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickChangePasswordButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Изменить\" на уровне \"Номер телефона\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickChangePhoneButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Изменить\" на уровне \"Telegram\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickChangeTelegramNotificationButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Изменить\" на уровне \"Сторонние приложения\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickChangeThirdPartyAppsButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Удалить\" на уровне \"Удаление аккаунта\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickDeleteAccountButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Включить\" на уровне \"Двухфакторная аутентификация\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickEnableTwoFactorAuthenticationButton())
                        .get()
        );
        Допустим("^нажимаю на кнопку \"Смотреть\" на уровне \"Сессии\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickViewSessionsButton())
                        .get()
        );
        Допустим("^изменяю видимость списка чекбоксов, нажимая кнопку \"Предпочтения\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickPreferencesButton())
                        .get()
        );
        Допустим("^включаю чекбокс \"Включить веб-уведомления\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableEnableWebNotificationsCheckbox())
                        .get()
        );
        Допустим("^включаю чекбокс \"Отключить конфиденциальную информацию из уведомлений по электронной почте\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableOffConfidentiallDataToEmailCheckbox())
                        .get()

        );
        Допустим("^включаю чекбокс \"Показывать меня другим пользователям как проверившего настоящее имя\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableProvideAsVerifiedCheckbox())
                        .get()
        );
        Допустим("^включаю чекбокс \"Высылать SMS или уведомления Telegram об отправке биткоинов со счета депонирования\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableSendBitcoinsNotificationsCheckbox())
                        .get()
        );
        Допустим("^включаю чекбокс \"Отправлять SMS или уведомления Telegram о новых контактах по сделкам\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableSendContactsNotificationsCheckbox())
                        .get()
        );
        Допустим("^включаю чекбокс \"Отправлять SMS или уведомления Telegram о новых онлайн-платежах\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableSendPayNotificationsCheckbox())
                        .get()
        );
        Допустим("^включаю чекбокс \"Покупки временно приостановлены\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableStopBuysCheckbox())
                        .get()
        );
        Допустим("^включаю чекбокс \"Продажи временно приостановлены\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableStopSalesCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Включить веб-уведомления\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableEnableWebNotificationsCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Отключить конфиденциальную информацию из уведомлений по электронной почте\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableOffConfidentiallDataToEmailCheckbox())
                        .get()

        );
        Допустим("^выключаю чекбокс \"Показывать меня другим пользователям как проверившего настоящее имя\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableProvideAsVerifiedCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Высылать SMS или уведомления Telegram об отправке биткоинов со счета депонирования\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableSendBitcoinsNotificationsCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Отправлять SMS или уведомления Telegram о новых контактах по сделкам\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableSendContactsNotificationsCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Отправлять SMS или уведомления Telegram о новых онлайн-платежах\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableSendPayNotificationsCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Покупки временно приостановлены\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableStopBuysCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Продажи временно приостановлены\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableStopSalesCheckbox())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Счета\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBillsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Покупка/Продажа\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBuySaleLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"fancrypto.ru\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHomeLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Вход/регистрация\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLoginRegistrationLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Панель управления\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDashboardLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Benefits\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBenefitsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Company\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickCompanyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Development\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDevelopmentLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Employee Success\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickEmployeeSuccessLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"facebook\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickFacebookLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Hosting\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHostingLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"instagram\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickInstagramLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Jod Openings\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickJobOpeningsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Legacy\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLegacyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Team\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTeamLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"twitter\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTwitterLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Web Design\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickWebdesignLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Выход\" на странице Профиль$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickExitLink())
                        .get()
        );
    }

    private void createIfNotExist() {
        page = page == null ? ProfilePage.builder().driver(driverRepository.getDriver(getUsedDriverKey())).build() : page;
    }
}
