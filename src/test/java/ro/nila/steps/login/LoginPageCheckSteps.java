package ro.nila.steps.login;

import cucumber.api.java.en.Then;
import ro.nila.steps.StepsDependencies;

public class LoginPageCheckSteps extends StepsDependencies {

    @Then("^user validate the Login Page$")
    public void user_validate_the_Login_Page() {
        loginPage.verifyUserIsOnLoginPage();
    }


    @Then("^user verify all elements from Login Page$")
    public void user_verify_all_elements_from_Login_Page() {
        loginPage.verifyElementsFromLoginPage();
    }


}
