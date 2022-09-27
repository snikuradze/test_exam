package productTest;

import baseTest.BaseTest;
import org.junit.Test;

public class AddProductsToCartTest extends BaseTest {
    @Test
    public void addProductsToCartTest(){
        productPage
                   .openProductPage()
                   .clickOnAddToCartButton(0)
                   .clickOnAddToCartButton(1)
                   .clickOnAddToCartButton(2)
                 .checkQuantityOfRemoveButtonDisplayed(3)
                 .checkQuantityOfBadgesDisplayed("3");
    }
}
