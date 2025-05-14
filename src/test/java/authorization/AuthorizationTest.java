package authorization;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.FormAuth;
import screens.MainScreen;

@Slf4j
public class AuthorizationTest extends BaseTest {
    protected static AppiumDriver driver;

    @Test
    @DisplayName("Открыта форма авторизации")

    public void testAuth() {
       MainScreen mainScreen = new MainScreen(driver);
       FormAuth formAuth = new FormAuth(driver);
       mainScreen
               .skipOnboard()
               .clickOnEnter();
       formAuth
               .inputLogin("base.user")
               .inputPassword("base.user")
               .clickOnEnterInAuth();

       mainScreen
               .assertBanner();

 }
}
