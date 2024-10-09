import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTests;

import java.time.Duration;
import static org.junit.Assert.assertEquals;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SubscriptionPurchaseCheckoutTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverSetup() {
        BaseTests.applicationLaunch();
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void aaaNavigateToSignInTest() {
        WebElement homePageSignInButton = driver.findElement(By.cssSelector("span[class=sr-only] + span[class=menu__title]"));
        homePageSignInButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10));
        assertEquals("https://us.dollarshaveclub.com/account/login", driver.getCurrentUrl());
    }

    @Test
    public void bbbSignIntoAccountTest() {
        WebElement emailInput = driver.findElement(By.id("CustomerEmail"));
        WebElement passwordInput = driver.findElement(By.id("CustomerPassword"));
        WebElement loginSignInButton = driver.findElement(By.cssSelector("button[type=submit]"));

        String email = System.getenv("DSC_EMAIL");
        emailInput.sendKeys(email);
        new WebDriverWait(driver, Duration.ofSeconds(2));

        String password = System.getenv("DSC_PASS");
        passwordInput.sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(5));

        loginSignInButton.click();
        BaseTests.waitTimer(10000);

        WebElement testAccountName = driver.findElement(By.cssSelector("h1.page-header__title.heading--h1"));
        assertEquals("Test account name is Lee Test", "Lee Test", testAccountName.getText());
    }

    @Test
    public void cccAddItemToCart() {
        WebElement headerShaveLink = driver.findElement(By.cssSelector("#shave-label"));
        headerShaveLink.click();
        new WebDriverWait(driver, Duration.ofSeconds(10));
        assertEquals("User is on Shave Storefront page",
                "https://us.dollarshaveclub.com/collections/shave", driver.getCurrentUrl());

        WebElement storefrontSixBladeTile = driver.findElement(By.cssSelector("div[class=card__image-wrapper]"));
        storefrontSixBladeTile.click();
        new WebDriverWait(driver, Duration.ofSeconds(10));
        assertEquals("User is on the 6 blade Product Detail Page",
                "https://us.dollarshaveclub.com/collections/shave/products/club-series-6-blade",
                driver.getCurrentUrl());

        WebElement subscriptionAddToCartButton = driver.findElement(By.id("og-subscription-button"));
        subscriptionAddToCartButton.click();
        BaseTests.waitTimer(7000);

        WebElement pdpAddToCartButton = driver.findElement(By.id("add-to-cart-button"));
        pdpAddToCartButton.click();
        BaseTests.waitTimer(5000);
    }

    @Test
    public void dddNavigateToCheckoutPageAndCheckValues() {
        WebElement cartCheckoutButton = driver.findElement(By.cssSelector(".rebuy-button.rebuy-cart__checkout-button.block"));
        cartCheckoutButton.click();
        BaseTests.waitTimer(10000);

        Assert.assertTrue("User is on the Checkout page", driver.getCurrentUrl().contains("checkouts"));
        BaseTests.waitTimer(10000);

        WebElement totalPrice = driver.findElement(By.cssSelector("_19gi7yt0._19gi7yt10._19gi7ytz._1fragemrs._19gi7yt2.notranslate"));
        assertEquals("Price shows $10", "$10.00", totalPrice.getText());

    }

    @AfterClass
    public static void removeDriver() {
        BaseTests.shutdownDriver();
    }

}
