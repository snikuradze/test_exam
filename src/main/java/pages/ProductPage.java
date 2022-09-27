package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

import java.util.List;

public class ProductPage extends ParentPage{
    private HeaderElement headerElement = new HeaderElement(webDriver);
/*  @FindBy(xpath = ".//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartSauceLabsBackpack;
    @FindBy(xpath = ".//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement addToCartSauceLabsBikeLight;
    @FindBy(xpath = ".//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement addToCartSauceLabsBoltTShirt;
    @FindBy(xpath = ".//button[@id='remove-sauce-labs-backpack']")
    private WebElement removeSauceLabsBackpack;
    @FindBy(xpath = ".//button[@id='remove-sauce-labs-bike-light']")
    private WebElement removeSauceLabsBikeLight;
    @FindBy(xpath = ".//button[@id='remove-sauce-labs-bolt-t-shirt']")
    private WebElement removeSauceLabsBoltTShirt;*/
    @FindBy(xpath = ".//*[text()='Add to cart']")
    private List<WebElement> buttonAddToCart;
    @FindBy(xpath = ".//*[text()='Remove']")
    private List<WebElement> buttonRemove;
    @FindBy(xpath = ".//*[@class='shopping_cart_badge']")
    private WebElement cartBadge;
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
/*      clickOnElement(addToCartSauceLabsBackpack);
        clickOnElement(addToCartSauceLabsBikeLight);
        clickOnElement(addToCartSauceLabsBoltTShirt);*/
        clickOnElement(buttonAddToCart.get(productIndex));
        logger.info(buttonAddToCart + " was clicked");
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
}
