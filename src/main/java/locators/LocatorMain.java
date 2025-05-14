package locators;

import org.openqa.selenium.WebElement;

public class LocatorMain {
    public static final String SKIP_ONBOARD_XPATH = "//android.widget.TextView[@resource-id=\"tv_skip\"]";
    public static final String ENTER_XPATH = "//android.view.View[@resource-id=\"btn_action\"]/android.widget.Button";
    public static final String LOGIN_XPATH = "//android.widget.EditText[@resource-id=\"login\"]";
    public static final String PASSWORD_XPATH = "//android.widget.EditText[@resource-id=\"password\"]";
    public static final String ENTER_FROM_AUTH = "//android.widget.Button[@resource-id=\"bind\"]";
    public static final String LOG_IN_TO_ANOTHER_ACC = "//android.widget.Button[@text=\"Войти в другой аккаунт\"]";
    public static final String BANNER = "//android.widget.TextView[@resource-id=\"tv_user_name\"]";
    public static final String ICON_OF_ACCOUNT = "//android.view.View[@resource-id=\"column_main_screen\"]/android.view.View[1]";
    public static final String TEXT_MOBILE_APPS_XPATH = "//android.widget.TextView[@resource-id=\"text_banner_title\"]";
    public static final String APP_XPATH = "(//android.view.View[@resource-id=\"img_app_icon\"])[6]";
    public static final String RUSTORE_XPATH = "//android.widget.Image[@text=\"RuStore\"]";
    public static final String FAMILY_XPATH = "//android.widget.TextView[@resource-id=\"tv_sphere_name\" and @text=\"Семья\"]";
    public static final String BUTTON_ALL_XPATH = "//android.widget.TextView[@resource-id=\"text_all\"]";
    public static final String ICON_APP_XPATH = "//android.widget.TextView[@resource-id=\"text_title\" and @text=\"Russpass\"]";
}
