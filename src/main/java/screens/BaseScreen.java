package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driverConfig.Initializer;
import java.time.Duration;
import java.util.Collections;
import java.util.Random;


@Slf4j
public abstract class BaseScreen {
    protected AppiumDriver driver;
    private static final String LETTERS = "АБВГДЕЖЗИКЛОМНОПРСТЫстарцгероцй";
    private static final String NUMBERS = "1234567890";
    private static final Random RANDOM = new Random();

    public BaseScreen(AppiumDriver driver) {
        this.driver = Initializer.getDriver();
    }

    public void pageFactory(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void waitUntilElementIsVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void verticalSwipe(WebElement element) throws InterruptedException {

        int maxAttempts = 5;
        int attempt = 0;

        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startYs = driver.manage().window().getSize().getHeight();
        int startY = (int) (driver.manage().window().getSize().getHeight() * 0.8);
        int endY = (int) (startYs * 0.2);

        try {

            while (elementIsDisplayed(element) || attempt <= maxAttempts) {

                if (elementIsDisplayed(element)) {
                    log.info("Элемент найден");
                    break;
                }
                attempt++;

                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

                Sequence swipe = new Sequence(finger, 1);
                swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                driver.perform(Collections.singletonList(swipe));
                log.info("Проскролили вниз");
            }
        } catch (Exception e) {

        }
    }

    public void horizonSwipe(WebElement element) {
        int maxAttempts = 5;
        int attempt = 0;

        int x = driver.manage().window().getSize().getWidth();
        int y = (int) (driver.manage().window().getSize().getHeight() * 0.8);
        int startX = (int) (driver.manage().window().getSize().getWidth() * 0.8);
        int endX = (int) (x * 0.1);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
        log.info("Проскролили вправо");


    }

    public boolean elementIsDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {

            return false;
        }

    }

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(LETTERS.length());
            sb.append(LETTERS.charAt(index));
        }
        return sb.toString();
    }

    public static String generateRandomNumbers(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(NUMBERS.length());
            sb.append(NUMBERS.charAt(index));
        }
        return sb.toString();
    }

    public boolean elementsIsDisplayed(WebElement... elements) {
        for (WebElement element : elements) {
            try {
                if (element.isDisplayed()) {
                    log.info("Элемент с именем " + element.getText() + " отображается на экране");
                    return true;
                }
            } catch (NoSuchElementException e) {
                log.info("Элемент с именем" + element.getText() + "не отображается на экране");


            }
        }

        return false;

    }
}
