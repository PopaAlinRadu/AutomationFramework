package ro.nila.steps.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ro.nila.steps.StepsDependencies;

public class LoginFunctionalitySteps extends StepsDependencies {

    @When("^user go to Login Page$")
    public void user_go_to_Login_Page() {
        page.navigate().goToLogin();
    }

    @Then("^user click on Sign In button$")
    public void user_click_on_Sign_In_button() {
        loginPage.clickLoginButton();
    }

    @And("^user perform login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_perform_login_with_username_and_password(String username, String password) {
        loginPage.performLogin(username, password);
    }

    //  Step that will enter username both for login and registration
    @Then("^user enter \"([^\"]*)\" username$")
    public void user_enter_username(String username) {
        if (scenarioName.contains("registration")) {
            System.out.println("reg: " + username);
            registrationPage.enterUsername(username);
        } else {
            System.out.println("login: " + username);
            loginPage.enterUsername(username);
        }
    }

    //  Step that will enter password both for login and registration
    @And("^user enter \"([^\"]*)\" password$")
    public void user_enter_password(String password) {
        if (scenarioName.contains("registration")) {
            System.out.println("reg: " + password);
            registrationPage.enterPassword(password);
        } else {
            System.out.println("login: " + password);
            loginPage.enterPassword(password);
        }
    }

    //  Step that will check if User logged in successfully or not
    @Then("^user should \"([^\"]*)\" successfully logged in$")
    public void user_should_logged_in(String validLogin) {

        if (validLogin.equals("not")) {
            System.out.println("@Then user should " + validLogin + " successfully logged in");
            loginPage.verifyFailLogin();
        } else {
            System.out.println("@Then user should " + validLogin + " successfully logged in");
            recipePage.verifyUserIsOnRecipePage();
        }
    }
}
