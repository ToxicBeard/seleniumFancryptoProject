package ru.toxic.repository;

import io.vavr.Tuple;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Repository;
import ru.toxic.common.Common;

import java.util.Collection;
import java.util.Optional;

@Repository
public class TestCache implements DriverRepository {

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
        DRIVER_CONCURRENT_MAP.put(Common.getUsedDriverKey(), driver);
    }
}
