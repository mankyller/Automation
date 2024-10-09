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

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StarterSetBuyTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverSetup() {
        BaseTests.applicationLaunch();
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void aaaClickStarterSetCTA() {
        WebElement starterSetButton = driver.findElement(By.cssSelector("a.button.hero-banner__button "));
        starterSetButton.click();
        BaseTests.waitTimer(5000);

        assertTrue(driver.getCurrentUrl().contains("starter-set"));
    }

    @Test
    public void bbbClickJoinTheClubButton() {
        WebElement joinTheClubButton = driver.findElement(By.cssSelector
                ("a.button.hero-banner__button.button--large.has-sticky-cta-button.cart-api-add-btn.one-month.redirect-to-checkout-true"));
        joinTheClubButton.click();
        BaseTests.waitTimer(7000);

        assertTrue(driver.getCurrentUrl().contains("checkout"));
    }

    @AfterClass
    public static void removeDriver() {
        BaseTests.shutdownDriver();
    }

}
