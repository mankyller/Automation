package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseTests;
import widgets.SearchResults;

public class Page {

    protected WebDriver driver = BaseTests.getDriver();

    By homePageSignInButton = By.cssSelector("span[class=sr-only] + span[class=menu__title]");
    By emailInput = By.id("CustomerEmail");
    By passwordInput = By.id("CustomerPassword");
    By loginSignInButton = By.cssSelector("button[type=submit]");
    By pdpAddToCartButton = By.id("add-to-cart-button");
    By headerShaveLink = By.cssSelector("#shave-label");

    String menuItem_Format = ".//li[contains(@class, 'menu-item') and text() = '%s'";
    By searchField = By.name("s");

    public SignInPage clickSignIn() {
        driver.findElement(homePageSignInButton).click();
        return new SignInPage();
    }

    public AccountPage clickLogin() {
        driver.findElement(loginSignInButton).click();
        return new AccountPage();
    }

    public Storefront clickHeaderShaveLink() {
        driver.findElement(headerShaveLink).click();
        return new Storefront();
    }

    private WebElement findMenuItem(String menuItem) {
        String xpath = String.format(menuItem_Format, menuItem);
        return driver.findElement(By.xpath(xpath));
    }

    public Page clickMenuItem(String menuItem) {
        findMenuItem(menuItem).click();
        return new Page();
    }

    public Page clickMenuItem(String menuItem, String subMenuItem) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findMenuItem(menuItem)).perform();
        return clickMenuItem(subMenuItem);
    }

    public SearchResults search(String text) {
        WebElement field = driver.findElement(searchField);
        field.sendKeys(text);
        field.sendKeys(Keys.ENTER);
        return new SearchResults(driver);
    }

}
