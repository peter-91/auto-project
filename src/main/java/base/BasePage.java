package base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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

    public void showPrices(List<Integer> list) {
        for (Integer e : list) {
            System.out.println(e + " грн");
        }
    }

    public ArrayList<Integer> getPrices(List<WebElement> list) {
        ArrayList<Integer> prices = new ArrayList<Integer>();
        for (WebElement e : list) {
            String s = e.getText().replaceAll("[^0-9]", "");
            int i = Integer.parseInt(s);
            prices.add(i);
        }
        return (prices);
    }

    public void showPricesSum(List<Integer> list, int limit) {
        int sum = 0;
        for (int i : list) {
            if (i > limit) {
                sum += i;
            } else
                sum += 0;

        }
        if (sum == 0) {
            System.out.println("Товар отсутсвует");
        } else
            System.out.println("Сумма товаров:" + sum + " грн");

    }

    public void waitForVisibilityOfElement(By locator, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(visibilityOf(driver.findElement(locator)));
        } catch (NoSuchElementException e) {

            throw e;
        }
    }

    public void clickOnElement(By locator) {
        waitForVisibilityOfElement(locator, 10);
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String string) {
        waitForVisibilityOfElement(locator, 10);
        driver.findElement(locator).sendKeys(string);
    }

    public Boolean isElementPresent(By locator) {
        try {
            waitForVisibilityOfElement(locator, 10);
            driver.findElement(locator).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;

        }
    }
   // public void moveMouseTo(By locator) {
    //    waitForVisibilityOfElement(locator, 20);
      //  Actions action = new Actions(driver);
       // action.moveToElement(driver.findElement(locator)).build().perform();
    //}
}
