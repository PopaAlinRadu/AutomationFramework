package ro.nila.container;

import ro.nila.base.Page;
import ro.nila.pages.actions.*;
import ro.nila.utilities.Account;

import java.io.IOException;

public class ContainerContext {

    private Page page;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private RecipePage recipePage;
    private SettingsPage settingsPage;

    private Account account;

    public ContainerContext() throws IOException {
        page = Page.initConfiguration();
        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        recipePage = new RecipePage();
        settingsPage = new SettingsPage();
        account =  new Account();
    }

    public Page getPage() {
        return page;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
    }

    public RecipePage getRecipePage() {
        return recipePage;
    }

    public SettingsPage getSettingsPage() {
        return settingsPage;
    }

    public Account getAccount() {
        return account;
    }
}
