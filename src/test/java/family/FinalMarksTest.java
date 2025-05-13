package family;

import authorization.AuthorizationTest;
import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import screens.FormAuth;
import screens.MainScreen;

public class FinalMarksTest extends BaseTest {

    protected static AppiumDriver driver;

    @Test

    public void checkFinalMarks() {
        MainScreen mainScreen = new MainScreen(driver);
        FormAuth formAuth = new FormAuth(driver);
        mainScreen
                .skipOnboard()
                .clickOnEnter();
        formAuth
                .inputLogin("familyUserLogin")
                .inputPassword("familyUserPassword")
                .clickOnEnterInAuth();

        mainScreen
                .assertBanner();
    }
}
