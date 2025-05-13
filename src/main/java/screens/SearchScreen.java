package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import locators.LocatorSearch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

@Slf4j
public class SearchScreen extends BaseScreen{
    public SearchScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = LocatorSearch.SEARCH_XPATH)
    private WebElement transitSearch;

    public SearchScreen transitOnSearchScreen() {
        pageFactory(driver);
        waitUntilElementIsVisible(transitSearch);
        transitSearch.click();
        log.info("Перешли на экран Поиск");

        return this;
    }

    @AndroidFindBy(xpath = LocatorSearch.SEARCH_FIELD_XPATH)
    private WebElement searchField;

    @AndroidFindBy(xpath = LocatorSearch.RECEPTION_INDICATIONS)
    private WebElement receptIndications;

    public SearchScreen inputField() {
        pageFactory(driver);
        waitUntilElementIsVisible(searchField);
        searchField.sendKeys("прием показа");
        log.info("Ввели в поле текст 'прием показа'");
        waitUntilElementIsVisible(receptIndications);
        receptIndications.click();
        log.info("Перешли в вебвью услуги");

        return this;
    }

    @AndroidFindBy(xpath = LocatorSearch.WebVIEW)
    private WebElement webView;

    public SearchScreen transitInWebView() {
        pageFactory(driver);
        waitUntilElementIsVisible(webView);
        try {
            Assert.assertTrue(webView.getText().contains("Приём показаний и оплата электроэнергии"));
            log.info("текст 'Приём показаний и оплата электроэнергии' отображается на странице");

        } catch (Exception e) {
            System.out.println("текст 'Приём показаний и оплата электроэнергии' не найден на странице ");
        }
        return this;
    }
}
