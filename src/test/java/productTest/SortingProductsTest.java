package productTest;

import baseTest.BaseTest;
import org.junit.Test;

public class SortingProductsTest extends BaseTest {
    static final String az = "Name (A to Z)";
    static final String za = "Name (Z to A)";
    static final String lohi = "Price (low to high)";
    static final String hilo = "Price (high to low)";
    @Test
    public void ascendingPriceSortingTest(){
        productPage
                   .openProductPage()
                   .checkProductsOrder()
                   .selectToSortBy(lohi)
                   .checkProductsOrder();
    }
}
