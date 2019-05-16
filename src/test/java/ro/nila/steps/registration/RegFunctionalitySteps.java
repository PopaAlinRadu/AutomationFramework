package ro.nila.steps.registration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import ro.nila.steps.StepsDependencies;
import ro.nila.utilities.Account;

public class RegFunctionalitySteps extends StepsDependencies {

    @Given("^user go to Registration Page$")
    public void user_go_to_Registration_Page() {
        page.navigate().goToRegistration();
    }

    @And("^user click on Sign Up button$")
    public void user_click_on_sign_up_button() {
        registrationPage.clickSignUpButton();
    }

    @And("^user perform registration with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_perform_registration_with_username_and_password(String username, String password) {
        registrationPage.performRegistration(username, password);
    }

    @And("^user should \"([^\"]*)\" successfully register$")
    public void user_should_register(String loginType) {
        if (loginType.equals("not")) {
            registrationPage.verifyFailedRegistration();
        } else {
            registrationPage.verifySuccessfulRegistration();
            //  Delete Account
            Account account = new Account();
            account.setEmail("register@asd.com");
            account.deleteUsername();
        }
    }
}
