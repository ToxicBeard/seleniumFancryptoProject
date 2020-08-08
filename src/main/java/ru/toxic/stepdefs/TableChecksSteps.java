package ru.toxic.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.Ru;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import ru.toxic.repository.TableRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.toxic.common.Common.getTableKey;

public class TableChecksSteps implements Ru {

    @Autowired
    private TableRepository tableRepository;

    public TableChecksSteps() {
        Допустим("проверяю, что таблица имеет названия столбцов:", (DataTable datatable) ->
                Try.of(datatable::asList).andThen(expected -> Try.of(() ->
                        tableRepository.getTable(getTableKey()).getHeads())
                        .andThen(actual -> assertEquals("Полученое колличество названий столбцов не совпадает с ожидаемым", expected.size(), actual.size()))
                        .andThen(actual -> assertTrue("Полученые названия столбцов отличаются от ожидаемых", expected.containsAll(actual)))
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
