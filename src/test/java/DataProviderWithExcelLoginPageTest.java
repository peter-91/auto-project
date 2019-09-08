import base.BasePage;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class DataProviderWithExcelLoginPageTest extends BaseTest {
    private BasePage basePage;
    private LoginPage loginPage;

    @Test

    public void signInTest(String email, String password) {
        basePage = new BasePage();
        loginPage = new LoginPage(getDriver());
        basePage.openURL("https://twitter.com");
        loginPage.signIn(email, password);
        loginPage.logOut();
    }}
