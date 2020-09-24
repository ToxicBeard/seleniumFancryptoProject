package is.toxic.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.Ru;
import io.vavr.control.Try;
import is.toxic.db.common.dto.Balance;
import is.toxic.db.common.repository.BalanceRepository;
import is.toxic.db.common.repository.UserDataRepository;
import is.toxic.db.data.tables.UserDatas;
import is.toxic.page.CreateAdPage;
import is.toxic.page.LoginRegistrationPage;
import is.toxic.page.ProfilePage;
import is.toxic.repository.DriverRepository;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static is.toxic.common.Common.getUsedDriverKey;
import static is.toxic.model.DealInfo.getDealFromMap;


public class TestDataGenerateSteps implements Ru {

    @Autowired
    private DriverRepository repository;

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private BalanceRepository balanceRepository;

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
        Допустим("создаю сделк(у|и) с параметрами:", (DataTable deaInfoParams) ->
                deaInfoParams.asMaps().forEach(entry ->
                        new CreateAdPage(repository.getDriver(getUsedDriverKey()))
                                .createNewDeal(getDealFromMap(entry)))

        );
        Допустим("изменяю баланс пользователя {string} на {int}", (String user, Integer value) ->
                Try.of(() -> balanceRepository.find(userDataRepository.find(UserDatas.USER_DATAS.USER_NAME.contains(user)).getId()))
                        .andThen(row ->
                                balanceRepository.update(
                                        Balance.builder()
                                                .balance(BigDecimal.valueOf(value))
                                                .currency(row.getCurrency())
                                                .deposited(row.getDeposited())
                                                .id(row.getId())
                                                .owner_fk(row.getOwner_fk())
                                                .unconfirmed_balance(row.getUnconfirmed_balance())
                                                .build())
                        ).get()
        );
    }
}
