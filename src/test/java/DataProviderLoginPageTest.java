import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class DataProviderLoginPageTest extends BaseTest {
    private BasePage basePage;
    private LoginPage loginPage;



    @Test (dataProvider = "authentication", dataProviderClass = DataProviderClass.class)

    public void signInTest(String email, String password) {
        basePage = new BasePage();
        loginPage = new LoginPage(getDriver());
        basePage.openURL("https://www.facebook.com");
        loginPage.signIn(email, password);
        Assert.assertTrue(loginPage.isProfileIconPresented());
    }

}
