package ro.nila.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ro.nila.container.ContainerContext;

import java.io.IOException;

import static ro.nila.base.Page.closeDriver;
import static ro.nila.base.Page.quitDriver;
import static ro.nila.utilities.Utilities.addScreenshotOnFail;

public class BaseSteps extends StepsDependencies {

    private ContainerContext containerContext;

    public BaseSteps(ContainerContext containerContext) {
        this.containerContext = containerContext;
    }

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Pages init config started");

        page = containerContext.getPage();
        homePage = containerContext.getHomePage();
        loginPage = containerContext.getLoginPage();
        registrationPage = containerContext.getRegistrationPage();
        recipePage = containerContext.getRecipePage();
        settingsPage = containerContext.getSettingsPage();

        account = containerContext.getAccount();
        scenarioName = scenario.getName().toLowerCase();

        System.out.println("Pages init config passed");
        System.out.println("Starting Scenario: " + scenarioName);
    }

    @Given("^user have a valid account$")
    public void have_a_valid_account() {
        account.createUsername();
    }

    @Then("^delete account$")
    public void delete_account() {
        account.deleteUsername();
    }

    @And("^user perform login$")
    public void user_perform_login() {
        loginPage.performLogin(account.getEmail(), account.getPassword());
    }

    @Given("^user navigate to application url$")
    public void user_navigate_to_application_url() {
        page.goToAppUrl();
    }

    @When("^user validates the homepage page$")
    public void user_validates_the_Home_Page() {
        homePage.verifyUserIsOnHomePage();
    }

    @When("^user verify all elements from TopNavigation after login$")
    public void user_verify_all_elements_from_TopNavigation_after_login() {
        page.navigate().verifyElementsAfterLogin();
    }

    @Then("^user verify all elements from TopNavigation before login$")
    public void user_verify_all_elements_from_TopNavigation_before_login() {
        page.navigate().verifyElementsBeforeLogin();
    }

    @And("^user Log Out$")
    public void user_Log_Out() {
        page.navigate().logout();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            try {
                addScreenshotOnFail();
            } catch (NullPointerException npe) {
                System.out.println("Failed Single Scenario. Extent Report is null");
                quitDriver();
            }
        } else {
            System.out.println(scenario.getStatus());
            quitDriver();
        }
        System.out.println("Ended Scenario: " + scenarioName);
    }
}
