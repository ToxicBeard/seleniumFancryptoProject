package is.toxic.page;

import lombok.Builder;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static is.toxic.common.Common.clickLinkOrButton;

@Getter
public class MainPage {

    private final WebDriverWait wait;

    @FindBy(css = "#root > nav > a")
    private WebElement homeLink;

    @FindBy(css = "#root > nav > div > ul > li:nth-child(1) > a")
    private WebElement buySaleLink;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/div/ul/li[3]/a")
    private WebElement loginRegistrationLink;

    @FindBy(css = "#root > nav > div > ul > li:nth-child(4) > a")
    private WebElement billsLink;

    @FindBy(css = "#root > nav > div > ul > li:nth-child(6) > a")
    private WebElement dashboardLink;

    //Post Login
    @FindBy(css = "#root > nav > div > ul > li:nth-child(3) > a")
    private WebElement profileLink;

    @FindBy(css = "#root > nav > div > ul > li:nth-child(2) > a")
    private WebElement purseLink;

    @FindBy(css = "#root > nav > div > ul > li:nth-child(6) > a")
    private WebElement exitLink;

    //Servive links
    @FindBy(css = "div.item:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")
    private WebElement webdesignLink;

    @FindBy(css = "div.item:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")
    private WebElement developmentLink;

    @FindBy(css = "div.item:nth-child(1) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(1)")
    private WebElement hostingLink;

    //About links
    @FindBy(css = "div.item:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")
    private WebElement companyLink;

    @FindBy(css = "div.item:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")
    private WebElement teamLink;

    @FindBy(css = "div.item:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(1)")
    private WebElement legacyLink;

    //Careers links
    @FindBy(css = "div.item:nth-child(3) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")
    private WebElement jobOpeningsLink;

    @FindBy(css = "div.item:nth-child(3) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")
    private WebElement employeeSuccessLink;

    @FindBy(css = "div.item:nth-child(3) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(1)")
    private WebElement benefitsLink;

    //Social links
    @FindBy(css = ".fa-facebook-f")
    private WebElement facebookLink;

    @FindBy(css = ".fa-twitter")
    private WebElement twitterLink;

    @FindBy(css = ".fa-instagram")
    private WebElement instagramLink;

    @Builder
    public MainPage(WebDriver driver) {
        driver.get("https://fancrypto.ru");
        wait = new WebDriverWait(driver, 120);
        PageFactory.initElements(driver, this);
    }

    public void clickHomeLink() {
        clickLinkOrButton(homeLink, wait);
    }

    public void clickBuySaleLink() {
        clickLinkOrButton(buySaleLink, wait);
    }

    /**
     * Можно вызвать только до авторизации
     */
    public void clickLoginRegistrationLink() {
        clickLinkOrButton(loginRegistrationLink, wait);
    }

    public void clickBillsLink() {
        clickLinkOrButton(billsLink, wait);
    }

    public void clickDashboardLink() {
        clickLinkOrButton(dashboardLink, wait);
    }

    public void clickWebdesignLink() {
        clickLinkOrButton(webdesignLink, wait);
    }

    public void clickDevelopmentLink() {
        clickLinkOrButton(developmentLink, wait);
    }

    public void clickHostingLink() {
        clickLinkOrButton(hostingLink, wait);
    }

    public void clickCompanyLink() {
        clickLinkOrButton(companyLink, wait);
    }

    public void clickTeamLink() {
        clickLinkOrButton(teamLink, wait);
    }

    public void clickLegacyLink() {
        clickLinkOrButton(legacyLink, wait);
    }

    public void clickJobOpeningsLink() {
        clickLinkOrButton(jobOpeningsLink, wait);
    }

    public void clickEmployeeSuccessLink() {
        clickLinkOrButton(employeeSuccessLink, wait);
    }

    public void clickBenefitsLink() {
        clickLinkOrButton(benefitsLink, wait);
    }

    public void clickFacebookLink() {
        clickLinkOrButton(facebookLink, wait);
    }

    public void clickTwitterLink() {
        clickLinkOrButton(twitterLink, wait);
    }

    public void clickInstagramLink() {
        clickLinkOrButton(instagramLink, wait);
    }

    /**
     * Можно вызвать только после авторизации
     */
    public void clickPurseLink() {
        clickLinkOrButton(purseLink, wait);
    }

    /**
     * Можно вызвать только после авторизации
     */
    public void clickProfileLink() {
        clickLinkOrButton(profileLink, wait);
    }

    /**
     * Можно вызвать только после авторизации
     */
    public void clickExitLink() {
        clickLinkOrButton(exitLink, wait);
    }
}
