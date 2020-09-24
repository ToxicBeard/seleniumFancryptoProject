package is.toxic.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.Ru;
import io.vavr.control.Try;
import is.toxic.db.common.repository.UserDataRepository;
import is.toxic.db.data.tables.UserDatas;
import is.toxic.model.DealInfo;
import is.toxic.page.CreateAdPage;
import is.toxic.page.LoginRegistrationPage;
import is.toxic.page.ProfilePage;
import is.toxic.repository.DriverRepository;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static is.toxic.common.Common.getUsedDriverKey;


public class TestDataGenerateSteps implements Ru {

    @Autowired
    private DriverRepository repository;

    @Autowired
    private UserDataRepository userDataRepository;

    public TestDataGenerateSteps() {
        Допустим("^регистрирую ([^\"]*) пользователей с префиксом ([^\"]*) и паролем ([^\"]*)$",
                (Integer userCount, String userName, String password) -> {
                    for (int i = 0; i < userCount; i++) {
                        String login = userName.concat(String.valueOf(i));
                        new LoginRegistrationPage(repository.getDriver(getUsedDriverKey()))
                                .registerUser(login, password);
                        Try.of(() -> userDataRepository.findAll(UserDatas.USER_DATAS.USER_NAME.eq(login)))
                                .andThen(rows ->
                                        Assert.assertEquals(String.format("Количество найденых записей для логина %s !=1", login), 1, rows.size()))
                                .get();
                        new ProfilePage(repository.getDriver(getUsedDriverKey())).getMainPage().clickExitLink();
                        Thread.sleep(1000L);
                    }
                }
        );
        Допустим("создаю сделк(и|у) с параметрами:", (DataTable deaInfoParams) ->
                deaInfoParams.asList(DealInfo.class).forEach(
                        info -> new CreateAdPage(repository.getDriver(getUsedDriverKey()))
                                .createNewDeal((DealInfo) info)
                )
        );

        DataTableType((Map<String, String> entry) ->
                DealInfo.builder()
                        .dealInfo(entry.get("условия сделки"))
                        .timeOfPayment(entry.getOrDefault("окно оплаты", null))
                        .profitAvg(entry.getOrDefault("уравнение цены", null))
                        .profit(entry.getOrDefault("прибыль", null))
                        .minTransactionLimit(entry.getOrDefault("минимальный лимит транзакции", null))
                        .maxTransactionLimit(entry.get("максимальный лимит транзакции"))
                        .paymentSystem(entry.get("способ оплаты"))
                        .dealHead(entry.get("заголовок"))
                        .currency(entry.get("валюта"))
                        .country(entry.get("местоположение"))
                        .autoPrice(entry.get("авто цена").equals("да"))
                        .buy(entry.get("тип").equals("покупка"))
                        .forVerifiedNum(entry.get("номер телефона подтвержден").equals("да"))
                        .notForAnon(entry.get("не показывать объявление анонимным пользователям").equals("да"))
                        .onlyTrust(entry.get("только доверенные пользователи").equals("да"))
                        .seeLiq(entry.get("следить за ликвидностью").equals("да"))
                        .monStart(entry.getOrDefault("пнд начало","----"))
                        .tueStart(entry.getOrDefault("втр начало","----"))
                        .wenStart(entry.getOrDefault("срд начало","----"))
                        .thuStart(entry.getOrDefault("чтв начало","----"))
                        .friStart(entry.getOrDefault("птн начало","----"))
                        .satStart(entry.getOrDefault("сбт начало","----"))
                        .sunStart(entry.getOrDefault("вск начало","----"))
                        .monEnd(entry.getOrDefault("пнд конец","----"))
                        .tueEnd(entry.getOrDefault("втр конец","----"))
                        .wenEnd(entry.getOrDefault("срд конец","----"))
                        .thuEnd(entry.getOrDefault("чтв конец","----"))
                        .friEnd(entry.getOrDefault("птн конец","----"))
                        .satEnd(entry.getOrDefault("сбт конец","----"))
                        .sunEnd(entry.getOrDefault("вск конец","----"))
                        .build()
        );
    }
}
