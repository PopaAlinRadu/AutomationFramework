package ro.nila.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import ro.nila.pages.common.CommonActions;
import ro.nila.pages.locators.TopNavigationLocators;
import ro.nila.pages.text.TopNavigationText;

public class TopNavigation {

    private static TopNavigationLocators topNavigationLocators;
    private CommonActions commonActions;

    TopNavigation(WebDriver driver, CommonActions commonActions) {
        topNavigationLocators = new TopNavigationLocators();
        this.commonActions = commonActions;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Page.AJAX_TIME_OUT);
        PageFactory.initElements(factory, topNavigationLocators);
    }

    public void goToLogin() {
        commonActions.click(topNavigationLocators.loginButton);
    }

    public void goToHomePage() {
        commonActions.click(topNavigationLocators.homeButton);
    }

    public void goToRegistration() {
        commonActions.click(topNavigationLocators.registerButton);
    }

    public void goToSettings(){
        commonActions.click(topNavigationLocators.manageButton);
        commonActions.click(topNavigationLocators.settingsButton);
    }

    public void verifyElementsBeforeLogin() {
        commonActions.validateText(topNavigationLocators.homeButton, TopNavigationText.HOME);
        commonActions.validateText(topNavigationLocators.loginButton, TopNavigationText.LOGIN);
        commonActions.validateText(topNavigationLocators.registerButton, TopNavigationText.REGISTER);
    }

    public void verifyElementsAfterLogin(){
        commonActions.validateText(topNavigationLocators.homeButton, TopNavigationText.HOME);
        commonActions.validateText(topNavigationLocators.recipeButton, TopNavigationText.RECIPES);
        commonActions.validateText(topNavigationLocators.shoppingListButton, TopNavigationText.SHOPPING_LIST);
        commonActions.validateText(topNavigationLocators.logoutButton, TopNavigationText.LOGOUT);
        commonActions.validateText(topNavigationLocators.manageButton, TopNavigationText.MANAGE);

        commonActions.click(topNavigationLocators.manageButton);

        commonActions.validateText(topNavigationLocators.saveDataButton, TopNavigationText.SAVE_DATA);
        commonActions.validateText(topNavigationLocators.fetchDataButton, TopNavigationText.FETCH_DATA);
        commonActions.validateText(topNavigationLocators.settingsButton, TopNavigationText.SETTINGS);

        commonActions.click(topNavigationLocators.manageButton);
    }

    public void logout() {
        commonActions.click(topNavigationLocators.logoutButton);
    }
}
