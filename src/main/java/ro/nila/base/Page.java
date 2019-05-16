package ro.nila.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import ro.nila.configuration.ConfigManager;
import ro.nila.configuration.TextManager;
import ro.nila.configuration.WebDriverManager;
import ro.nila.pages.common.CommonActions;

import java.io.IOException;
import java.util.Properties;

import static ro.nila.utilities.Utilities.getValue;

public class Page {

    protected static final int AJAX_TIME_OUT = 10;
    private static final String APP_URL = "txt.application.url";

    private static WebDriver webDriver;
    private static Wait<WebDriver> driverWait;
    private static Properties configProperties, textProperties;

    protected static CommonActions commonActions;
    private static TopNavigation topNavigation;

    public static Page initConfiguration() throws IOException {
        //  init configManager
        ConfigManager.loadConfiguration();
        configProperties = ConfigManager.getConfigProperties();
        //  init txtManager
        TextManager.loadConfiguration();
        textProperties = TextManager.getTextProperties();
        //  init webDriverManager
        WebDriverManager.loadWebDriver();
        //  init WebDriver
        webDriver = WebDriverManager.getWebDriver();
        //  init WebDriverWait
        driverWait = WebDriverManager.getDriverWait();

        commonActions = new CommonActions(driverWait);
        topNavigation = new TopNavigation(webDriver, commonActions);

        return new Page();
    }

    public void goToAppUrl() {
        webDriver.get(getValue(APP_URL));
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }

    public static Properties getConfigProperties() {
        return configProperties;
    }

    public static Properties getTextProperties() {
        return textProperties;
    }

    public TopNavigation navigate() {
        return topNavigation;
    }

    //----------Close WebDriver---------//
    public static void closeDriver() {
        if (webDriver != null) {
            webDriver.close();
            System.out.println("Close driver");
        }
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            System.out.println("Quit driver");
        }
    }

}
