package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import utils.BaseHooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ViewUpcomingEvents extends BaseHooks {
    private Logger logger = LogManager.getLogger(ViewUpcomingEvents.class);
    MainPage mainPage = new MainPage();

    @Test
    public void viewUpcomingEventsTest() {

        mainPage.openPage();
        logger.info("Открыта страница events.epam.com");
    }

}
