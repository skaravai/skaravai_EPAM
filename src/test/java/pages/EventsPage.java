package pages;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @FindBy (xpath = "(//*[@class='evnt-events-row'])[1]/div[@class='evnt-events-column cell-3']")
    public List<WebElement> eventThisWeek;

    @FindBy (xpath = "//h3[contains(text(),'This week')]")
    public WebElement thisWeekEvents;

    @FindBy (css= "[class='evnt-dates-cell dates'] span[class='date']")
    public List<WebElement> dateEventsThisWeek;

    public void clickUpcomingEvents() {upcomingEventsTab.click(); }

    public void checkNumberOfCards() {
        Assertions.assertEquals(Integer.parseInt(numberOfUpcomingEvents.getText()), numberOfEventCards.size(),
                "The number of Events do not compare with number of Cards");
    }

    public void checkCardsContent() {
        for (int i = 0; i <= numberOfEventCards.size(); i++) {
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

    public void checkThisWeekEvents() {
        Assertions.assertTrue(thisWeekEvents.isDisplayed(), "No events this week");
    }

    public void checkValidationsDate() {
        Calendar calendar = GregorianCalendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String startDate = df.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String endDate = df.format(calendar.getTime());
        for (int i = 0; i < eventThisWeek.size(); i++) {
            if (endDate.compareTo(dateEventsThisWeek.get(i).getText()) < 7) {
                System.out.println("Дата мероприятия");
            } else {
                Assertions.fail("Дата не совпадает");
            }
        }
    }
}