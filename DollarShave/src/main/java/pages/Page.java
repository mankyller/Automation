package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseTests;

public class Page {

    protected WebDriver driver = BaseTests.getDriver();

    By homePageSignInButton = By.cssSelector("span[class=sr-only] + span[class=menu__title]");
    By emailInput = By.id("CustomerEmail");
    By passwordInput = By.id("CustomerPassword");
    By loginSignInButton = By.cssSelector("button[type=submit]");
    By pdpAddToCartButton = By.id("add-to-cart-button");


}
