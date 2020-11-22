package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideoPage extends AbstractPage{
    public VideoPage() {
        super();
    }

    @FindBy (xpath = "//*[contains(text(),'More Filters')]")
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

    public void findEvents () {
        moreFiltersBtn.click();
        categoryFilterBtn.click();
        categoryTesting.click();
        categoryLocationBtn.click();
        locationBelarus.click();
        categoryLanguageBtn.click();
        languageEnglish.click();
        categoryLanguageBtn.click();
    }



}
