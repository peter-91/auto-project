package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePage {
    private WebDriver driver;


    public BasePage() {
        driver = BaseTest.getDriver();

    }

    public void waitForVisibilityOfElement(WebElement element, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(visibilityOf(element));
        } catch (NoSuchElementException e) {

            throw e;
        }
    }

    public String getElementText(WebElement element) {
        waitForVisibilityOfElement(element, 10);
        return element.getText();
    }

    public void openURL(String URL) {
        driver.get(URL);
    }

    public void clickOnElement(WebElement element) {
        waitForVisibilityOfElement(element, 10);
        element.click();
    }

    public void sendKeys(WebElement element, String string) {
        waitForVisibilityOfElement(element, 10);
        element.sendKeys(string);
    }

}
