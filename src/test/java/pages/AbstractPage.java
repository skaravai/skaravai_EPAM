package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.ViewUpcomingEventsTest;
import utils.BaseHooks;

public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage() {
        driver = BaseHooks.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public Logger logger = LogManager.getLogger(ViewUpcomingEventsTest.class);

    public void waitingForAnItemToDisappear(String locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locator)));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            logger.info("Элемент не отобразился");
        }
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
}
