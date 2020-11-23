package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.ViewUpcomingEvents;
import utils.BaseHooks;

public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage() {
        driver = BaseHooks.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public Logger logger = LogManager.getLogger(ViewUpcomingEvents.class);

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
//    public void checkIsDisplayedElement(WebElement element) {
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions
//                        .elementToBeClickable(element));
//        Assertions.assertTrue(element.isDisplayed(),"This element is not displayed");
//    }
}
