package checkoutTest;

import baseTest.BaseTest;
import org.junit.Test;

public class ProductsInCartTest extends BaseTest {
    @Test
    public void productInCartTest(){
        productPage
                   .openProductPage()
                   .clickOnAddToCartButton(0)
                 .checkQuantityOfRemoveButtonDisplayed(1)
                 .checkQuantityOfBadgesDisplayed("1")
                   .getHeaderElement().clickOnCartLink()
                 .checkIsRedirectToCartPage()
                   .checkCorrectProductIsAdded(0);
    }
}
