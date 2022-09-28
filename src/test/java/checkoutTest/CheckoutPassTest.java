package checkoutTest;

import baseTest.BaseTest;
import org.junit.Test;

public class CheckoutPassTest extends BaseTest {
    @Test
    public void passCheckoutTest(){
        productPage
                   .openProductPage()
                   .clickOnAddToCartButton(0)
                   .getHeaderElement().clickOnCartLink()
                .checkIsRedirectToCartPage()
                .checkCorrectProductIsAdded(0)
                   .clickOnCheckoutButton()
                .checkIsRedirectToUserInfoPage()
                   .fillFormWithValidData()
                   .clickOnContinueButton()
                .checkIsRedirectToOverviewPage()
                   .clickOnFinishButton()
                .checkIsRedirectToCompletePage()
                   .clickOnBackHomeButton()
                .checkIsRedirectToProductPage()
                   .checkBadgesNotDisplayedOnCart()
        ;
    }
}
