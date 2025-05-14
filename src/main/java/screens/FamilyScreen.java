package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import locators.LocatorFamily;
import org.openqa.selenium.WebElement;



public class FamilyScreen extends BaseScreen{
    public FamilyScreen(AppiumDriver driver) {
        super(driver);
    }


    @AndroidFindBy(xpath = LocatorFamily.WIDGET_MARKS_XPATH)
    private WebElement widgetMarks;

    @AndroidFindBy(xpath = LocatorFamily.FILTERS_XPATH)
    private WebElement filters;

    @AndroidFindBy(xpath = LocatorFamily.CURRENT_TAB_XPATH)
    private WebElement currentTab;

    @AndroidFindBy(xpath = LocatorFamily.SUMMARY_TAB_XPATH)
    private WebElement summaryTab;

    public FamilyScreen clickOnWidgetMarks() {
        pageFactory(driver);

        waitUntilElementIsVisible(widgetMarks);
        widgetMarks.click();
        elementsIsDisplayed(filters, currentTab, summaryTab);

        return this;
    }

    @AndroidFindBy(xpath = LocatorFamily.PRELIMINARY_MARK_XPATH)
    private WebElement preliminaryMark;

    public FamilyScreen clickOnSummaryTab() {
        pageFactory(driver);

        waitUntilElementIsVisible(summaryTab);
        summaryTab.click();
        elementsIsDisplayed(preliminaryMark);

        return this;
    }
    @AndroidFindBy(xpath = LocatorFamily.TITLE_MARK_XPATH)
    private WebElement titleMark;

    @AndroidFindBy(xpath = LocatorFamily.SUBTITLE_MARK_XPATH)
    private WebElement subtitleMark;

    @AndroidFindBy(xpath = LocatorFamily.MARK_XPATH)
    private WebElement mark;

    @AndroidFindBy(xpath = LocatorFamily.CARD_MARK_XPATH)
    private WebElement cardMark;


    public FamilyScreen clickOnSubjectMark() {
        pageFactory(driver);

        preliminaryMark.click();
        elementsIsDisplayed(titleMark, subtitleMark, mark, cardMark);

        return this;
    }

    @AndroidFindBy(xpath = LocatorFamily.BANNER_MESH_XPATH)
    private WebElement bannerMesh;

    @AndroidFindBy(xpath = LocatorFamily.RUSTORE_TITLE_XPATH)
    private WebElement rustoreTitle;

    public FamilyScreen clickOnCardMark() {
        pageFactory(driver);

        cardMark.click();
        elementsIsDisplayed(bannerMesh);
        bannerMesh.click();
        elementsIsDisplayed(rustoreTitle);

        return this;
    }

}
