package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import locators.LocatorMain;
import locators.LocatorProfile;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class ProfileMainScreen extends BaseScreen{
    public ProfileMainScreen(AppiumDriver driver) {
        super(driver);
    }

@AndroidFindBy(xpath = LocatorMain.ICON_OF_ACCOUNT)
private WebElement iconOfAccount;

    public ProfileMainScreen clickOnIconAcc() {
        pageFactory(driver);
        try {
            waitUntilElementIsVisible(iconOfAccount);
            iconOfAccount.click();
            log.info("Нажали на иконку профиля");
        } catch (Exception e) {
            log.info("Произошла ошибка при нажатии на иконку профиля");
        }
        return this;
    }

    @AndroidFindBy(xpath = LocatorProfile.CLICK_ON_TRANSPORT_XPATH)
    private WebElement transport;

    @AndroidFindBy(xpath = LocatorProfile.HEADER_PROFILE_XPATH)
    private WebElement headerProfile;

    public ProfileMainScreen clickOnTransport() throws InterruptedException {
        pageFactory(driver);
        waitUntilElementIsVisible(headerProfile);
        verticalSwipe(transport);

        try {
           waitUntilElementIsVisible(transport);
           transport.click();
           log.info("Элемент 'Транспорт'найден и нажат");
       } catch (TimeoutException e) {
           log.info("Элемент не найден");
       }
       return this;
    }

    @AndroidFindBy(xpath = LocatorProfile.CLICK_ON_ADD_TROYKA_XPATH)
    private WebElement troykaForm;

    public ProfileMainScreen transitOnAddTroykaForm() {
        pageFactory(driver);
        try {
            waitUntilElementIsVisible(troykaForm);
            troykaForm.click();
            log.info("Плашка тройки нажата");
        } catch (Exception e) {
            log.info("Элемент не нажат" + e.getMessage());
        }
        return this;
    }

    @AndroidFindBy(xpath = LocatorProfile.FIELD_NAME_XPATH)
    private WebElement fieldName;

    @AndroidFindBy(xpath = LocatorProfile.BUTTON_NEXT_XPATH)
    private WebElement next;

    @AndroidFindBy(xpath = LocatorProfile.FIELD_NAME_IN_FORM_XPATH)
    private WebElement  fieldNameInForm;

    @AndroidFindBy(xpath = LocatorProfile.FIELD_NUMBER_IN_FORM_XPATH)
    private WebElement  fieldNumberInForm;

    @AndroidFindBy(xpath = LocatorProfile.BUTTON_SAVE_IN_FORM_XPATH)
    private WebElement saveBottonInForm;

    @AndroidFindBy(xpath = LocatorProfile.BUTTON_SAVE_XPATH)
    private WebElement saveBotton;

    public ProfileMainScreen clickOnFieldName() {
        pageFactory(driver);

        try {
            waitUntilElementIsVisible(fieldName);
            fieldName.click();
            log.info("Нажали на поле 'Название'");
        } catch (Exception e) {
            log.info("Произошла ошибка при тапе на поле");
        }
        return this;
    }
    public ProfileMainScreen inputData() {
        pageFactory(driver);

        try {
            waitUntilElementIsVisible(fieldNameInForm);
            fieldNameInForm.sendKeys(BaseScreen.generateRandomString(5));
            log.info("Данные введены в поле 'Название'");
        } catch (Exception e) {
            log.info("Произошла ошибка при вводе данных");
        }

        try {
            waitUntilElementIsVisible(next);
            next.click();
            log.info("Кнопка 'Далее' нажата");
        } catch (Exception e) {
            log.info("Произошла ошибка при нажатии на кнопку 'Далее'");
        }

        try {
            waitUntilElementIsVisible(fieldNumberInForm);
            fieldNumberInForm.sendKeys(BaseScreen.generateRandomNumbers(10));
            log.info("Данные введены в поле 'Номер карты'");
        } catch (Exception e) {
            log.info("Произошла ошибка при вводе данных");
        }

        try {
            waitUntilElementIsVisible(saveBottonInForm);
            saveBottonInForm.click();
            log.info("кнопка 'Сохранить' нажата");
        } catch (Exception e) {
            log.info("Произошла ошибка при нажатии на кнопку 'Сохранить'");
        }

        try {
            waitUntilElementIsVisible(saveBotton);
            saveBotton.click();
            log.info("кнопка 'Сохранить' нажата");
        } catch (Exception e) {
            log.info("Произошла ошибка при нажатии на кнопку 'Сохранить'");

        }
        return this;
    }
    @AndroidFindBy(xpath = LocatorProfile.HEADER_TROYKA_XPATH)
    private WebElement header;

    public ProfileMainScreen assertTroyka() {
        pageFactory(driver);

        try {
            waitUntilElementIsVisible(header);
            Assert.assertTrue(header.getText().contains("Карта «Тройка»"));
            log.info("Карта 'Тройка' добавлена в профиль");
        } catch (Exception e) {
            log.info("Произошла ошибка при сохранении карты" + e.getMessage());
        }
        return this;
    }

    @AndroidFindBy(xpath = LocatorProfile.BURGER_BUTTON_XPATH)
    private WebElement burgerButton;

    @AndroidFindBy(xpath = LocatorProfile.DELETE_BUTTON_XPATH)
    private WebElement deleteButton;

    @AndroidFindBy(xpath = LocatorProfile.DELETE_BUTTON_IN_MODAL_WINDOW_XPATH)
    private WebElement deleteButtonInModalWindow;

    @AndroidFindBy(xpath = LocatorProfile.HEADER_TRANSPORT_SCREEN_XPATH)
    private WebElement headerTransportScreen;


    public ProfileMainScreen deleteTroyka() {
        pageFactory(driver);


            waitUntilElementIsVisible(burgerButton);
            burgerButton.click();
            log.info("Кнопка бургер нажата");

            waitUntilElementIsVisible(deleteButton);
            deleteButton.click();
            log.info("Кнопка 'Удалить' нажата");

            waitUntilElementIsVisible(deleteButtonInModalWindow);
            deleteButtonInModalWindow.click();
            log.info("Кнопка 'Удалить' в модальном окне нажата");


            try {
            waitUntilElementIsVisible(headerTransportScreen);
            Assert.assertTrue(headerTransportScreen.getText().contains("Транспорт"));
            log.info("Карта 'Тройка' удалена из профиля");
        } catch (Exception e) {
            log.info("Ошибка при удалении тройки" + e.getMessage());
        }
        return this;
    }

    @AndroidFindBy(xpath = LocatorProfile.EMPTY_AVATAR_XPATH)
    private WebElement emptyAvatar;

    public ProfileMainScreen clickOnEmptyAvatar() {
        pageFactory(driver);
        clickOnIconAcc();

        try {
            emptyAvatar.click();
            log.info("Нажали на пустой аватар");

        } catch (Exception e) {

        deleteAvatarInProfile();
        emptyAvatar.click();
        }


        return this;
    }

    @AndroidFindBy(xpath = LocatorProfile.BUTTON_LIBRARY_XPATH)
    private WebElement buttonLibrary;
    
    public ProfileMainScreen choiceAvatarSource() {
        pageFactory(driver);

        waitUntilElementIsVisible(buttonLibrary);
        buttonLibrary.click();
        log.info("Нажали на кнопку 'Выбрать из библиотеки");

        return this;
    }

    @AndroidFindBy(xpath = LocatorProfile.PHOTO_SELECTION_XPATH)
    private WebElement photoSelection;

    @AndroidFindBy(xpath = LocatorProfile.AVATAR_XPATH)
    private WebElement avatar;

    public ProfileMainScreen selectPhotoInPhone()  {
        pageFactory(driver);

        waitUntilElementIsVisible(photoSelection);
        photoSelection.click();
        log.info("Выбрали аватарку");

        waitUntilElementIsVisible(avatar);
        Assert.assertTrue(avatar.isDisplayed());
        log.info("Аватарка добавлен в профиль");

        return this;
    }

    @AndroidFindBy(xpath = LocatorProfile.BUTTON_DELETE_AVATAR_XPATH)
    private WebElement deleteAvatar;

    @AndroidFindBy(xpath = LocatorProfile.BUTTON_DELETE_AVATAR_IN_MODAL_WINDOW)
    private WebElement deleteAvatarInModalWindow;

    public void deleteAvatarInProfile (){
        avatar.click();
        log.info("нажали на фото");

        waitUntilElementIsVisible(deleteAvatar);
        deleteAvatar.click();
        log.info("Нажали на кнопку 'Удалить изображение'");

        waitUntilElementIsVisible(deleteAvatarInModalWindow);
        deleteAvatarInModalWindow.click();
        log.info("Нажали на кнопку 'Удалить'");

        Assert.assertTrue(emptyAvatar.isDisplayed());
        log.info("Аватарка удалена, отображается заглушка");

    }
}
