package ro.nila.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import ro.nila.base.Page;
import ro.nila.pages.locators.LoginPageLocators;
import ro.nila.pages.text.LoginPageText;

import static ro.nila.utilities.Utilities.getValue;

public class LoginPage extends Page {

    private static final  String LOGIN_PAGE_URL = getValue("txt.application.login");
    private static LoginPageLocators loginPageLocators;

    public LoginPage() {
        loginPageLocators = new LoginPageLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getWebDriver(), AJAX_TIME_OUT);
        PageFactory.initElements(factory, loginPageLocators);
    }

    public void verifyUserIsOnLoginPage() {
        commonActions.validateElementPresent(loginPageLocators.loginFormTitle);
        commonActions.validateUrl(LOGIN_PAGE_URL);
    }

    public void enterUsername(String username) {
        commonActions.type(loginPageLocators.mailInputField, username);
    }

    public void enterPassword(String password) {
        commonActions.type(loginPageLocators.passwordInputField, password);
    }

    public void clickLoginButton() {
        commonActions.click(loginPageLocators.signUpButton);
    }

    public void verifyElementsFromLoginPage(){
        commonActions.validateElementPresent(loginPageLocators.loginFormTitle);
        commonActions.validateText(loginPageLocators.loginFormTitle,
                LoginPageText.formTitle);
        commonActions.validateElementPresent(loginPageLocators.mailFieldText);
        commonActions.validateText(loginPageLocators.mailFieldText,
                LoginPageText.mailText);
        commonActions.validateElementPresent(loginPageLocators.mailInputField);
        commonActions.validateElementPresent(loginPageLocators.passwordFieldText);
        commonActions.validateText(loginPageLocators.passwordFieldText,
                LoginPageText.passwordText);
        commonActions.validateElementPresent(loginPageLocators.passwordInputField);
        commonActions.validateElementPresent(loginPageLocators.signUpButton);
        commonActions.validateText(loginPageLocators.signUpButton,
                LoginPageText.signInButtonText);
    }

    public void performLogin(String username, String password) {
        commonActions.type(loginPageLocators.mailInputField,username);
        commonActions.type(loginPageLocators.passwordInputField, password);
        commonActions.click(loginPageLocators.signUpButton);
    }

    public void verifyFailLogin() {
        commonActions.validateElementPresent(loginPageLocators.failedLogin);
        commonActions.validateText(loginPageLocators.failedLogin, LoginPageText.failedLoginText);
    }
}
