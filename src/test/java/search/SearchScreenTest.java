package search;

import authorization.AuthorizationTest;
import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import screens.SearchScreen;

import java.net.MalformedURLException;

public class SearchScreenTest extends BaseTest {
    protected static AppiumDriver driver;

    @Test

    public void transitionOnSearchScreen() throws MalformedURLException, InterruptedException {
        AuthorizationTest authorizationTest = new AuthorizationTest();
        SearchScreen searchScreen = new SearchScreen(driver);
        authorizationTest.testAuth();
        searchScreen
                .transitOnSearchScreen()
                .inputField()
                .transitInWebView();
    }

}
