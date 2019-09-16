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


    private By userNameField = By.cssSelector("[data-testid=royal_email]");

    private By passwordField = By.cssSelector("[data-testid=royal_pass]");

    private By logInInButton = By.cssSelector("[data-testid=royal_login_button]");

   private By profileIcon = By.cssSelector("[data-click=profile_icon]");





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

    public Boolean isProfileIconPresented() {
        return isElementPresent(profileIcon);
    }
}

