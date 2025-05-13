import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class NewTest {

    private static AppiumDriver driver;


    private static void assq () throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android12");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("app", "ru.mos.app.dev");
//        capabilities.setCapability("appActivity", "ru.mos.superapp.presentation.MainActivity");
        capabilities.setCapability("app", "/Users/romanversinin/Downloads/mobile_sa_dev_debug_4.4_1198_2025.1.6.4.apk");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }


    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkTitleScreen() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android12");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("appPackage", "ru.mos.app.dev");
//        capabilities.setCapability("appActivity", "ru.mos.superapp.presentation.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\elect\\Downloads\\mobile_sa_dev_debug_4.4_1198_2025.1.6.4.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"tv_skip\"]")));
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"tv_skip\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id=\"btn_action\"]/android.widget.Button")));
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"btn_action\"]/android.widget.Button")).click();


    }

}







