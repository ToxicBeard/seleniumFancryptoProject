package ru.toxic.repository;

import io.vavr.Tuple;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Repository;
import ru.toxic.model.Table;

import java.util.Collection;
import java.util.Optional;

import static ru.toxic.common.Common.getTableKey;
import static ru.toxic.common.Common.getUsedDriverKey;

@Repository
public class TestCache implements DriverRepository, TableRepository {

    @Override
    public WebDriver getDriver(Tuple name) {
        return Optional.ofNullable(
                DRIVER_CONCURRENT_MAP.get(name))
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                String.format(
                                        "No Driver for thread: %s",
                                        name.toString()
                                )
                        )
                );
    }

    @Override
    public Collection<WebDriver> getAllDrivers() {
        return DRIVER_CONCURRENT_MAP.values();
    }

    @Override
    public void save(WebDriver driver) {
        DRIVER_CONCURRENT_MAP.put(getUsedDriverKey(), driver);
    }

    @Override
    public Table getTable(Tuple key) {
        return Optional.ofNullable(
                TABLE_CONCURRENT_MAP.get(key))
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                String.format(
                                        "No Table: %s",
                                        key.toString()
                                )
                        )
                );
    }

    @Override
    public Collection<Table> getAllTables() {
        return TABLE_CONCURRENT_MAP.values();
    }

    @Override
    public void save(Table table) {
        TABLE_CONCURRENT_MAP.put(getTableKey(), table);
    }

    @Override
    public void save(Table table, String key) {
        TABLE_CONCURRENT_MAP.put(getTableKey(key), table);
    }
}
