package tests;

import org.junit.jupiter.api.Test;
import pages.EventsPage;
import pages.MainPage;
import utils.BaseHooks;

public class ViewingEventCards extends BaseHooks {
    MainPage mainPage = new MainPage();
    EventsPage eventsPage = new EventsPage();

    @Test
    public void viewingEventCards() {
        mainPage.openPage();
        mainPage.goToEventsTab();
        eventsPage.clickUpcomingEvents();
        eventsPage.checkCardsContent();
    }
}
