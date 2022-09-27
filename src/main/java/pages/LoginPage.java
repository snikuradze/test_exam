package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    @FindBy(xpath = ".//input[@type='text']")
    private WebElement inputUserName;
    @FindBy(xpath = ".//input[@type='password']")
    private WebElement inputPassword;
    @FindBy(xpath = ".//input[@type='submit']")
    private WebElement buttonLogin;
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    String getRelativeUrl() {
        return "/";
    }

    public LoginPage openLoginPage(){
        try {
            webDriver.get(baseUrl);
            logger.info("Login page is opened");
            logger.info(baseUrl);
        }catch (Exception e){
            logger.error("Can not work with site");
            Assert.fail("Can not work with site");
        }
        return this;
    }
    public LoginPage enterUserNameIntoLoginInput(String userName){
        enterTextIntoElement(inputUserName, userName);
        return this;
    }
    public LoginPage enterPasswordIntoPasswordInput(String password){
        enterTextIntoElement(inputPassword, password);
        return this;
    }
    public LoginPage clickOnButtonLogin(){
        clickOnElement(buttonLogin);
        return this;
    }
    public ProductPage loginWithValidCredWithoutOpenPage(){
        enterUserNameIntoLoginInput("standard_user");
        enterPasswordIntoPasswordInput("secret_sauce");
        clickOnButtonLogin();
        return new ProductPage(webDriver);
    }
}
