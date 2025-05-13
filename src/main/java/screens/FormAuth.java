package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import locators.LocatorMain;
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

    ConfigTools configTools = new ConfigTools();

    @AndroidFindBy(xpath = LocatorMain.LOGIN_XPATH)
    private WebElement login;

    @AndroidFindBy(xpath = LocatorMain.LOG_IN_TO_ANOTHER_ACC)
    private WebElement loginOnAnotherAcc;

    public FormAuth inputLogin() {
        pageFactory(driver);
        try {
            waitUntilElementIsVisible(login);
            login.sendKeys(configTools.getProperty("login"));
            log.info("Логин ввелся");

        } catch (Exception e) {
            loginOnAnotherAcc.click();
            waitUntilElementIsVisible(login);
            login.sendKeys(configTools.getProperty("login"));
            log.info("Логин ввелся");

        }

        return this;
    }
    @AndroidFindBy(xpath = LocatorMain.PASSWORD_XPATH)
    private WebElement inputPas;

    public FormAuth inputPassword() {

        pageFactory(driver);
        waitUntilElementIsVisible(inputPas);
        inputPas.sendKeys(configTools.getProperty("password"));
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
