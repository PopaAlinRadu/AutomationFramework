package ro.nila.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecipePageLocators {

    @FindBy(css = "app-recipe-start h3")
    public WebElement pageTitle;

    @FindBy(xpath = "//button[contains(text(),'New Recipe')]")
    public WebElement newRecipeButton;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    public WebElement saveButton;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    public WebElement cancelButton;

    @FindBy(xpath = "//label[contains(text(),'Name')]")
    public WebElement nameLabel;
}
