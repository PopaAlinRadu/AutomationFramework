package ro.nila.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {

    //---Locators--//
    @FindBy(css ="form h4")
    public WebElement loginFormTitle;

    @FindBy(css = "div:nth-child(2) > label")
    public WebElement mailFieldText;

    @FindBy(css = "#email")
    public WebElement mailInputField;

    @FindBy(css = "div:nth-child(3) > label")
    public WebElement passwordFieldText;

    @FindBy(css = "#password")
    public WebElement passwordInputField;

    @FindBy(css = "form button")
    public WebElement signUpButton;

    @FindBy(xpath = "//div[contains(text(), 'Invalid Credentials')]")
    public WebElement failedLogin;

}
