package pages;

import org.openqa.selenium.WebDriver;

public class CompletePage extends ParentPage{
    public CompletePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }
}
