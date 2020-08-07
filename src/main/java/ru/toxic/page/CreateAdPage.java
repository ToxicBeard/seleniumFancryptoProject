package ru.toxic.page;

import lombok.Builder;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.vavr.control.Try.run;
import static ru.toxic.common.Common.*;

public class CreateAdPage {

    private final WebDriverWait wait;

    @Getter
    private final MainPage mainPage;

    @FindBy(css = "div.container:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    private WebElement adHeaderInput;

    @FindBy(css = "div.form-check:nth-child(1) > label:nth-child(1) > input:nth-child(1)")
    private WebElement saleRadioButton;

    @FindBy(css = "div.form-check:nth-child(2) > label:nth-child(1) > input:nth-child(1)")
    private WebElement buyRadioButton;

    @FindBy(css = ".border-danger")
    private WebElement geolocationInput;

    @FindBy(css = "div.container:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > select:nth-child(1)")
    private WebElement currencySelect;

    @FindBy(css = "div.container:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > select:nth-child(1)")
    private WebElement paySystemSelect;

    @FindBy(css = "div.container:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > input:nth-child(1)")
    private WebElement timeForPayment;

    @FindBy(css = "input.form-control:nth-child(2)")
    private WebElement profitInput;

    @FindBy(css = ".fa-minus")
    private WebElement profitMinusButton;

    @FindBy(css = "button.btn:nth-child(2)")
    private WebElement profitPlusButton;

    @FindBy(css = "div.container:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(2) > input:nth-child(1)")
    private WebElement profitEquationInput;

    @FindBy(css = "div.container:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement minTransactionInput;

    @FindBy(css = "div.pt-3:nth-child(7) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement maxTransactionInput;

    // Work time start
    @FindBy(css = "div.timeGroup:nth-child(2) > select:nth-child(2)")
    private WebElement sundayStartSelect;

    @FindBy(css = "div.timeGroup:nth-child(2) > select:nth-child(3)")
    private WebElement sundayStopSelect;

    @FindBy(css = "div.timeGroup:nth-child(4) > select:nth-child(2)")
    private WebElement mondayStartSelect;

    @FindBy(css = "div.timeGroup:nth-child(4) > select:nth-child(3)")
    private WebElement mondayStopSelect;

    @FindBy(css = "div.timeGroup:nth-child(6) > select:nth-child(2)")
    private WebElement tuesdayStartSelect;

    @FindBy(css = "div.timeGroup:nth-child(6) > select:nth-child(3)")
    private WebElement tuesdayStopSelect;

    @FindBy(css = "div.timeGroup:nth-child(8) > select:nth-child(2)")
    private WebElement wednesdayStartSelect;

    @FindBy(css = "div.timeGroup:nth-child(8) > select:nth-child(3)")
    private WebElement wednesdayStopSelect;

    @FindBy(css = "div.timeGroup:nth-child(10) > select:nth-child(2)")
    private WebElement thursdayStartSelect;

    @FindBy(css = "div.timeGroup:nth-child(10) > select:nth-child(3)")
    private WebElement thursdayStopSelect;

    @FindBy(css = "div.timeGroup:nth-child(12) > select:nth-child(2)")
    private WebElement fridayStartSelect;

    @FindBy(css = "div.timeGroup:nth-child(12) > select:nth-child(3)")
    private WebElement fridayStopSelect;

    @FindBy(css = "div.timeGroup:nth-child(14) > select:nth-child(2)")
    private WebElement saturdayStartSelect;

    @FindBy(css = "div.timeGroup:nth-child(14) > select:nth-child(3)")
    private WebElement saturdayStopSelect;

    //Work time ends

    @FindBy(css = ".textarea")
    private WebElement dealInfoInput;

    @FindBy(css = "div.container:nth-child(2) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    private WebElement liquidSawCheckbox;

    @FindBy(css = "div.container:nth-child(2) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    private WebElement notForAnonymousCheckbox;

    @FindBy(css = "div.container:nth-child(2) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > input:nth-child(1)")
    private WebElement phoneVerifiedCheckbox;

    @FindBy(css = "div.container:nth-child(2) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > input:nth-child(1)")
    private WebElement onlyTrustedUsersCheckbox;

    @FindBy(css = ".mr-3")
    private WebElement releaseDealButton;

    @Builder
    public CreateAdPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 120);
        mainPage =  MainPage.builder().driver(driver).build();
        DashboardPage.builder().driver(driver).build().clickCreateAdButton();
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getHomeLink()));
        PageFactory.initElements(driver, this);
    }

    public void setDealHead(String dealHead){
        setDataToInput(adHeaderInput, wait, dealHead);
    }

    public void setCountry(String country) {
        run(() -> setDataToInput(geolocationInput, wait, country))
                .andThen(() -> geolocationInput.sendKeys(Keys.ARROW_DOWN))
                .andThen(() -> geolocationInput.sendKeys(Keys.ENTER))
                .get();
    }

    public void setTimeForPayment(String time){
        setDataToInput(timeForPayment, wait, time);
    }

    public void setProfit(String profit){
        setDataToInput(profitInput, wait, profit);
    }

    public void setProfitEquation(String profitEquation){
        setDataToInput(profitEquationInput, wait, profitEquation);
    }

    public void setMinTransactionInput(String value){
        setDataToInput(minTransactionInput, wait, value);
    }

    public void setMaxTransactionInput(String value){
        setDataToInput(maxTransactionInput, wait, value);
    }

    public void setDealInfo(String dealInfo){
        setDataToInput(dealInfoInput, wait, dealInfo);
    }

    public void selectCurrency(String currency){
        selectValueFromSelectByValue(currencySelect, wait, currency);
    }

    public void selectPaySystemForValue(String paySystem){
        selectValueFromSelectByValue(paySystemSelect, wait, paySystem);
    }

    public void selectPaySystemForText(String paySystem){
        selectValueFromSelectByText(paySystemSelect, wait, paySystem);
    }

    public void selectSundayStartForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(sundayStartSelect, wait, timeIntervalNum);
    }

