package is.toxic.page;

import lombok.Builder;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import static is.toxic.common.Common.clickLinkOrButton;
import static is.toxic.common.Common.setDataToInput;

public class ForgetPasswordPage {

    private final WebDriverWait wait;

    @Autowired
    private LoginRegistrationPage loginRegistrationPage;

    @Getter
    private final MainPage mainPage;

    @FindBy(css = ".input-group > input:nth-child(1)")
    private WebElement phoneEmailInput;

    @FindBy(css = ".input-group-append > button:nth-child(1)")
    private WebElement sendRecoveryCodeButton;

    @FindBy(css = "input.form-control:nth-child(2)")
    private WebElement recoveryCodeInput;

    @FindBy(css = "div.form-group:nth-child(3) > input:nth-child(1)")
    private WebElement passwordInput;

    @FindBy(css = "div.form-group:nth-child(4) > input:nth-child(1)")
    private WebElement confirmPasswordInput;

    @FindBy(css = ".justify-content-end > button:nth-child(1)")
    private WebElement changePasswordButton;

    @Builder
    public ForgetPasswordPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 120);
        mainPage =  MainPage.builder().driver(driver).build();
        loginRegistrationPage.clickForgetPassLink();
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getHomeLink()));
    }

    public void setPhoneEmail(String  phoneEmail){
        setDataToInput(phoneEmailInput, wait, phoneEmail);
    }

    public void setRecoveryCode(String recoveryCode){
        setDataToInput(recoveryCodeInput, wait, recoveryCode);
    }

    public void setPassword(String password){
        setDataToInput(passwordInput, wait, password);
    }

    public void setConfirmPassword(String password){
        setDataToInput(confirmPasswordInput, wait, password);
    }

    public void clickSendRecoveryCodeButton(){
        clickLinkOrButton(sendRecoveryCodeButton,wait);
    }

    public void clickChangePasswordButton(){
        clickLinkOrButton(changePasswordButton,wait);
    }
}
