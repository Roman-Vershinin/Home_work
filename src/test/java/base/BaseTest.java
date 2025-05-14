package base;

import io.appium.java_client.AppiumDriver;
import driverConfig.Initializer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;

@Slf4j
public class BaseTest {
    protected static AppiumDriver driver;

    @BeforeEach

    public void setUP() {
        log.info("Инициализация драйвера перед тестом");
    Initializer.createDriver();
       log.info("Тест начинается");
    }

    @AfterEach
    public void closedDriver() throws MalformedURLException {
        log.info("Драйвер выключен");
        Initializer.quitDriver();
    }
}
