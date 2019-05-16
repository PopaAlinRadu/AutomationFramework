package ro.nila.steps.recipe;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ro.nila.steps.StepsDependencies;

public class RecipePageCheckSteps extends StepsDependencies {

    @When("^user validate the Recipe Page$")
    public void user_validate_the_Recipe_Page() {
        recipePage.verifyUserIsOnRecipePage();
    }

    @Then("^user verify all elements from Recipe Page$")
    public void user_verify_all_elements_from_Recipe_Page() {
        recipePage.verifyElementsFromRecipePage();
    }

}
