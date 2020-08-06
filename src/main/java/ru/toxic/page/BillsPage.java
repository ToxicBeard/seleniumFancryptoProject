package ru.toxic.page;

import io.vavr.control.Try;
import lombok.Builder;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.toxic.common.Common.setDataToInput;

public class BillsPage {

    private final WebDriverWait wait;

    @Getter
    private final MainPage mainPage;

    @FindBy(css = ".dropdown-toggle")
    private WebElement typeSelect;

    //types start

    @FindBy(css = "button.dropdown-item:nth-child(1)")
    private WebElement billType;

    @FindBy(css = "button.dropdown-item:nth-child(2)")
    private WebElement paymentType;

    //types ends

    @FindBy(css = ".form-control")
    private WebElement numInput;

    @FindBy(css = ".btn-outline-warning")
    private WebElement searchButton;

    @Builder
    public BillsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 120);
        mainPage =  MainPage.builder().driver(driver).build();
        mainPage.clickBillsLink();
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getHomeLink()));
        PageFactory.initElements(driver, this);
    }

    public void setBillType() {
        Try.run(() -> wait.until(ExpectedConditions.elementToBeClickable(typeSelect)))
                .andThen(() -> typeSelect.click())
                .andThen(() -> billType.click())
                .get();
    }

    public void setPaymentType() {
        Try.run(() -> wait.until(ExpectedConditions.elementToBeClickable(typeSelect)))
                .andThen(() -> typeSelect.click())
                .andThen(() -> paymentType.click())
                .get();
    }

    public void setBillNum(String billNum) {
        setDataToInput(numInput, wait, billNum);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

}
