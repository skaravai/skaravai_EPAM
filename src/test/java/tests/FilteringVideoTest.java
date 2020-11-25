package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.MainPage;
import pages.VideoPage;
import utils.BaseHooks;

@Execution(ExecutionMode.CONCURRENT)
public class FilteringVideoTest extends BaseHooks {
    MainPage mainPage = new MainPage();
    VideoPage videoPage = new VideoPage();

    @Test
    public void filteringVideo() {
        mainPage.openPage();
        mainPage.goToVideoTab();
        videoPage.findEvents();
    }
}
