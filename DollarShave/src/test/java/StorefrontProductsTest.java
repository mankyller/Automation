import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTests;

import java.time.Duration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StorefrontProductsTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverSetup() {
        BaseTests.applicationLaunch();
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void clickShaveHeaderLinkForStorefront() {
        WebElement shaveHeaderLink = driver.findElement(By.cssSelector("#shave-label"));
        WebElement sixBladeRazorTile = driver.findElement(By.cssSelector("responsive-image__image.card__product-image.background-image"));

    }

    @AfterClass
    public static void removeDriver() {
        BaseTests.shutdownDriver();
    }

}
