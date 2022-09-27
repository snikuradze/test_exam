package loginTest;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {
    @Test
    public void validLogin(){
        loginPage
                .openLoginPage()
                .enterUserNameIntoLoginInput("standard_user")
                .enterPasswordIntoPasswordInput("secret_sauce")
                .clickOnButtonLogin();
        Assert.assertTrue("Cart link is displayed", productPage.getHeaderElement().isCartLinkDisplayed());
    }
}
