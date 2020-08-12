package is.toxic.page;

import lombok.Builder;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static is.toxic.common.Common.clickLinkOrButton;
import static is.toxic.common.Common.disableHideCheckbox;
import static is.toxic.common.Common.enableHideCheckbox;
import static is.toxic.common.Common.selectValueFromSelectByValue;
import static is.toxic.common.Common.setDataToInput;

public class ProfilePage {

    private final WebDriverWait wait;

    @Getter
    private final MainPage mainPage;

    @FindBy(css = "button.float-right:nth-child(9)")
    private WebElement saveChangesButton;

    @FindBy(css = "#id_timezone")
    private WebElement timezoneSelect;

    @FindBy(css = "#id_introduction")
    private WebElement introductionInput;

    @FindBy(css = "input.form-control")
    private WebElement userSiteInput;

    @FindBy(css = ".py-3 > div:nth-child(1) > div:nth-child(2) > button:nth-child(1)")
    private WebElement changePasswordButton;

    @FindBy(css = ".py-3 > div:nth-child(2) > div:nth-child(2) > button:nth-child(1)")
    private WebElement changeEmailButton;

    @FindBy(css = ".py-3 > div:nth-child(3) > div:nth-child(2) > button:nth-child(1)")
    private WebElement changePhoneButton;

    @FindBy(css = ".btn-outline-success")
    private WebElement enableTwoFactorAuthenticationButton;

    @FindBy(css = "div.row:nth-child(5) > div:nth-child(2) > button:nth-child(1)")
    private WebElement changeTelegramNotificationButton;

    @FindBy(css = "div.row:nth-child(6) > div:nth-child(2) > button:nth-child(1)")
    private WebElement changeThirdPartyAppsButton;

    @FindBy(css = "div.row:nth-child(7) > div:nth-child(2) > button:nth-child(1)")
    private WebElement viewSessionsButton;

    @FindBy(css = ".btn-outline-danger")
    private WebElement deleteAccountButton;

    @FindBy(css = ".fa-plus")
    private WebElement preferencesButton;

    //Hide need click preferencesButton before use

    @FindBy(css = "#salesCheck")
    private WebElement stopSalesCheckbox;

    @FindBy(css = "#buysCheck")
    private WebElement stopBuysCheckbox;

    @FindBy(css = "#contactsCheck")
    private WebElement sendContactsNotificationsCheckbox;

    @FindBy(css = "div.card-body:nth-child(1) > div:nth-child(4) > label:nth-child(1) > input:nth-child(1)")
    private WebElement sendPayNotificationsCheckbox;

    @FindBy(css = "div.form-group:nth-child(5) > label:nth-child(1) > input:nth-child(1)")
    private WebElement sendBitcoinsNotificationsCheckbox;

    @FindBy(css = "div.form-group:nth-child(6) > label:nth-child(1) > input:nth-child(1)")
    private WebElement provideAsVerifiedCheckbox;

    @FindBy(css = "div.form-group:nth-child(7) > label:nth-child(1) > input:nth-child(1)")
    private WebElement offConfidentiallDataToEmailCheckbox;

    @FindBy(css = "div.form-group:nth-child(8) > label:nth-child(1) > input:nth-child(1)")
    private WebElement enableWebNotificationsCheckbox;

    @Builder
    public ProfilePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 120);
        mainPage =  MainPage.builder().driver(driver).build();
        mainPage.clickProfileLink();
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getHomeLink()));
    }

    public void setIntroduction(String introduction){
        setDataToInput(introductionInput, wait, introduction);
    }

    public void setUserSite(String site){
        setDataToInput(userSiteInput, wait, site);
    }

    public void setTimezone(String timezone){
        selectValueFromSelectByValue(timezoneSelect, wait, timezone);
    }

    public void clickChangePasswordButton(){
        clickLinkOrButton(changePasswordButton, wait);
    }

    public void clickChangeEmailButton(){
        clickLinkOrButton( changeEmailButton, wait);
    }

    public void clickChangePhoneButton(){
        clickLinkOrButton( changePhoneButton, wait);
    }

    public void clickEnableTwoFactorAuthenticationButton(){
        clickLinkOrButton(  enableTwoFactorAuthenticationButton, wait);
    }

    public void clickChangeTelegramNotificationButton(){
        clickLinkOrButton( changeTelegramNotificationButton, wait);
    }

    public void clickChangeThirdPartyAppsButton(){
        clickLinkOrButton( changeThirdPartyAppsButton, wait);
    }

    public void clickViewSessionsButton(){
        clickLinkOrButton(viewSessionsButton, wait);
    }

    public void clickDeleteAccountButton(){
        clickLinkOrButton(deleteAccountButton, wait);
    }

    public void clickPreferencesButton(){
        clickLinkOrButton(preferencesButton, wait);
    }

    public void enableStopSalesCheckbox(){
        enableHideCheckbox(preferencesButton, stopSalesCheckbox, wait);
    }

    public void enableStopBuysCheckbox(){
        enableHideCheckbox(preferencesButton, stopBuysCheckbox, wait);
    }

    public void enableSendContactsNotificationsCheckbox(){
        enableHideCheckbox(preferencesButton, sendContactsNotificationsCheckbox, wait);
    }

    public void enableSendPayNotificationsCheckbox(){
        enableHideCheckbox(preferencesButton, sendPayNotificationsCheckbox, wait);
    }

    public void enableSendBitcoinsNotificationsCheckbox(){
        enableHideCheckbox(preferencesButton, sendBitcoinsNotificationsCheckbox, wait);
    }

    public void enableProvideAsVerifiedCheckbox(){
        enableHideCheckbox(preferencesButton, provideAsVerifiedCheckbox, wait);
    }

    public void enableOffConfidentiallDataToEmailCheckbox(){
        enableHideCheckbox(preferencesButton, offConfidentiallDataToEmailCheckbox, wait);
    }

    public void enableEnableWebNotificationsCheckbox(){
        enableHideCheckbox(preferencesButton, enableWebNotificationsCheckbox, wait);
    }

    public void disableStopSalesCheckbox(){
        disableHideCheckbox(preferencesButton, stopSalesCheckbox, wait);
    }

    public void disableStopBuysCheckbox(){
        disableHideCheckbox(preferencesButton, stopBuysCheckbox, wait);
    }

    public void disableSendContactsNotificationsCheckbox(){
        disableHideCheckbox(preferencesButton, sendContactsNotificationsCheckbox, wait);
    }

    public void disableSendPayNotificationsCheckbox(){
        disableHideCheckbox(preferencesButton, sendPayNotificationsCheckbox, wait);
    }

    public void disableSendBitcoinsNotificationsCheckbox(){
        disableHideCheckbox(preferencesButton, sendBitcoinsNotificationsCheckbox, wait);
    }

    public void disableProvideAsVerifiedCheckbox(){
        disableHideCheckbox(preferencesButton, provideAsVerifiedCheckbox, wait);
    }

    public void disableOffConfidentiallDataToEmailCheckbox(){
        disableHideCheckbox(preferencesButton, offConfidentiallDataToEmailCheckbox, wait);
    }

    public void disableEnableWebNotificationsCheckbox(){
        disableHideCheckbox(preferencesButton, enableWebNotificationsCheckbox, wait);
    }
}
