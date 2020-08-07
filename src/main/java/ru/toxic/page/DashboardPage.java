package ru.toxic.page;

import lombok.Builder;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.toxic.model.Table;

import static ru.toxic.common.Common.disableCheckbox;
import static ru.toxic.common.Common.enableCheckbox;

public class DashboardPage {

    private final WebDriverWait wait;

    @Getter
    private final MainPage mainPage;

    @FindBy(css = ".nav > li:nth-child(1) > a:nth-child(1)")
    private WebElement adsButton;

    @FindBy(css = ".table")
    private WebElement adsTable;

    @FindBy(css = ".nav > li:nth-child(2) > a:nth-child(1)")
    private WebElement openDealsButton;

    @FindBy(css = ".nav > li:nth-child(3) > a:nth-child(1)")
    private WebElement endsDealsButton;

    @FindBy(css = ".nav > li:nth-child(4) > a:nth-child(1)")
    private WebElement canceledDealsButton;

    @FindBy(css = ".nav > li:nth-child(5) > a:nth-child(1)")
    private WebElement disputsButton;

    @FindBy(css = ".mx-auto")
    private WebElement moreDealsButton;

    @FindBy(css = "a.btn")
    private WebElement createAdButton;

    @FindBy(css = "div.pt-3:nth-child(2) > input:nth-child(1)")
    private WebElement stopSalesCheckbox;

    @FindBy(css = "div.pt-3:nth-child(1) > input:nth-child(1)")
    private WebElement stopBuysCheckbox;

    @Builder
    public DashboardPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 120);
        mainPage =  MainPage.builder().driver(driver).build();
        mainPage.clickDashboardLink();
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getHomeLink()));
        PageFactory.initElements(driver, this);
    }

    public void clickAdsButton(){
        adsButton.click();
    }

    public void clickOpenDealsButton(){
        openDealsButton.click();
    }

    public void clickEndsDealsButton(){
        endsDealsButton.click();
    }

    public void clickCanceledDealsButton(){
        canceledDealsButton.click();
    }

    public void clickDisputsButton(){
        disputsButton.click();
    }

    public void clickMoreDealsButton(){
        moreDealsButton.click();
    }
    
    public void clickCreateAdButton(){
        createAdButton.click();
    }

    public void enableStopSalesCheckbox(){
        enableCheckbox(stopSalesCheckbox, wait);
    }

    public void enableStopBuysCheckbox(){
        enableCheckbox(stopBuysCheckbox, wait);
    }

    public void disableStopSalesCheckbox(){
        disableCheckbox(stopSalesCheckbox, wait);
    }

    public void disableStopBuysCheckbox(){
        disableCheckbox(stopBuysCheckbox, wait);
    }

    public Table getAdsTable() {
        return Table.builder().table(adsTable).build();
    }

    public void clickOnButtonForDeal(int dealNum){
        getAdsTable().getRowsWithColumns().get(dealNum).get(1).click();
    }

    public void clickEditButtonForDeal(int dealNum){
        getAdsTable().getRowsWithColumns().get(dealNum).get(7).click();
    }

    public void clickDeleteButtonForDeal(int dealNum){
        getAdsTable().getRowsWithColumns().get(dealNum).get(8).click();
    }
}
