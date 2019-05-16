package ro.nila.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPageLocators {

    @FindBy(css = "div button")
    public WebElement deleteUserButton;
}
