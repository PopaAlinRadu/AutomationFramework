package ro.nila.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import ro.nila.base.Page;
import ro.nila.pages.locators.RegistrationPageLocators;
import ro.nila.pages.text.RegistrationPageText;

import static ro.nila.utilities.Utilities.getValue;

public class RegistrationPage extends Page {

    private static final String REGISTRATION_PAGE_URL = getValue("txt.application.registration");
    private static RegistrationPageLocators registrationPageLocators;

    public RegistrationPage() {
        registrationPageLocators = new RegistrationPageLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getWebDriver(), AJAX_TIME_OUT);
        PageFactory.initElements(factory, registrationPageLocators);
    }

    public void verifyElementsFromRegistrationPage() {
        commonActions.validateElementPresent(registrationPageLocators.loginFormTitle);
        commonActions.validateText(registrationPageLocators.loginFormTitle,
                RegistrationPageText.FORM_TITLE);
        commonActions.validateElementPresent(registrationPageLocators.mailFieldText);
        commonActions.validateText(registrationPageLocators.mailFieldText,
                RegistrationPageText.MAIL_TEXT);
        commonActions.validateElementPresent(registrationPageLocators.mailInputField);
        commonActions.validateElementPresent(registrationPageLocators.passwordFieldText);
        commonActions.validateText(registrationPageLocators.passwordFieldText,
                RegistrationPageText.PASSWORD_TEXT);
        commonActions.validateElementPresent(registrationPageLocators.passwordInputField);
        commonActions.validateElementPresent(registrationPageLocators.signUpButton);
        commonActions.validateText(registrationPageLocators.signUpButton,
                RegistrationPageText.SIGN_UP_BUTTON_TEXT);
    }

    public void verifyUserIsOnRegistrationPage() {
        commonActions.validateElementPresent(registrationPageLocators.loginFormTitle);
        commonActions.validateUrl(REGISTRATION_PAGE_URL);
    }

    public void clickSignUpButton() {
        commonActions.click(registrationPageLocators.signUpButton);
    }

    public void enterUsername(String username) {
        commonActions.type(registrationPageLocators.mailInputField, username);
    }


    public void enterPassword(String password) {
        commonActions.type(registrationPageLocators.passwordInputField, password);
    }

    public void performRegistration(String username, String password) {
        commonActions.type(registrationPageLocators.mailInputField, username);
        commonActions.type(registrationPageLocators.passwordInputField, password);
        commonActions.click(registrationPageLocators.signUpButton);
    }

    public void verifyFailedRegistration() {
        commonActions.validateElementPresent(registrationPageLocators.failMessage);
        commonActions.validateText(registrationPageLocators.failMessage, RegistrationPageText.FAIL_REGISTRATION_TEXT);
    }

    public void verifySuccessfulRegistration() {
        commonActions.validateElementPresent(registrationPageLocators.successMessage);
        commonActions.validateText(registrationPageLocators.successMessage, RegistrationPageText.SUCCESS_REGISTRATION_TEXT);
    }
}
