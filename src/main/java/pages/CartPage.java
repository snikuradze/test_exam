package pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends ParentPage{
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }
}
