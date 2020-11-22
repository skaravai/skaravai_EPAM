package tests;

import org.junit.jupiter.api.Test;
import pages.EventsPage;
import pages.MainPage;
import pages.SelectedEventPage;
import utils.BaseHooks;

public class ViewingEventDetails extends BaseHooks {
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
