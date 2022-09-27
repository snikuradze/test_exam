package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
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
        if (productPrice.get(0).getAccessibleName().equalsIgnoreCase("29.99")){
            Assert.assertEquals("Name (A to Z)", activeOption.getText());
        } else if (productPrice.get(0).getAccessibleName().equalsIgnoreCase("15.99")) {
            Assert.assertEquals("Name (Z to A)", activeOption.getText());
        } else if (productPrice.get(0).getAccessibleName().equalsIgnoreCase("7.99")) {
            Assert.assertEquals("Price (low to high)", activeOption.getText());
        } else if (productPrice.get(0).getAccessibleName().equalsIgnoreCase("49.99")) {
            Assert.assertEquals("Price (high to low)", activeOption.getText());
        }
        return this;
    }
}
