package is.toxic.page;

import io.vavr.control.Try;
import lombok.Builder;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static is.toxic.common.Common.clickLinkOrButton;

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
        mainPage = MainPage.builder().driver(driver).build();
        mainPage.clickPurseLink();
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getHomeLink()));
    }

    public void setIncomingType() {
        Try.run(this::clickTransactionButton)
                .andThen(() -> wait.until(ExpectedConditions.elementToBeClickable(operationTypeSelect)))
                .andThen(() -> operationTypeSelect.click())
                .andThen(() -> incomingOption.click())
                .get();
    }

    public void setOutgoingType() {
        Try.run(this::clickTransactionButton)
                .andThen(() -> wait.until(ExpectedConditions.elementToBeClickable(operationTypeSelect)))
                .andThen(() -> operationTypeSelect.click())
                .andThen(() -> outgoingOption.click())
                .get();
    }

    public void clickBalanceButton() {
        clickLinkOrButton(balanceButton, wait);
    }

    public void clickTransactionButton() {
        clickLinkOrButton(transactionsButton, wait);
    }

    public void clickSendButton() {
        Try.run(this::clickBalanceButton)
                .andThen(() -> clickLinkOrButton(sendButton, wait))
                .get();
    }

    public void clickGetButton() {
        Try.run(this::clickBalanceButton)
                .andThen(() -> clickLinkOrButton(getButton, wait))
                .get();
    }

    public void clickSearchButton() {
        Try.run(this::clickTransactionButton)
                .andThen(() -> clickLinkOrButton(searchButton, wait))
                .get();
    }
}