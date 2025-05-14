package profile;

import authorization.AuthorizationTest;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import screens.ProfileMainScreen;
import base.BaseTest;

public class AddAvatarInProfileTest extends BaseTest {
    protected static AppiumDriver driver;

    @Test

    public void addAvatar() {
    AuthorizationTest authorizationTest = new AuthorizationTest();
    ProfileMainScreen profileMainScreen = new ProfileMainScreen(driver);
    authorizationTest.testAuth();
    profileMainScreen
            .clickOnEmptyAvatar()
            .choiceAvatarSource()
            .selectPhotoInPhone();

    }
}
