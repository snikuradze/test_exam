package pages;

import org.openqa.selenium.WebDriver;

public class UserInfoPage extends ParentPage{
    public UserInfoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }
}
