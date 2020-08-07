package ru.toxic.common;

import io.vavr.Tuple;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static io.vavr.control.Try.run;

@Component
public class Common {

    @NonNull
    public static Tuple getUsedDriverKey() {
        return Tuple.of(Thread.currentThread().getName());
    }

    public static void selectValueFromSelectByValue(@NonNull WebElement select, @NonNull WebDriverWait wait, @NonNull String value) {
        run(() -> wait.until(ExpectedConditions.elementToBeClickable(select)))
                .andThen(select::click)
                .andThen(() -> new Select(select).selectByValue(value))
                .andThen(select::click)
                .get();
    }

    public static void selectValueFromSelectByText(@NonNull WebElement select, @NonNull WebDriverWait wait, @NonNull String text) {
        run(() -> wait.until(ExpectedConditions.elementToBeClickable(select)))
                .andThen(select::click)
                .andThen(() -> new Select(select).selectByVisibleText(text))
                .andThen(select::click)
                .get();
    }

    public static void setDataToInput(@NonNull WebElement input, @NonNull WebDriverWait wait, @NonNull String data) {
        run(() -> wait.until(ExpectedConditions.elementToBeClickable(input)))
                .andThen(input::clear)
                .andThen(() -> input.sendKeys(data))
                .get();
    }

    public static void enableHideCheckbox(@NonNull WebElement parentElement, @NonNull WebElement checkbox, @NonNull WebDriverWait wait) {
        run(() -> wait.until(ExpectedConditions.elementToBeClickable(parentElement)))
                .andThen(() -> run(() -> {
                    if (!checkbox.isDisplayed()) {
                        parentElement.click();
                    }
                }).get())
                .andThen(() -> enableCheckbox(checkbox, wait))
                .get();
    }

    public static void enableCheckbox(@NonNull WebElement checkbox, @NonNull WebDriverWait wait) {
        run(() -> wait.until(ExpectedConditions.elementToBeClickable(checkbox)))
                .andThen(() -> {
                    if (!checkbox.isSelected()) {
                        checkbox.click();
                    }
                }).get();
    }

    public static void disableHideCheckbox(@NonNull WebElement parentElement, @NonNull WebElement checkbox, @NonNull WebDriverWait wait) {
        run(() -> wait.until(ExpectedConditions.elementToBeClickable(parentElement)))
                .andThen(() -> run(() -> {
                    if (!checkbox.isDisplayed()) {
                        parentElement.click();
                    }
                }).get())
                .andThen(() -> disableCheckbox(checkbox, wait))
                .get();
    }

    public static void disableCheckbox(@NonNull WebElement checkbox, @NonNull WebDriverWait wait) {
        run(() -> wait.until(ExpectedConditions.elementToBeClickable(checkbox)))
                .andThen(() -> {
                    if (checkbox.isSelected()) {
                        checkbox.click();
                    }
                }).get();
    }
}
