package ro.nila.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocators {

    @FindBy(css = "li:nth-child(1) a")
    public WebElement loginButton;

    @FindBy(css = ".navbar-header a")
    public WebElement homeButton;

    @FindBy(css = ".active a")
    public WebElement recipeButton;

    @FindBy(css = "ul:nth-child(1) li:nth-child(2) a")
    public WebElement shoppingListButton;

    @FindBy(css = "li:nth-child(2) a")
    public WebElement registerButton;

    @FindBy(css = ".navbar-right > li:nth-child(1) a")
    public WebElement logoutButton;

    @FindBy(xpath = "//a[contains(text(), 'Manage')]")
    public WebElement manageButton;

    @FindBy(xpath = "//a[contains(text(),'Save Data')]")
    public WebElement saveDataButton;

    @FindBy(xpath = "//a[contains(text(),'Fetch Data')]")
    public WebElement fetchDataButton;

    @FindBy(xpath = "//a[contains(text(),'Settings')]")
    public WebElement settingsButton;


}