    public void selectSundayStart(String time){
        selectValueFromSelectByText(sundayStartSelect, wait, time);
    }

    public void selectSundayStopForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(sundayStopSelect, wait, timeIntervalNum);
    }

    public void selectSundayStop(String time){
        selectValueFromSelectByText(sundayStopSelect, wait, time);
    }

    public void selectMondayStartForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(mondayStartSelect, wait, timeIntervalNum);
    }

    public void selectMondayStart(String time){
        selectValueFromSelectByText(mondayStartSelect, wait, time);
    }

    public void selectMondayStopForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(mondayStopSelect, wait, timeIntervalNum);
    }

    public void selectMondayStop(String time){
        selectValueFromSelectByText(mondayStopSelect, wait, time);
    }

    public void selectTuesdayStartForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(tuesdayStartSelect, wait, timeIntervalNum);
    }

    public void selectTuesdayStart(String time){
        selectValueFromSelectByText(tuesdayStartSelect, wait, time);
    }

    public void selectTuesdayStopForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(tuesdayStopSelect, wait, timeIntervalNum);
    }

    public void selectTuesdayStop(String time){
        selectValueFromSelectByText(tuesdayStopSelect, wait, time);
    }

    public void selectWednesdayStartForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(wednesdayStartSelect, wait, timeIntervalNum);
    }

    public void selectWednesdayStart(String time){
        selectValueFromSelectByText(wednesdayStartSelect, wait, time);
    }

    public void selectWednesdayStopForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(wednesdayStopSelect, wait, timeIntervalNum);
    }

    public void selectWednesdayStop(String time){
        selectValueFromSelectByText(wednesdayStopSelect, wait, time);
    }

    public void selectThursdayStartForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(thursdayStartSelect, wait, timeIntervalNum);
    }

    public void selectThursdayStart(String time){
        selectValueFromSelectByText(thursdayStartSelect, wait, time);
    }

    public void selectThursdayStopForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(thursdayStopSelect, wait, timeIntervalNum);
    }

    public void selectThursdayStop(String time){
        selectValueFromSelectByText(thursdayStopSelect, wait, time);
    }

    public void selectFridayStartForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(fridayStartSelect, wait, timeIntervalNum);
    }

    public void selectFridayStart(String time){
        selectValueFromSelectByText(fridayStartSelect, wait, time);
    }

    public void selectFridayStopForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(fridayStopSelect, wait, timeIntervalNum);
    }

    public void selectFridayStop(String time){
        selectValueFromSelectByText(fridayStopSelect, wait, time);
    }

    public void selectSaturdayStartForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(saturdayStartSelect, wait, timeIntervalNum);
    }

    public void selectSaturdayStart(String time){
        selectValueFromSelectByText(saturdayStartSelect, wait, time);
    }

    public void selectSaturdayStopForIntervalNum(String timeIntervalNum){
        selectValueFromSelectByValue(saturdayStopSelect, wait, timeIntervalNum);
    }

    public void selectSaturdayStop(String time){
        selectValueFromSelectByText(saturdayStopSelect, wait, time);
    }

    public void clickMinusProfitButton(){
        profitMinusButton.click();
    }

    public void clickPlusProfitButton(){
        profitPlusButton.click();
    }

    public void clickReleaseDealButton(){
        releaseDealButton.click();
    }

    public void enableSaleRadioButton(){
        enableCheckbox(saleRadioButton, wait);
    }

    public void enableBuyRadioButton(){
        enableCheckbox(buyRadioButton, wait);
    }

    public void enableLiquidSawCheckbox(){
        enableCheckbox(liquidSawCheckbox, wait);
    }

    public void enableNotForAnonymousCheckbox(){
        enableCheckbox(notForAnonymousCheckbox, wait);
    }

    public void enablePhoneVerifiedCheckbox(){
        enableCheckbox(phoneVerifiedCheckbox, wait);
    }

    public void enableOnlyTrustedUsersCheckbox(){
        enableCheckbox(onlyTrustedUsersCheckbox, wait);
    }

    public void disableLiquidSawCheckbox(){
        disableCheckbox(liquidSawCheckbox, wait);
    }

    public void disableNotForAnonymousCheckbox(){
        disableCheckbox(notForAnonymousCheckbox, wait);
    }

    public void disablePhoneVerifiedCheckbox(){
        disableCheckbox(phoneVerifiedCheckbox, wait);
    }

    public void disableOnlyTrustedUsersCheckbox(){
        disableCheckbox(onlyTrustedUsersCheckbox, wait);
    }

}
