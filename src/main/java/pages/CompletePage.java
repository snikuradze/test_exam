package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends ParentPage{
    @FindBy(xpath = ".//img[@alt='Pony Express']")
    private WebElement logo;
    @FindBy(xpath = ".//button[text()='Back Home']")
    private WebElement buttonHome;
    public CompletePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/checkout-complete.html";
    }

    public CompletePage checkIsRedirectToCompletePage() {
        checkUrl();
        Assert.assertTrue("Complete page is not loaded", isElementDisplayed(logo));
        return this;
    }

    public ProductPage clickOnBackHomeButton() {
        clickOnElement(buttonHome);
        return new ProductPage(webDriver);
    }
}
