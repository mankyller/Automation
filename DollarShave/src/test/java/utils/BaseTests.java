package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

    private static WebDriver driver;

    private static void setChromeDriverProperty() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
    }

    @BeforeClass
    public static void createDriverSetup() {
        setChromeDriverProperty();
        driver = new ChromeDriver();
        driver.navigate().to("https://us.dollarshaveclub.com/");
    }

    @AfterClass
    public static void removeDriver() {
        driver.close();
        driver.quit();
    }

}
