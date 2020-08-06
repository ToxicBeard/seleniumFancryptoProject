package ru.toxic.repository;

import io.vavr.Tuple;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public interface DriverRepository {

    ConcurrentMap<Tuple, WebDriver> DRIVER_CONCURRENT_MAP = new ConcurrentHashMap<>();

    WebDriver getDriver(Tuple name);

    Collection<WebDriver> getAllDrivers();

    void save(WebDriver driver);
}
