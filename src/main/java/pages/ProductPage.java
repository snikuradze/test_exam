package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

import java.util.List;

public class ProductPage extends ParentPage{
    private HeaderElement headerElement = new HeaderElement(webDriver);
    @FindBy(xpath = ".//*[text()='Add to cart']")
    private List<WebElement> buttonAddToCart;
    @FindBy(xpath = ".//*[text()='Remove']")
    public List<WebElement> buttonRemove;
    @FindBy(xpath = ".//*[@class='shopping_cart_badge']")
    private WebElement cartBadge;
    @FindBy(tagName = "select")
    private WebElement dropDown;
    @FindBy(className = "active_option")
    private WebElement activeOption;
    @FindBy(xpath = ".//*[@class='inventory_item_price']")
    private List<WebElement> productPrice;
    @FindBy(xpath = ".//*[@class='inventory_item_name']")
    private List<WebElement> productName;
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    String getRelativeUrl() {
        return "/inventory.html";
    }
    public HeaderElement getHeaderElement() {
        return headerElement;
    }
    public ProductPage checkIsRedirectToProductPage(){
        checkUrl();
        Assert.assertTrue("Product page is not opened", getHeaderElement().isCartLinkDisplayed());
        return this;
    }
    public ProductPage openProductPage(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if (!getHeaderElement().isCartLinkDisplayed()){
            loginPage.loginWithValidCredWithoutOpenPage();
        }
        checkIsRedirectToProductPage();
        return this;
    }
    public ProductPage clickOnAddToCartButton(int productIndex) {
        clickOnElement(buttonAddToCart.get(productIndex));
        return this;
    }
    public ProductPage checkQuantityOfRemoveButtonDisplayed(int numberOfRemoveButtons){
        Assert.assertEquals("Incorrect number of remove buttons is displayed", numberOfRemoveButtons, buttonRemove.size());
        logger.info("Number of remove buttons is " + buttonRemove.size());
        return this;
    }
    public ProductPage checkQuantityOfBadgesDisplayed(String numberOfBadges){
        Assert.assertEquals("Incorrect number of badges is displayed", numberOfBadges, cartBadge.getText());
        logger.info("Number of badges is " + cartBadge.getText());
        return this;
    }
    public ProductPage selectToSortBy(String textForSelect){
        selectTextInDropDown(dropDown, textForSelect);
        return this;
    }
    public ProductPage checkProductsOrder(){
        if (activeOption.getText().equalsIgnoreCase("Name (A to Z)")){
            Assert.assertTrue("Sorted NOT A to Z", productName.get(0).getText().equalsIgnoreCase("Sauce Labs Backpack"));
            logger.info("Sorted by name from A to Z");
        } else if (activeOption.getText().equalsIgnoreCase("Name (Z to A)")) {
            Assert.assertTrue("Sorted NOT Z to A", productName.get(0).getText().equalsIgnoreCase("Test.allTheThings() T-Shirt (Red)"));
            logger.info("Sorted by name from Z to A");
        } else if (activeOption.getText().equalsIgnoreCase("Price (low to high)")) {
            Assert.assertTrue("Sorted NOT low to high", productPrice.get(0).getText().equalsIgnoreCase("$7.99"));
            logger.info("Sorted by price from Low to High");
        } else if (activeOption.getText().equalsIgnoreCase("Price (high to low)")) {
            Assert.assertTrue("Sorted NOT high to low", productPrice.get(0).getText().equalsIgnoreCase("$49.99"));
            logger.info("Sorted by price from High to Low");
        }
        return this;
    }
    public ProductPage checkBadgesNotDisplayedOnCart(){
        Assert.assertFalse("Badges are displayed", isElementDisplayed(cartBadge));
        logger.info("Badges are not displayed");
        return this;
    }
}
