package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class ActionsOnElements {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsOnElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        String baseUrl = "https://www.saucedemo.com/";
    }
    abstract String getRelativeUrl();
}
