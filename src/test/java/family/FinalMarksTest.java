package family;

import authorization.AuthorizationTest;
import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import screens.FamilyScreen;
import screens.FormAuth;
import screens.MainScreen;

public class FinalMarksTest extends BaseTest {

    protected static AppiumDriver driver;

    @Test

    public void checkFinalMarks() throws InterruptedException {
        MainScreen mainScreen = new MainScreen(driver);
        FormAuth formAuth = new FormAuth(driver);
        FamilyScreen familyScreen = new FamilyScreen(driver);

        mainScreen
                .skipOnboard()
                .clickOnEnter();
        formAuth
                .inputLogin("family.user")
                .inputPassword("family.user")
                .clickOnEnterInAuth();

        mainScreen
                .assertBanner()
                .clickOnFamilySphereOfLife();

        familyScreen
                .clickOnWidgetMarks()
                .clickOnSummaryTab()
                .clickOnSubjectMark()
                .clickOnCardMark();
    }
}
