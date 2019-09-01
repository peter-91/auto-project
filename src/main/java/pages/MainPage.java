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


    private ArrayList<Integer> getSaturnPrices() {
        return getPrices(saturnPrices);
    }

    public void showSaturnPrices() {
        showPrices(getSaturnPrices());
    }

    public void showSaturnPricesSum(int limit) {
        showPricesSum(getSaturnPrices(), limit);
    }

}









