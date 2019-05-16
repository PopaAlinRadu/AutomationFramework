package ro.nila.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import ro.nila.base.Page;
import ro.nila.pages.locators.RecipePageLocators;
import ro.nila.pages.text.RecipePageText;

import static ro.nila.utilities.Utilities.getValue;

public class RecipePage extends Page {

    private static final String RECIPE_PAGE_URL = getValue("txt.application.recipes");
    private static RecipePageLocators recipePageLocators;

    public RecipePage() {
        recipePageLocators = new RecipePageLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getWebDriver(), AJAX_TIME_OUT);
        PageFactory.initElements(factory, recipePageLocators);
    }

    public void verifyUserIsOnRecipePage() {
        commonActions.validateElementPresent(recipePageLocators.pageTitle);
        commonActions.validateUrl(RECIPE_PAGE_URL);
    }


    public void verifyElementsFromRecipePage() {
        commonActions.validateText(recipePageLocators.newRecipeButton, RecipePageText.NEW_RECIPE_BUTTON);
        //  Click to open the form
        commonActions.click(recipePageLocators.newRecipeButton);
        commonActions.validateText(recipePageLocators.saveButton, RecipePageText.SAVE_BUTTON);
        commonActions.validateText(recipePageLocators.cancelButton, RecipePageText.CANCEL_BUTTON);
        commonActions.validateText(recipePageLocators.nameLabel, RecipePageText.NAME_LABE);
    }
}
