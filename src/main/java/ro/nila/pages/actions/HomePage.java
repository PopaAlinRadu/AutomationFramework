package ro.nila.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import ro.nila.base.Page;
import ro.nila.pages.locators.HomePageLocators;

import static ro.nila.utilities.Utilities.getValue;

public class HomePage extends Page {

    private static final String HOME_PAGE_URL = getValue("txt.application.home");
    private static HomePageLocators home;

    public HomePage() {
        home = new HomePageLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getWebDriver(),AJAX_TIME_OUT);
        PageFactory.initElements(factory, home);
    }

    public void verifyUserIsOnHomePage(){
        commonActions.validateElementPresent(home.welcomeMessage);
        commonActions.validateUrl(HOME_PAGE_URL);
    }
}
