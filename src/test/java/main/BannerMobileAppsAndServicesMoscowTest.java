package main;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import screens.MainScreen;

public class BannerMobileAppsAndServicesMoscowTest  extends BaseTest {
    protected static AppiumDriver driver;

    @Test
    public void mobileApps() throws InterruptedException {
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.skipOnboard();
        mainScreen.scrollToBanner();
        mainScreen.scrollAppsOnBanner();
    }
}
