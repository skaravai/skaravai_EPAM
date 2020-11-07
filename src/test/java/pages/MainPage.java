package pages;

public class MainPage extends AbstractPage{
    public MainPage() {
        super();
    }

    public void openPage() {
        driver.get("https://events.epam.com/events");

    }

}
