package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    private By userNameField = By.xpath("//div[@class='StaticLoggedOutHomePage-login']//input[@class='text-input email-input js-signin-email']");

    private By passwordField = By.xpath("//div[@class='StaticLoggedOutHomePage-login']//input[@class='text-input']");

    private By logInInButton = By.xpath("//input[@class='EdgeButton EdgeButton--secondary EdgeButton--medium submit js-submit']");

    private By moreMenu = By.cssSelector("[data-testid='AppTabBar_More_Menu']");

    private By logOutButton = By.cssSelector("[data-testid='logout']");

    private By logOutDialogButton = By.cssSelector("[data-testid='confirmationSheetConfirm']");




    public void enterEmail(String string){
        sendKeys(userNameField, string);
    }

    public void enterPassword(String string) {
        sendKeys(passwordField, string);
    }

    public void clickLogInButton() {
        clickOnElement(logInInButton);
    }

    public void signIn(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogInButton();
    }

    public void logOut() {
        clickOnElement(moreMenu);
        clickOnElement(logOutButton);
        clickOnElement(logOutDialogButton);
    }



}

