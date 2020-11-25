package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.EventsPage;
import pages.MainPage;
import pages.SelectedEventPage;
import utils.BaseHooks;

@Execution(ExecutionMode.CONCURRENT)
public class ViewingEventDetailsTest extends BaseHooks {
    MainPage mainPage = new MainPage();
    EventsPage eventsPage = new EventsPage();
    SelectedEventPage selectedEventPage = new SelectedEventPage();

    @Test
    public void viewingEventDetails() {

        mainPage.openPage();
        mainPage.goToEventsTab();
        eventsPage.clickEventCard();
        selectedEventPage.checkElements();

    }
}
