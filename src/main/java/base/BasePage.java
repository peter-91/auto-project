package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        for (Integer e: list) {
            System.out.println(e);
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
        System.out.println("Сумма товаров:" + sum + " грн");
    }

}
