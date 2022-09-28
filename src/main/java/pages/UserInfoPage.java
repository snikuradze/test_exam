package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInfoPage extends ParentPage{
    @FindBy(xpath = ".//input[@type='submit']")
    private WebElement buttonContinue;
    @FindBy(xpath = ".//input[@name='firstName']")
    private WebElement firstName;
    @FindBy(xpath = ".//input[@name='lastName']")
    private WebElement lastName;
    @FindBy(xpath = ".//input[@name='postalCode']")
    private WebElement zipCode;
    public UserInfoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/checkout-step-one.html";
    }

    public UserInfoPage checkIsRedirectToUserInfoPage() {
        checkUrl();
        Assert.assertTrue("User info page is not loaded", isElementDisplayed(buttonContinue));
        return this;
    }

    public UserInfoPage enterFirstName(String userName) {
        enterTextIntoElement(firstName, userName);
        return this;
    }

    public UserInfoPage enterLastName(String familyName) {
        enterTextIntoElement(lastName, familyName);
        return this;
    }

    public UserInfoPage enterPostalCode(String code) {
        enterTextIntoElement(zipCode, code);
        return this;
    }

    public OverviewPage clickOnContinueButton() {
        clickOnElement(buttonContinue);
        return new OverviewPage(webDriver);
    }
    public UserInfoPage fillFormWithValidData(){
        enterFirstName("John");
        enterLastName("Doe");
        enterPostalCode("ABC123");
        return this;
    }
}
