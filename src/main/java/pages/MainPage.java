package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {
    public WebDriver driver;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@class='search-text-input']")
    private WebElement searchField;

    @FindBy(xpath = "//a[contains(text(),'Saturn')]")
    public WebElement saturnManufacturerButton;

    @FindBy(xpath = "//strong[contains(text(),'грн')]")
    private List<WebElement> saturnPrices;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement findButton;

    private void fillSearchField(String query) {
        System.out.println("Ввод товара: " + query);
        sendKeys(searchField, query);
    }

    private void clickFindButton() {
        clickOnElement(findButton);
    }

    public void startSearch(String query) {
        fillSearchField(query);
        clickFindButton();
    }


    public void chooseManufacturer(WebElement element) {
        clickOnElement(element);
    }


    public ArrayList<Integer> getNumbers() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (WebElement e : saturnPrices) {
            String s = e.getText().replaceAll("[^0-9]", "");
            int i = Integer.parseInt(s);
            numbers.add(i);
        }
        return (numbers);

    }

    public void showPrices() {
        for (Integer e: getNumbers()) {
            System.out.println(e);
        }
    }

    public void showPricesSum() {
        int sum = 0;
        for (int i : getNumbers()) {
            if (i > 7000) {
                sum += i;
            } else
                sum += 0;

        }
        System.out.println("Сумма товаров:" + sum + "грн");
    }

}









