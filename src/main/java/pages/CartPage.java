package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends ParentPage{
    @FindBy(xpath = ".//*[text()='Checkout']")
    private WebElement buttonCheckout;
    @FindBy(xpath = ".//*[text()='Remove']")
    public List<WebElement> buttonRemove;
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/cart.html";
    }

    public CartPage checkIsRedirectToCartPage() {
        checkUrl();
        Assert.assertTrue("Cart page is not loaded", isElementDisplayed(buttonCheckout));
        return this;
    }
    public CartPage checkCorrectProductIsAdded(int productIndex){
        ProductPage productPage = new ProductPage(webDriver);
        Assert.assertEquals("Incorrect product is displayed", productPage.buttonRemove.get(productIndex).getAttribute("name"), buttonRemove.get(productIndex).getAttribute("name"));
        return this;
    }
    public UserInfoPage clickOnCheckoutButton(){
        clickOnElement(buttonCheckout);
        return new UserInfoPage(webDriver);
    }
}
