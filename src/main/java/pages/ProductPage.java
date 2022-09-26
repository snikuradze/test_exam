package pages;

import org.openqa.selenium.WebDriver;

public class ProductPage extends ParentPage{
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }
}
