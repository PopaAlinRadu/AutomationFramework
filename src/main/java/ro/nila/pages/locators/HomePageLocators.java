package ro.nila.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageLocators {

    //  Locators
    @FindBy(css = "div h2")
    public WebElement welcomeMessage;

}
