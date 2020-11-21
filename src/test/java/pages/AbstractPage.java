package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import tests.ViewUpcomingEvents;
import utils.BaseHooks;

public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage() {
        driver = BaseHooks.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public Logger logger = LogManager.getLogger(ViewUpcomingEvents.class);
}
