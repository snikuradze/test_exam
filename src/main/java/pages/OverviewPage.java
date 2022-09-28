package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends ParentPage{
    @FindBy(xpath = ".//button[@id='finish']")
    private WebElement buttonFinish;
    public OverviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/checkout-step-two.html";
    }

    public OverviewPage checkIsRedirectToOverviewPage() {
        checkUrl();
        Assert.assertTrue("Overview page is not loaded", isElementDisplayed(buttonFinish) & webDriver.findElement(By.className("summary_total_label")).isDisplayed());
        return this;
    }
}
