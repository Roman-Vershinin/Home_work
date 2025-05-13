package authorization;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.FormAuth;
import screens.MainScreen;

@Slf4j
public class AuthorizationTest {
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
               .inputLogin()
               .inputPassword()
               .clickOnEnterInAuth();

       mainScreen
               .assertBanner();

 }


}
