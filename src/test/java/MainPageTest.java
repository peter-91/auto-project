import base.BasePage;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageTest extends BaseTest {
    private MainPage mainPage;
    private BasePage basePage;
    String query = ("Холодильник");
    int limit = 7000;



    @Test
    public void showSaturnPricesTest() {
        mainPage = new MainPage(getDriver());
        basePage = new BasePage();
        basePage.openURL("https://pn.com.ua/");
        mainPage.startSearch(query);
        mainPage.chooseManufacturer(mainPage.saturnManufacturerButton);
        mainPage.showSaturnPrices();
    }
    @Test
    public void showSaturnSumPricesTest() {
        mainPage = new MainPage(getDriver());
        basePage = new BasePage();
        basePage.openURL("https://pn.com.ua/");
        mainPage.startSearch(query);
        mainPage.chooseManufacturer(mainPage.saturnManufacturerButton);
        mainPage.fridgeSum(limit);
    }

}
