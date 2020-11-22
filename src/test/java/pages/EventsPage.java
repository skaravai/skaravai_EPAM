package pages;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class EventsPage extends AbstractPage{
    public EventsPage() {
        super();
    }

    SoftAssertions assertions = new SoftAssertions();

    @FindBy(xpath = "(//*[@class='evnt-tab-text desktop'])[1]")
    public WebElement upcomingEventsTab;

    @FindBy(xpath = "(//*[@class='evnt-tab-counter evnt-label small white'])[1]")
    public WebElement numberOfUpcomingEvents;

    @FindBy(xpath = "(//*[@class='evnt-tab-text desktop'])[2]")
    public WebElement pastEventsTab;

    @FindBy(xpath = "(//*[@class='evnt-tab-counter evnt-label small white'])[2]")
    public WebElement numberOfPastEvents;

    @FindBy(xpath = "//*[@class='evnt-events-column cell-3']")
    public List<WebElement> numberOfEventCards;

    @FindBy(css = "div[class='evnt-events-column cell-3'] div[class='evnt-card-heading']")
    public List<WebElement> cardHeader;

    @FindBy(css = "div[class='evnt-events-column cell-3'] div[class='evnt-card-body']")
    public List<WebElement> cardBody;

    @FindBy(css = "div[class='evnt-events-column cell-3'] div[class='evnt-card-footer']")
    public List<WebElement> cardFooter;

    @FindBy(css = "#filter_location")
    public WebElement filterLocation;

    @FindBy(css = "label[data-value = Canada]")
    public WebElement locationCanada;

    @FindBy (css = "div[class='evnt-events-column cell-3']")
    public List<WebElement> eventCard;


    public void clickUpcomingEvents() {upcomingEventsTab.click(); }

    public void checkNumberOfCards() {
        Assertions.assertEquals(Integer.parseInt(numberOfUpcomingEvents.getText()), numberOfEventCards.size(),
                "The number of Events do not compare with number of Cards");
    }

    public void checkCardsContent() {

        for (int i = 0; i < numberOfEventCards.size(); i++) {
            assertions.assertThat(cardBody.get(i).isDisplayed()).isTrue();
            assertions.assertThat(cardHeader.get(i).isDisplayed()).isTrue();
            assertions.assertThat(cardFooter.get(i).isDisplayed()).isTrue();
            assertions.assertAll();
        }

    }

    public void clickPastEvents() {
        pastEventsTab.click();
    }

    public void checkNumberOfPastCards () {
        Assertions.assertEquals(Integer.parseInt(numberOfPastEvents.getText()), numberOfEventCards.size(),
                "The number of Past Events do not compare with number of Cards");

    }

    public void chooseCanadaLocation() {
        filterLocation.click();
        locationCanada.click();
        filterLocation.click();
    }

    public void clickEventCard() {
        eventCard.get(1).click();
    }
}
