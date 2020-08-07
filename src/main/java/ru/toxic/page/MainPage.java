package ru.toxic.page;

import lombok.Builder;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class MainPage {

    @FindBy(css = ".mr-auto")
    private WebElement homeLink;

    @FindBy(css = ".ml-auto > li:nth-child(1) > a:nth-child(1)")
    private WebElement buySaleLink;

    @FindBy(css = ".ml-auto > li:nth-child(2) > a:nth-child(1)")
    private WebElement loginRegistrationLink;

    @FindBy(css = "li.nav-item:nth-child(3) > a:nth-child(1)")
    private WebElement billsLink;

    @FindBy(css = ".ml-auto > li:nth-child(4) > a:nth-child(1)")
    private WebElement dashboardLink;

    //Post Login
    @FindBy(css = "li.nav-item:nth-child(3) > a:nth-child(1)")
    private WebElement profileLink;

    @FindBy(css = ".ml-auto > li:nth-child(2) > a:nth-child(1)")
    private WebElement purseLink;

    @FindBy(css = "li.nav-item:nth-child(6) > a:nth-child(1)")
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
        PageFactory.initElements(driver, this);
    }

    public void clickHomeLink(){
        homeLink.click();
    }

    public void clickBuySaleLink(){
        buySaleLink.click();
    }

    /**
     *  Можно вызвать только до авторизации
     */
    public void clickLoginRegistrationLink(){
        loginRegistrationLink.click();
    }

    public void clickBillsLink(){
        billsLink.click();
    }

    public void clickDashboardLink(){
        dashboardLink.click();
    }

    public void clickWebdesignLink(){
        webdesignLink.click();
    }

    public void clickDevelopmentLink(){
        developmentLink.click();
    }

    public void clickHostingLink(){
        hostingLink.click();
    }

    public void clickCompanyLink(){
        companyLink.click();
    }

    public void clickTeamLink(){
        teamLink.click();
    }

    public void clickLegacyLink(){
        legacyLink.click();
    }

    public void clickJobOpeningsLink(){
        jobOpeningsLink.click();
    }

    public void clickEmployeeSuccessLink(){
        employeeSuccessLink.click();
    }

    public void clickBenefitsLink(){
        benefitsLink.click();
    }

    public void clickFacebookLink(){
        facebookLink.click();
    }

    public void clickTwitterLink(){
        twitterLink.click();
    }

    public void clickInstagramLink(){
        instagramLink.click();
    }

    /**
     *  Можно вызвать только после авторизации
     */
    public void clickPurseLink(){
        purseLink.click();
    }

    /**
     *  Можно вызвать только после авторизации
     */
    public void clickProfileLink(){
        profileLink.click();
    }

    /**
     *  Можно вызвать только после авторизации
     */
    public void clickExitLink(){
        exitLink.click();
    }
}
