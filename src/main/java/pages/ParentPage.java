package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract class ParentPage extends ActionsOnElements{
    protected String baseUrl;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        baseUrl = "https://www.saucedemo.com/";
    }
    abstract String getRelativeUrl();

    protected void checkUrlWithPattern(){
        logger.debug(webDriver.getCurrentUrl());
        String actualURL = webDriver.getCurrentUrl();
        Assert.assertTrue("\n ActualURL " + actualURL + "\n " + "ExpectedURL pattern " + baseUrl + getRelativeUrl() + " \n ", actualURL.matches(baseUrl + getRelativeUrl()));

    }
}
