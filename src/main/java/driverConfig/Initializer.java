package driverConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import toolsConfig.ConfigTools;
import java.net.URI;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)


@Slf4j
public class Initializer {

    @Getter

    private static AppiumDriver driver;
    static ConfigTools configTools = new ConfigTools();


    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, configTools.getProperty("platformName"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, configTools.getProperty("deviceName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, configTools.getProperty("platformVersion"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, configTools.getProperty("automationName"));
        capabilities.setCapability(MobileCapabilityType.APP, configTools.getProperty("app"));

        return capabilities;
    }
    public static void createDriver() {
        try {
            URI appiumServerURI = new URI((String) configTools.getProperty("appium.server.url"));
            URL appiumServerURL = appiumServerURI.toURL();
            driver = new AndroidDriver(appiumServerURL,getDesiredCapabilities());
            log.info("Драйвер успешно инициализирован");
        } catch (Exception e) {
            log.error("Драйвер не инициализировался", e);
        }

    }

    public static void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }




}