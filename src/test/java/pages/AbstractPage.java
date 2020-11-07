package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.BaseHooks;

public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage() {
        driver = BaseHooks.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

}
