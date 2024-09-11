import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertEquals;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckoutTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverSetup() {
        driver = new ChromeDriver();
        driver.navigate().to("https://us.dollarshaveclub.com/");
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
        waitTimer(10000);

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

        WebElement pdpAddToCartButton = driver.findElement(By.id("add-to-cart-button"));
        pdpAddToCartButton.click();
        waitTimer(5000);

        //Used to click a "No Thanks" button on a popup that asked if the user wanted to
        //switch their one-time purchase to a subscription purchase
//        WebElement noThanksPopUpButton = driver.findElement(By.cssSelector(".rebuy-button.decline"));
//        noThanksPopUpButton.click();
//        waitTimer(5000);
    }

    @Test
    public void dddNavigateToCheckoutPageAndCheckValues() {
        WebElement cartCheckoutButton = driver.findElement(By.cssSelector(".rebuy-button.rebuy-cart__checkout-button.block"));
        cartCheckoutButton.click();
        waitTimer(10000);

        Assert.assertTrue("User is on the Checkout page", driver.getCurrentUrl().contains("checkouts"));
        waitTimer(10000);

        WebElement totalPrice = driver.findElement(By.cssSelector("._19gi7yt0._19gi7yt12._1fragemrt._19gi7yt2.notranslate"));
        assertEquals("Price shows $10", "$10.00", totalPrice.getText());

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
