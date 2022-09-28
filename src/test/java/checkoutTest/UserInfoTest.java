package checkoutTest;

import baseTest.BaseTest;
import org.junit.Test;

public class UserInfoTest extends BaseTest {
    @Test
    public void userInfoStepTest(){
        productPage
                   .openProductPage()
                   .clickOnAddToCartButton(0)
                   .getHeaderElement().clickOnCartLink()
                 .checkIsRedirectToCartPage()
                   .checkCorrectProductIsAdded(0)
                   .clickOnCheckoutButton()
                 .checkIsRedirectToUserInfoPage()
                   .enterFirstName("Serhii")
                   .enterLastName("Nikuradze")
                   .enterPostalCode("AA4214213")
                   .clickOnContinueButton()
                 .checkIsRedirectToOverviewPage()
        ;
    }
}
