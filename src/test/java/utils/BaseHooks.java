package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseHooks {
    protected static WebDriver driver;

    private static String getParameter(String name) {
        String value = System.getProperty(name);
        if (value == null)
            throw new RuntimeException(name + " is not a parameter!");

        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");

        return value;
    }

    @BeforeAll
    public static void setup() {

        String browserName = getParameter("browser");
        String selenoidUrl = "http://localhost:4444/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();

        switch (browserName) {
            case "chrome":
                caps.setBrowserName("chrome");
                caps.setVersion("83.0");
                caps.setCapability("enableVNC", true);
                caps.setCapability("screenResolution", "1280x1024");
                caps.setCapability("enableVideo", true);
                try {
                    driver = new RemoteWebDriver(new URL(selenoidUrl), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "firefox":
                caps.setBrowserName("firefox");
                caps.setVersion("78.0");
                caps.setCapability("enableVNC", true);
                caps.setCapability("screenResolution", "1280x1024");
                caps.setCapability("enableVideo", true);
                try {
                    driver = new RemoteWebDriver(new URL(selenoidUrl), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "localChrome":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterEach
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
