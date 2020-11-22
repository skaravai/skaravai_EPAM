package tests;

import org.junit.jupiter.api.Test;
import pages.EventsPage;
import pages.MainPage;
import utils.BaseHooks;

public class ViewPastEvents extends BaseHooks {

    MainPage mainPage = new MainPage();
    EventsPage eventsPage = new EventsPage();

    @Test
    public void viewUpcomingEventsTest() {

        mainPage.openPage();
        mainPage.goToEventsTab();
        eventsPage.clickPastEvents();
        eventsPage.chooseCanadaLocation();
        eventsPage.checkNumberOfPastCards();
    }

}
