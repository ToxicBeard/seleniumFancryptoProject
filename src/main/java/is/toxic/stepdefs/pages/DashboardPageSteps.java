package is.toxic.stepdefs.pages;

import io.cucumber.java8.Ru;
import static io.vavr.control.Try.run;
import org.springframework.beans.factory.annotation.Autowired;
import static is.toxic.common.Common.getUsedDriverKey;
import is.toxic.page.DashboardPage;
import is.toxic.repository.DriverRepository;
import is.toxic.repository.TableRepository;

public class DashboardPageSteps implements Ru {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TableRepository tableRepository;

    private DashboardPage page;

    public DashboardPageSteps() {
        Допустим("^нажимаю кнопку \"Объявления\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickAdsButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Открытые сделки\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickOpenDealsButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Завершённые сделки\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickEndsDealsButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Отменённые сделки\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickCanceledDealsButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Диспуты\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickDisputsButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Больше сделок\" на вкладке \"(Открытые сделки|Завершённые сделки|Отменённые сделки|Диспуты)\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickMoreDealsButton())
                        .get()
        );
        Допустим("^нажимаю кнопку \"Включено\" на сделке с номером (\\d\\d|\\d) на вкладке \"Объявления\" на странице Панель управления$", (Integer row) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickOnButtonForDeal(row))
                        .get()
        );
        Допустим("^нажимаю кнопку \"Редактировать\" на сделке с номером (\\d\\d|\\d) на вкладке \"Объявления\" на странице Панель управления$", (Integer row) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickEditButtonForDeal(row))
                        .get()
        );
        Допустим("^нажимаю кнопку \"Удалить\" на сделке с номером (\\d\\d|\\d) на вкладке \"Объявления\" на странице Панель управления$", (Integer row) ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickDeleteButtonForDeal(row))
                        .get()
        );
        Допустим("^нажимаю кнопку \"Создать объявление\" на вкладке \"Объявления\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.clickCreateAdButton())
                        .get()
        );
        Допустим("^включаю чекбокс \"Продажи временно приостановлены\" на вкладке \"Объявления\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableStopSalesCheckbox())
                        .get()
        );
        Допустим("^включаю чекбокс \"Покупки временно приостановлены\" на вкладке \"Объявления\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.enableStopBuysCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Продажи временно приостановлены\" на вкладке \"Объявления\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableStopSalesCheckbox())
                        .get()
        );
        Допустим("^выключаю чекбокс \"Покупки временно приостановлены\" на вкладке \"Объявления\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.disableStopBuysCheckbox())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Счета\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBillsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Покупка/Продажа\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBuySaleLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"fancrypto.ru\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHomeLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Вход/регистрация\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLoginRegistrationLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Панель управления\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDashboardLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Benefits\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickBenefitsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Company\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickCompanyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Development\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickDevelopmentLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Employee Success\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickEmployeeSuccessLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"facebook\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickFacebookLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Hosting\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickHostingLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"instagram\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickInstagramLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Jod Openings\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickJobOpeningsLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Legacy\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickLegacyLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Team\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTeamLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"twitter\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickTwitterLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Web Design\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickWebdesignLink())
                        .get()
        );
        Допустим("^нажимаю ссылку перехода \"Выход\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> page.getMainPage().clickExitLink())
                        .get()
        );
        Допустим("^сохраняю таблицу вкладки \"Объявления\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> tableRepository.save(page.getAdsTable()))
                        .get()
        );
        Допустим("^сохраняю таблицу вкладки \"Открытые сделки\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> tableRepository.save(page.getOpenDealsTable()))
                        .get()
        );
        Допустим("^сохраняю таблицу вкладки \"Завершённые сделки\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> tableRepository.save(page.getEndsDealsTable()))
                        .get()
        );
        Допустим("^сохраняю таблицу вкладки \"Отменённые сделки\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> tableRepository.save(page.getCanceledDealsTable()))
                        .get()
        );
        Допустим("^сохраняю таблицу вкладки \"Диспуты\" на странице Панель управления$", () ->
                run(this::createIfNotExist)
                        .andThen(() -> tableRepository.save(page.getDisputsTable()))
                        .get()
        );
        Допустим("^сохраняю с ключом ([^\"]*) таблицу вкладки \"Объявления\" на странице Панель управления$", (String key) ->
                run(this::createIfNotExist)
                        .andThen(() -> tableRepository.save(page.getAdsTable(), key))
                        .get()
        );
        Допустим("^сохраняю с ключом ([^\"]*) таблицу вкладки \"Открытые сделки\" на странице Панель управления$", (String key) ->
                run(this::createIfNotExist)
                        .andThen(() -> tableRepository.save(page.getOpenDealsTable(), key))
                        .get()
        );
        Допустим("^сохраняю с ключом ([^\"]*) таблицу вкладки \"Завершённые сделки\" на странице Панель управления$", (String key) ->
                run(this::createIfNotExist)
                        .andThen(() -> tableRepository.save(page.getEndsDealsTable(), key))
                        .get()
        );
        Допустим("^сохраняю с ключом ([^\"]*) таблицу вкладки \"Отменённые сделки\" на странице Панель управления$", (String key) ->
                run(this::createIfNotExist)
                        .andThen(() -> tableRepository.save(page.getCanceledDealsTable(), key))
                        .get()
        );
        Допустим("^сохраняю с ключом ([^\"]*) таблицу вкладки \"Диспуты\" на странице Панель управления$", (String key) ->
                run(this::createIfNotExist)
                        .andThen(() -> tableRepository.save(page.getDisputsTable(), key))
                        .get()
        );
    }

    private void createIfNotExist() {
        page = page == null ? DashboardPage.builder().driver(driverRepository.getDriver(getUsedDriverKey())).build() : page;
    }
}
