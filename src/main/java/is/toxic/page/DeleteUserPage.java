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
import static is.toxic.common.Common.setDataToInput;

public class DeleteUserPage {

    private final WebDriverWait wait;

    @Getter
    private final MainPage mainPage;

    @FindBy(xpath = "//input[@type= 'password']")
    private WebElement passwordInput;

    @FindBy(css = "#root > div.container > div.justify-content-center.row > div > div > div.card-footer > div > button")
    private WebElement deleteButton;

    @Builder
    public DeleteUserPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 120);
        mainPage = MainPage.builder().driver(driver).build();
        new ProfilePage(driver).clickDeleteAccountButton();
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
    }

    public void setPassword(String password) {
        setDataToInput(passwordInput, wait, password);
    }

    public void clickDeleteButton() {
        clickLinkOrButton(deleteButton, wait);
    }
}
