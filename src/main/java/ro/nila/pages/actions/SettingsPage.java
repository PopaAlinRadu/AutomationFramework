package ro.nila.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import ro.nila.base.Page;
import ro.nila.pages.locators.SettingsPageLocators;
import ro.nila.pages.text.SettingsPageText;

import static ro.nila.utilities.Utilities.getValue;

public class SettingsPage extends Page {

    private static final String SETTINGS_PAGE_URL = getValue("txt.application.settings");
    private static SettingsPageLocators settingsPageLocators;

    public SettingsPage() {
        settingsPageLocators = new SettingsPageLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getWebDriver(), AJAX_TIME_OUT);
        PageFactory.initElements(factory, settingsPageLocators);
    }

    public void verifyUserIsOnSettingsPage(){
        commonActions.validateElementPresent(settingsPageLocators.deleteUserButton);
        commonActions.validateUrl(SETTINGS_PAGE_URL);
    }

    public void deleteAccount(){
        commonActions.click(settingsPageLocators.deleteUserButton);
    }

    public void verifyElementsFromSettingsPage(){
        commonActions.validateText(settingsPageLocators.deleteUserButton, SettingsPageText.DELETE_USER);
        //  TODO: add mode checks as the page evolve
    }


}
