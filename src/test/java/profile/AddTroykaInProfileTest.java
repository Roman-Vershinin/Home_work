package profile;

import authorization.AuthorizationTest;
import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import screens.ProfileMainScreen;

@Slf4j
public class AddTroykaInProfileTest extends BaseTest {
    protected static AppiumDriver driver;




    @Test
    public void transitOnProfile() throws  InterruptedException {
        AuthorizationTest authorizationTest = new AuthorizationTest();
        ProfileMainScreen profileMainScreen = new ProfileMainScreen(driver);
        authorizationTest.testAuth();
        profileMainScreen
                .clickOnIconAcc()
                .clickOnTransport()
                .transitOnAddTroykaForm()
                .clickOnFieldName()
                .inputData()
                .assertTroyka()
                .deleteTroyka();




    }

}
