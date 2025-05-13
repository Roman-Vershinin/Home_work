package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import locators.LocatorMain;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import toolsConfig.ConfigTools;

import java.util.Properties;

@Slf4j
public class FormAuth extends BaseScreen  {

    public FormAuth(AppiumDriver driver) {
        super(driver);
    }
    @Getter
    String login;
    @Getter
    String password;


    ConfigTools configTools = new ConfigTools();

    @AndroidFindBy(xpath = LocatorMain.LOGIN_XPATH)
    private WebElement logIn;

    @AndroidFindBy(xpath = LocatorMain.LOG_IN_TO_ANOTHER_ACC)
    private WebElement loginOnAnotherAcc;

    public FormAuth inputLogin(String loginType) {
        pageFactory(driver);
        String loginValue = "";

        switch (loginType) {
            case "base.user":
                loginValue = (String) configTools.getProperty("baseUserLogin");
                break;
            case "family.user" :
                loginValue = (String) configTools.getProperty("familyUserLogin");
                break;
        }
        try {
            waitUntilElementIsVisible(logIn);
            logIn.sendKeys(loginValue);
            log.info("Логин ввелся");

        } catch (Exception e) {
            loginOnAnotherAcc.click();
            waitUntilElementIsVisible(logIn);
            logIn.sendKeys(loginValue);
            log.info("Логин ввелся");

        }

        return this;
    }
    public void authData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @AndroidFindBy(xpath = LocatorMain.PASSWORD_XPATH)
    private WebElement inputPas;

    public FormAuth inputPassword(String passwordType) {

        String passwordValue = "";

        switch (passwordType) {
            case "base.user":
                passwordValue = (String) configTools.getProperty("baseUserPassword");
                break;
            case "family.user" :
                passwordValue = (String) configTools.getProperty("familyUserPassword");
                break;
        }

        pageFactory(driver);
        waitUntilElementIsVisible(inputPas);
        inputPas.sendKeys(passwordValue);
        log.info("Пароль ввелся");
        return this;
    }

    @AndroidFindBy(xpath = LocatorMain.ENTER_FROM_AUTH)
    private WebElement enterFromAuth;

    public FormAuth clickOnEnterInAuth() {
        pageFactory(driver);
        waitUntilElementIsVisible(enterFromAuth);
        enterFromAuth.click();
        log.info("Кнопка 'Войти' нажалась на форме авторизации");

        return this;
    }
}
