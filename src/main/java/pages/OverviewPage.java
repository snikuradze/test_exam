package pages;

import org.openqa.selenium.WebDriver;

public class OverviewPage extends ParentPage{
    public OverviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }
}
