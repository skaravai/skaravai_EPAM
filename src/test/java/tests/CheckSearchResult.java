package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.VideoPage;
import utils.BaseHooks;

public class CheckSearchResult extends BaseHooks {
    MainPage mainPage = new MainPage();
    VideoPage videoPage = new VideoPage();

    @Test
    public void checkSearchResult() {
        mainPage.openPage();
        mainPage.goToVideoTab();
        videoPage.searchEvents();
        videoPage.checkEvents();
    }
}
