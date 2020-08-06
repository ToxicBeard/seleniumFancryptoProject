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

public class PursePage {

    private final WebDriverWait wait;

    @Getter
    private final MainPage mainPage;

    @FindBy(css = "li.w-50:nth-child(1) > a:nth-child(1)")
    private WebElement balanceButton;

    @FindBy(css = "li.w-50:nth-child(2) > a:nth-child(1)")
    private WebElement transactionsButton;

    // balance
    @FindBy(css = ".py-1 > div:nth-child(1) > div:nth-child(5) > button:nth-child(1)")
    private WebElement sendButton;

    @FindBy(css = ".py-1 > div:nth-child(1) > div:nth-child(5) > button:nth-child(2)")
    private WebElement getButton;

    // transactions
    @FindBy(css = "select.form-control:nth-child(2)")
    private WebElement operationTypeSelect;

    @FindBy(css = "select.form-control:nth-child(2) > option:nth-child(1)")
    private WebElement incomingOption;

    @FindBy(css = "select.form-control:nth-child(2) > option:nth-child(2)")
    private WebElement outgoingOption;

    @FindBy(css = "select.form-control:nth-child(1)")
    private WebElement cryptoCurrencySelect;

    @FindBy(css = ".btn")
    private WebElement searchButton;

    @Builder
    public PursePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 120);
        mainPage =  MainPage.builder().driver(driver).build();
        mainPage.clickPurseLink();
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getHomeLink()));
        PageFactory.initElements(driver, this);
    }

    public void setIncomingType() {
        Try.run(() -> wait.until(ExpectedConditions.elementToBeClickable(operationTypeSelect)))
                .andThen(() -> operationTypeSelect.click())
                .andThen(() -> incomingOption.click())
                .get();
    }

    public void setOutgoingType() {
        Try.run(() -> wait.until(ExpectedConditions.elementToBeClickable(operationTypeSelect)))
                .andThen(() -> operationTypeSelect.click())
                .andThen(() -> outgoingOption.click())
                .get();
    }

    public void clickBalanceButton(){
        balanceButton.click();
    }

    public void clickTransactionButton(){
        transactionsButton.click();
    }

    public void clickSendButton(){
        sendButton.click();
    }

    public void clickGetButton(){
        getButton.click();
    }

    public void clickSearchButton(){
        searchButton.click();
    }

}