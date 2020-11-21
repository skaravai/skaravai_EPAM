package tests;

import org.junit.jupiter.api.Test;
import pages.EventsPage;
import pages.MainPage;
import utils.BaseHooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ViewUpcomingEvents extends BaseHooks {

    MainPage mainPage = new MainPage();
    EventsPage eventsPage = new EventsPage();

    @Test
    public void viewUpcomingEventsTest() {

        mainPage.openPage();
        mainPage.goToEventsTab();
        eventsPage.clickUpcomingEvents();
        eventsPage.checkNumberOfCards();

    }


}
