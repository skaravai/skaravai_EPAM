package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class VideoPage extends AbstractPage{
    public VideoPage() {
        super();
    }

    ////*[contains(text(),'More Filters')]
    @FindBy (xpath = "[href = '#collapseMoreFilters']")
    public WebElement moreFiltersBtn;

    @FindBy (css = "#filter_category")
    public WebElement categoryFilterBtn;

    @FindBy (css = "#filter_language")
    public WebElement categoryLocationBtn;

    @FindBy (css = "#filter_language")
    public WebElement categoryLanguageBtn;

    @FindBy (css = "label[data-value = Testing]")
    public WebElement categoryTesting;

    @FindBy (css = "label[data-value = Belarus]")
    public WebElement locationBelarus;

    @FindBy (css = "label[data-value = ENGLISH]")
    public WebElement languageEnglish;

    @FindBy (css = "div[class = evnt-search-filter] > input[type = text]")
    public WebElement searchFilter;

    @FindBy (css = "div[class = evnt-talk-name]")
    public WebElement eventName;

    @FindBy (css = "div[class = 'evnt-talks-column cell-6'] h1 > span")
    public List<WebElement> eventCard;

    @FindBy (css = "[class = evnt-global-loader]")
    public WebElement loader;



    public void findEvents () {
        moreFiltersBtn.click();
        categoryFilterBtn.click();
        categoryTesting.click();
        categoryFilterBtn.click();

        categoryLocationBtn.click();
        locationBelarus.click();
        categoryLocationBtn.click();

        categoryLanguageBtn.click();
        languageEnglish.click();
        categoryLanguageBtn.click();
    }

    public void searchEvents () {
        searchFilter.sendKeys("QA");

    }

    public void checkEvents () {
        waitingForAnItemToDisappear("[class = evnt-global-loader]");
        for (WebElement event : eventCard ) {
            Assertions.assertTrue(event.getText().contains("QA"), "Name doesn't contain QA word");
        }
    }



}
