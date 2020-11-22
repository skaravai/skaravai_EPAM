package tests;

import org.junit.jupiter.api.Test;
import pages.EventsPage;
import pages.MainPage;

public class DateValidation {
    MainPage mainPage = new MainPage();
    EventsPage eventsPage = new EventsPage();

    @Test
    public void dateValidation() {
        mainPage.openPage();
        mainPage.goToEventsTab();
        eventsPage.clickUpcomingEvents();

    }
}
