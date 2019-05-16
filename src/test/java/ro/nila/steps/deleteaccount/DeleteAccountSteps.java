package ro.nila.steps.deleteaccount;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ro.nila.steps.StepsDependencies;

public class DeleteAccountSteps extends StepsDependencies {

    @When("^User go to Settings$")
    public void User_go_to_Settings() {
        page.navigate().goToSettings();
    }

    @And("^User validate Settings Page$")
    public void User_validate_Settings_Page() {
        settingsPage.verifyUserIsOnSettingsPage();
        settingsPage.verifyElementsFromSettingsPage();
    }

    @Then("^User Delete Account$")
    public void User_delete_account() {
        settingsPage.deleteAccount();
    }

}


