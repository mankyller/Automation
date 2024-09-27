package utils;

import pages.Page;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

    private static WebDriver driver;
    protected static Page homePage;

    private static void setChromeDriverProperty() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
    }

    @BeforeClass
    public static void applicationLaunch() {
        setChromeDriverProperty();
        driver = new ChromeDriver();
        driver.navigate().to(Links.HOME);
        homePage = new Page();
    }

    @AfterClass
    public static void shutdownDriver() {
        driver.close();
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
