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
import ru.toxic.common.Common;

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

    public void selectSaleRadioButton(){
        clickCheckbox(saleRadioButton, wait);
    }

    public void selectBuyRadioButton(){
        clickCheckbox(buyRadioButton, wait);
    }

    public void setCountry(String country) {
        run(() -> setDataToInput(geolocationInput, wait, country))
                .andThen(() -> geolocationInput.sendKeys(Keys.ARROW_DOWN))
                .andThen(() -> geolocationInput.sendKeys(Keys.ENTER))
                .get();
    }

    public void setCurrency(String currency){
        setValueFromSelectByValue(currencySelect, wait, currency);
    }

    public void setPaySystemForValue(String paySystem){
        setValueFromSelectByValue(paySystemSelect, wait, paySystem);
    }

    public void setPaySystemForText(String paySystem){
        setValueFromSelectByText(paySystemSelect, wait, paySystem);
    }

    public void setTimeForPayment(String time){
        setDataToInput(currencySelect, wait, time);
    }

    public void setProfit(String profit){
        setDataToInput(currencySelect, wait, profit);
    }

    public void clickMinusProfitButton(){
        profitMinusButton.click();
    }

    public void clickPlusProfitButton(){
        profitPlusButton.click();
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

    public void setSundayStartSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(sundayStartSelect, wait, timeIntervalNum);
    }

    public void setSundayStartSelect(String time){
        setValueFromSelectByText(sundayStartSelect, wait, time);
    }

    public void setSundayStopSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(sundayStopSelect, wait, timeIntervalNum);
    }

    public void setSundayStopSelect(String time){
        setValueFromSelectByText(sundayStopSelect, wait, time);
    }

    public void setMondayStartSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(mondayStartSelect, wait, timeIntervalNum);
    }

    public void setMondayStartSelect(String time){
        setValueFromSelectByText(mondayStartSelect, wait, time);
    }

    public void setMondayStopSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(mondayStopSelect, wait, timeIntervalNum);
    }

    public void setMondayStopSelect(String time){
        setValueFromSelectByText(mondayStopSelect, wait, time);
    }

    public void setTuesdayStartSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(tuesdayStartSelect, wait, timeIntervalNum);
    }

    public void setTuesdayStartSelect(String time){
        setValueFromSelectByText(tuesdayStartSelect, wait, time);
    }

    public void setTuesdayStopSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(tuesdayStopSelect, wait, timeIntervalNum);
    }

    public void setTuesdayStopSelect(String time){
        setValueFromSelectByText(tuesdayStopSelect, wait, time);
    }

    public void setWednesdayStartSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(wednesdayStartSelect, wait, timeIntervalNum);
    }

    public void setWednesdayStartSelect(String time){
        setValueFromSelectByText(wednesdayStartSelect, wait, time);
    }

    public void setWednesdayStopSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(wednesdayStopSelect, wait, timeIntervalNum);
    }

    public void setWednesdayStopSelect(String time){
        setValueFromSelectByText(wednesdayStopSelect, wait, time);
    }

    public void setThursdayStartSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(thursdayStartSelect, wait, timeIntervalNum);
    }

    public void setThursdayStartSelect(String time){
        setValueFromSelectByText(thursdayStartSelect, wait, time);
    }

    public void setThursdayStopSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(thursdayStopSelect, wait, timeIntervalNum);
    }

    public void setThursdayStopSelect(String time){
        setValueFromSelectByText(thursdayStopSelect, wait, time);
    }

    public void setFridayStartSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(fridayStartSelect, wait, timeIntervalNum);
    }

    public void setFridayStartSelect(String time){
        setValueFromSelectByText(fridayStartSelect, wait, time);
    }

    public void setFridayStopSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(fridayStopSelect, wait, timeIntervalNum);
    }

    public void setFridayStopSelect(String time){
        setValueFromSelectByText(fridayStopSelect, wait, time);
    }

    public void setSaturdayStartSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(saturdayStartSelect, wait, timeIntervalNum);
    }

    public void setSaturdayStartSelect(String time){
        setValueFromSelectByText(saturdayStartSelect, wait, time);
    }

    public void setSaturdayStopSelectForIntervalNum(String timeIntervalNum){
        setValueFromSelectByValue(saturdayStopSelect, wait, timeIntervalNum);
    }

    public void setSaturdayStopSelect(String time){
        setValueFromSelectByText(saturdayStopSelect, wait, time);
    }

    public void setDealInfo(String dealInfo){
        setDataToInput(dealInfoInput, wait, dealInfo);
    }

    public void selectLiquidSawCheckbox(){
        clickCheckbox(liquidSawCheckbox, wait);
    }

    public void selectNotForAnonymousCheckbox(){
        clickCheckbox(notForAnonymousCheckbox, wait);
    }

    public void selectPhoneVerifiedCheckbox(){
        clickCheckbox(phoneVerifiedCheckbox, wait);
    }

    public void selectOnlyTrustedUsersCheckbox(){
        clickCheckbox(onlyTrustedUsersCheckbox, wait);
    }

    public void selectClickReleaseDealButton(){
        releaseDealButton.click();
    }

}
