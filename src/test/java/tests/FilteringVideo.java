package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.VideoPage;
import utils.BaseHooks;

public class FilteringVideo extends BaseHooks {
    MainPage mainPage = new MainPage();
    VideoPage videoPage = new VideoPage();

    @Test
    public void filteringVideo() {
        mainPage.openPage();
        mainPage.goToVideoTab();
        videoPage.findEvents();
    }
}
