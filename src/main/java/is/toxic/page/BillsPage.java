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
import static is.toxic.common.Common.disableCheckbox;
import static is.toxic.common.Common.enableCheckbox;
import static is.toxic.common.Common.selectValueFromSelectByText;
import static is.toxic.common.Common.selectValueFromSelectByValue;
import static is.toxic.common.Common.setDataToInput;
import is.toxic.model.Table;

public class BillsPage {

    private final WebDriverWait wait;

    @Getter
    private final MainPage mainPage;
    @FindBy(css = "#root > div.container > div.pb-3.row > div > div > div.input-group-prepend > button")
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

    //Post login

    @FindBy(css = "#root > div.container > div:nth-child(3) > div.col > ul > li:nth-child(1) > a")
    private WebElement sendBillButton;

    @FindBy(css = "#root > div.container > div:nth-child(3) > div.col > ul > li:nth-child(2) > a")
    private WebElement billsToMeButton;

    @FindBy(css = "#root > div.container > div:nth-child(3) > div.col > ul > li:nth-child(3) > a")
    private WebElement billsFromMeButton;

    @FindBy(css = "#root > div.container > div:nth-child(3) > div.col > ul > li:nth-child(4) > a")
    private WebElement publicBillsButton;

    @FindBy(css = "#root > div.container > div:nth-child(3) > div.col > ul > li:nth-child(5) > a")
    private WebElement paymentsToMeButton;

    @FindBy(css = "#root > div.container > div:nth-child(3) > div.col > ul > li:nth-child(6) > a")
    private WebElement paymentsFromMeButton;

    @FindBy(css = "#root > div.container > div:nth-child(3) > div.container > div > div > table")
    private WebElement table;
    //Send bill

    @FindBy(css = "div.pt-3:nth-child(1) > div:nth-child(2) > div:nth-child(1) > label:nth-child(1) > input:nth-child(1)")
    private WebElement privateBillRadioButton;

    @FindBy(css = "div.pt-3:nth-child(1) > div:nth-child(2) > div:nth-child(2) > label:nth-child(1) > input:nth-child(1)")
    private WebElement publicBillRadioButton;

    @FindBy(css = "div.pt-3:nth-child(2) > div:nth-child(2) > div:nth-child(1) > label:nth-child(1)")
    private WebElement cryptoCurrencyRadiobutton;

    @FindBy(css = "div.pt-3:nth-child(2) > div:nth-child(2) > div:nth-child(2) > label:nth-child(1)")
    private WebElement fiatCurrencyRadiobutton;

