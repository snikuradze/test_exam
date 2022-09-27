package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsOnElements;
import pages.CartPage;

public class HeaderElement extends ActionsOnElements {
    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }
    public CartPage clickOnCartLink(){
        clickOnElement(cartLink);
        return new CartPage(webDriver);
    }
    public boolean isCartLinkDisplayed(){
        return isElementDisplayed(cartLink);
    }
}
