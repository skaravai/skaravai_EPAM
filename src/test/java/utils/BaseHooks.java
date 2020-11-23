package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseHooks {
    protected static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    public static WebDriver getDriver() {
        return driver;
    }

//    @AfterAll
//    public static void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
