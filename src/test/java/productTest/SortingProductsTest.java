package productTest;

import baseTest.BaseTest;
import org.junit.Test;

public class SortingProductsTest extends BaseTest {
    @Test
    public void ascendingPriceSortingTest(){
        productPage
                   .openProductPage()
                   .checkProductsOrder()
                   .selectToSortBy("Price (low to high)")
                   .checkProductsOrder();
    }
}
