package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectedEventPage extends AbstractPage {
    public SelectedEventPage() {
        super();
    }

    @FindBy (xpath = "(//*[contains(text(),'Register')])[1]")
    public WebElement registerBtn;

    @FindBy (css = "div[class = evnt-icon-point]")
    public List<WebElement> dateBlock;

    @FindBy (css = "div[class = evnt-agenda-wrapper]")
    public WebElement eventProgram;

    public void checkElements () {
        registerBtn.isDisplayed();
        dateBlock.get(1).isDisplayed();
        eventProgram.isDisplayed();
    }





}
