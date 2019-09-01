import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageTest extends BaseTest {
    private MainPage mainPage;
    private BasePage basePage;
    String query = ("Холодильник");


    @Test
    public void searchTest() {
        mainPage = new MainPage(getDriver());
        basePage = new BasePage();
        basePage.openURL("https://pn.com.ua/");
        mainPage.startSearch(query);
        mainPage.chooseManufacturer(mainPage.saturnManufacturerButton);
        mainPage.showPricesSum();
    }
}
