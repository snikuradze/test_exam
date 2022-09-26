package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ActionsOnElements {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsOnElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    protected void enterTextIntoElement(WebElement webElement, String text){
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info("'" + text + "' was inputted into '" + getElementName(webElement) + "'");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
    protected void clickOnElement(WebElement webElement){
        try {
            String name = getElementName(webElement);
            webElement.click();
            logger.info("'" + name + "' was clicked");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
    protected boolean isElementDisplayed(WebElement webElement){
        try {
            boolean state = webElement.isDisplayed();
            String message;
            if (state) {
                message = "Element is displayed";
            } else {
                message = "Element is Not displayed";
            }
            logger.info(message);
            return state;
        }catch (Exception e){
            logger.info("Element is Not displayed");
            return false;
        }
    }
    protected void selectTextInDropDown(WebElement dropdown, String text){
        try {
            Select select = new Select(dropdown);
            select.selectByVisibleText(text);
            logger.info("'" + text + "' was selected in DropDown");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
    private String getElementName(WebElement webElement){
        try {
            return webElement.getAccessibleName();
        } catch (Exception e){
            return "";
        }
    }
    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }
}
