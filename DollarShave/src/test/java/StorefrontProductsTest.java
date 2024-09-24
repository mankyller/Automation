import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StorefrontProductsTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverSetup() {
        driver = new ChromeDriver();
        driver.navigate().to("https://us.dollarshaveclub.com/");
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void clickShaveHeaderLinkForStorefront() {
        WebElement shaveHeaderLink = driver.findElement(By.cssSelector("#shave-label"));
        WebElement sixBladeRazorTile = driver.findElement(By.cssSelector("responsive-image__image.card__product-image.background-image"));

    }

    public void waitTimer(int timeToWait) {
        try {
            Thread.sleep(timeToWait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public static void removeDriver() {
        driver.close();
        driver.quit();
    }

}
