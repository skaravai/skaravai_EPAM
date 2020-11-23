package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    public MainPage() {
        super();
    }

    @FindBy(xpath = "(//*[contains(text(),'Events')])[2]")
    public WebElement eventsNav;

    @FindBy(xpath = "(//*[contains(text(),'Video')])[1]")
    public WebElement videoNav;

    public void openPage() {
        driver.get("https://events.epam.com");
        logger.info("Открыта страница events.epam.com");
    }

    public void goToEventsTab() {
        eventsNav.click();
        logger.info("Переход на вкладку Events https://events.epam.com/events");
    }

    public void goToVideoTab() {
        videoNav.click();
    }

}