    //Only private
    @FindBy(css = "div.pt-3:nth-child(3) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement partnerNameInput;

    //Only private
    @FindBy(css = "div.pt-3:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > button:nth-child(1)")
    private WebElement checkPartnerNameButton;

    //Only private
    @FindBy(css = "div.pt-3:nth-child(4) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement sumInput;

    //Only public
    @FindBy(css = "div.pt-3:nth-child(3) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement partSumInput;

    // Only fiat
    @FindBy(css = "div.pt-3:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > select:nth-child(1)")
    private WebElement currencySelect;

    @FindBy(css = "div.pt-3:nth-child(5) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement lifetimeInput;

    @FindBy(css = "div.pt-3:nth-child(5) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > select:nth-child(1)")
    private WebElement lifetimeTimeUnitSelect;

    // Only fiat
    @FindBy(css = "div.pt-3:nth-child(6) > div:nth-child(2) > select:nth-child(1)")
    private WebElement courseSelect;

    @FindBy(css = ".textarea")
    private WebElement commentsInput;

    @FindBy(css = ".mr-3")
    private WebElement createBillButton;

    //Only public
    @FindBy(css = "div.pt-3:nth-child(4) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement minPartsInput;

    //Only public
    @FindBy(css = "div.pt-3:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > button:nth-child(1)")
    private WebElement minPartsMinusButton;

    //Only public
    @FindBy(css = "div.pt-3:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)")
    private WebElement minPartsPlusButton;

    //Only public
    @FindBy(css = "div.pt-3:nth-child(5) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement maxPartsInput;

    //Only public
    @FindBy(css = "div.pt-3:nth-child(5) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > button:nth-child(1) > svg:nth-child(1)")
    private WebElement maxPartsMinusButton;

    //Only public
    @FindBy(css = "div.pt-3:nth-child(5) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2) > svg:nth-child(1)")
    private WebElement maxPartsPlusButton;

    //Only public
    @FindBy(css = "div.pt-3:nth-child(8) > div:nth-child(2) > input:nth-child(1)")
    private WebElement limitLiquidCheckbox;

    @Builder
    public BillsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 120);
        mainPage = MainPage.builder().driver(driver).build();
        mainPage.clickBillsLink();
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

    public void clickSendBillButton() {
        clickLinkOrButton(sendBillButton, wait);
    }

    public void clickBillsToMeButton() {
        clickLinkOrButton(billsToMeButton, wait);
    }

    public void clickBillsFromMeButton() {
        clickLinkOrButton(billsFromMeButton, wait);
    }

    public void clickPublicBillsButton() {
        clickLinkOrButton(publicBillsButton, wait);
    }

    public void clickPaymentsToMeButton() {
        clickLinkOrButton(paymentsToMeButton, wait);
    }

    public void clickPaymentsFromMeButton() {
        clickLinkOrButton(paymentsFromMeButton, wait);
    }

    public void clickCheckPartnerNameButton() {
        clickLinkOrButton(checkPartnerNameButton, wait);
    }

    public void clickCreateBillButton() {
        clickLinkOrButton(createBillButton, wait);
    }

    public void clickMinPartsMinusButton() {
        clickLinkOrButton(minPartsMinusButton, wait);
    }

    public void clickMinPartsPlusButton() {
        clickLinkOrButton(minPartsPlusButton, wait);
    }

    public void clickMaxPartsMinusButton() {
        clickLinkOrButton(maxPartsMinusButton, wait);
    }

    public void clickMaxPartsPlusButton() {
        clickLinkOrButton(maxPartsPlusButton, wait);
    }

    public void enablePrivateBillRadioButton() {
        enableCheckbox(privateBillRadioButton, wait);
    }

    public void enablePublicBillRadioButton() {
        enableCheckbox(publicBillRadioButton, wait);
    }

    public void enableCryptoCurrencyRadiobutton() {
        enableCheckbox(cryptoCurrencyRadiobutton, wait);
    }

    public void enableFiatCurrencyRadiobutton() {
        enableCheckbox(fiatCurrencyRadiobutton, wait);
    }

    public void enableLimitLiquidCheckbox() {
        enableCheckbox(limitLiquidCheckbox, wait);
    }

    public void disableLimitLiquidCheckbox() {
        disableCheckbox(limitLiquidCheckbox, wait);
    }

    public void setCommentsInput(String data) {
        setDataToInput(commentsInput, wait, data);
    }

    public void setLifetimeInput(String data) {
        setDataToInput(lifetimeInput, wait, data);
    }

    public void setPartnerNameInput(String data) {
        setDataToInput(partnerNameInput, wait, data);
    }

    public void setSumInput(String data) {
        setDataToInput(sumInput, wait, data);
    }

    public void setPartSumInput(String data) {
        setDataToInput(partSumInput, wait, data);
    }

    public void setMaxPartsInput(String data) {
        setDataToInput(maxPartsInput, wait, data);
    }

    public void setMinPartsInput(String data) {
        setDataToInput(minPartsInput, wait, data);
    }

    public void selectCourseByText(String value) {
        selectValueFromSelectByText(courseSelect, wait, value);
    }

    public void selectCourseByValue(String value) {
        selectValueFromSelectByValue(courseSelect, wait, value);
    }

    public void selectLifetimeTimeUnitByText(String value) {
        selectValueFromSelectByText(lifetimeTimeUnitSelect, wait, value);
    }

    public void selectLifetimeTimeUnitByValue(String value) {
        selectValueFromSelectByValue(courseSelect, wait, value);
    }

    public void selectCurrency(String value) {
        selectValueFromSelectByValue(currencySelect, wait, value);
    }

    public Table getBillsToMeTable() {
        clickBillsToMeButton();
        wait.until(ExpectedConditions.elementToBeClickable(table));
        return Table.builder().table(table).build();
    }

    public Table getBillsFromMeTable() {
        clickBillsFromMeButton();
        wait.until(ExpectedConditions.elementToBeClickable(table));
        return Table.builder().table(table).build();
    }

    public Table getPublicBillsTable() {
        clickPublicBillsButton();
        wait.until(ExpectedConditions.elementToBeClickable(table));
        return Table.builder().table(table).build();
    }

    public Table getPaymentsToMeTable() {
        clickPaymentsToMeButton();
        wait.until(ExpectedConditions.elementToBeClickable(table));
        return Table.builder().table(table).build();
    }

    public Table getPaymentsFromMeTable() {
        clickPaymentsFromMeButton();
        wait.until(ExpectedConditions.elementToBeClickable(table));
        return Table.builder().table(table).build();
    }
}
