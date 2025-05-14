package screens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import locators.LocatorMain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import driverConfig.Initializer;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class MainScreen extends BaseScreen {


    public MainScreen (AppiumDriver driver) {
        super(driver);
    }



    @AndroidFindBy(xpath = LocatorMain.SKIP_ONBOARD_XPATH)
    private WebElement skipOnboarding;


    public MainScreen skipOnboard() {
        pageFactory(driver);
        waitUntilElementIsVisible(skipOnboarding);
        skipOnboarding.click();
        log.info("Кнопка 'Пропустить' нажата в онбординге");
        return this;
    }

    @AndroidFindBy(xpath = LocatorMain.ENTER_XPATH)
    private WebElement enterMain;

    public MainScreen clickOnEnter() {
        pageFactory(driver);
        waitUntilElementIsVisible(enterMain);
        enterMain.click();
        log.info("Кнопка 'Войти' нажата");
        return this;

    }
    @AndroidFindBy(xpath = LocatorMain.BANNER)
    private WebElement banner;

    public MainScreen assertBanner() {
        pageFactory(driver);

        try {
            waitUntilElementIsVisible(banner);
            Assert.assertTrue(banner.isDisplayed());
           log.info("Пользователь авторизован");
        } catch (NoSuchElementException e){
            log.info("Сработало исключение");

        }
        return this;

    }

    @AndroidFindBy(xpath = LocatorMain.TEXT_MOBILE_APPS_XPATH)
    private WebElement mobileApps;

    public MainScreen scrollToBanner() throws InterruptedException {
        pageFactory(driver);
        verticalSwipe(mobileApps);
        return this;
    }

    @AndroidFindBy(xpath = LocatorMain.APP_XPATH)
    private WebElement appOurCity;

    @AndroidFindBy(xpath = LocatorMain.RUSTORE_XPATH)
    private WebElement ruStore;

    @AndroidFindBy(xpath = LocatorMain.BUTTON_ALL_XPATH)
    private WebElement buttonAll;

    @AndroidFindBy(xpath = LocatorMain.ICON_APP_XPATH)
    private WebElement iconApp;

    public MainScreen scrollAppsOnBanner() throws InterruptedException {
        pageFactory(driver);

        horizonSwipe(appOurCity);
        elementsIsDisplayed(buttonAll);
        buttonAll.click();
        log.info("Нажали на кнопку 'Все'");

        verticalSwipe(iconApp);
        iconApp.click();
        elementsIsDisplayed(ruStore);

        return this;
    }

    @AndroidFindBy(xpath = LocatorMain.FAMILY_XPATH)
    private WebElement familySphereOfLife;

    public MainScreen clickOnFamilySphereOfLife() throws InterruptedException {
        pageFactory(driver);

        verticalSwipe(familySphereOfLife);
        waitUntilElementIsVisible(familySphereOfLife);
        familySphereOfLife.click();

        return this;
    }

}
