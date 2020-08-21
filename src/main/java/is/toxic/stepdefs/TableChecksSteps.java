package is.toxic.stepdefs;

import io.cucumber.java8.Ru;
import io.vavr.control.Try;
import is.toxic.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static is.toxic.common.Common.getTableKey;
import static org.junit.Assert.assertEquals;

public class TableChecksSteps implements Ru {

    @Autowired
    private TableRepository tableRepository;

    public TableChecksSteps() {
        Допустим("проверяю, что таблица имеет названия столбцов: {string}", (String arg) ->
                Try.of(() -> List.of(arg.split(", ")))
                        .andThen(expected -> Try.of(() ->
                                tableRepository.getTable(getTableKey()).getHeads())
                                .andThen(actual -> Try.run(() -> actual.removeIf(word -> word.equals(""))).get())
                                .andThen(actual -> assertEquals("Полученое колличество названий столбцов не совпадает с ожидаемым", expected.size(), actual.size()))
                                .andThen(actual -> assertEquals("Полученые названия столбцов отличаются от ожидаемых", expected, actual))
                                .get())
                        .get()
        );
        Допустим("вывести в консоль строки", () ->
                Try.of(() ->
                        tableRepository.getTable(getTableKey()).getRows())
                        .andThen(rows -> System.out.println(rows.size()))
                        .get()
                        .forEach(ros -> System.out.println(ros.getText()))
        );
    }
}
