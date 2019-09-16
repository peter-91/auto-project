import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utility.ExcelUtils;

public class DataProviderWithExcelLoginPageTest extends BaseTest {
    private BasePage basePage;
    private LoginPage loginPage;

    @Test(dataProvider="Authentication")

    public void signInTest(String email, String password) {
        basePage = new BasePage();
        loginPage = new LoginPage(getDriver());
        basePage.openURL("https://www.facebook.com");
        loginPage.signIn(email, password);
        Assert.assertTrue(loginPage.isProfileIconPresented());
    }

    @DataProvider
    public Object[][] Authentication() throws Exception {

        Object[][] testObjArray = ExcelUtils.getTableArray(".//src//main//java//testData//TestData.xlsx", "Sheet1");

        return (testObjArray);
    }
}
