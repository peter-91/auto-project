package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
        private static WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal();



        @BeforeTest
        public void setUp() {
            options.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().setSize(new Dimension(1280, 1024));

            DRIVER.set(driver);
        }


        @AfterTest
        public void tearDown(){
            driver.quit();
        }




        public static WebDriver getDriver() {
            return DRIVER.get();
        }
}

