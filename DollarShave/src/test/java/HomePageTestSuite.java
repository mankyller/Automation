import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageTestSuite {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverSetup() {
        driver = new ChromeDriver();
        driver.navigate().to("https://us.dollarshaveclub.com/");
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void signInButtonLoadCheck() {
        WebElement signInButton = driver.findElement(By.cssSelector("span.menu__title"));
        Assert.assertEquals("Sign in button has loaded", "Sign In", signInButton.getText());
    }

    @Test
    public void starterSetButtonLoadCheck() {
       WebElement heroBannerButton = driver.findElement
                (By.cssSelector(".button.hero-banner__button ")); //First Starter Set CTA
        Assert.assertEquals("Hero banner call to action has loaded",
                "GET MY STARTER SET", heroBannerButton.getText());
    }

    @Test
    public void viewAllButtonOneLoadCheck() {
        WebElement viewAllButtonOne = driver.findElement
                (By.cssSelector("a.button.button--primary.button--feature-collection")); //View All Bundles Button
        Assert.assertEquals("First View All has loaded", "View All", viewAllButtonOne.getText());

    }



    @AfterClass
    public static void removeDriver() {
        driver.close();
        driver.quit();
    }
}
