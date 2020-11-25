package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.EventsPage;
import pages.MainPage;
import utils.BaseHooks;

@Execution(ExecutionMode.CONCURRENT)
public class ViewUpcomingEventsTest extends BaseHooks {

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
