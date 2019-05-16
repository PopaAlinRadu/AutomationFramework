package ro.nila.steps.registration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ro.nila.steps.StepsDependencies;

public class RegPageCheckSteps extends StepsDependencies {

    @Given("^user validate the Registration Page$")
    public void user_validate_the_Registration_Page() {
        registrationPage.verifyUserIsOnRegistrationPage();
    }

    @Then("^user verify all elements from Registration Page$")
    public void user_verify_all_elements_from_Registration_Page() {
        registrationPage.verifyElementsFromRegistrationPage();
    }
}
