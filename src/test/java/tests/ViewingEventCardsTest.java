package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.EventsPage;
import pages.MainPage;
import utils.BaseHooks;

@Execution(ExecutionMode.CONCURRENT)
public class ViewingEventCardsTest extends BaseHooks {
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
