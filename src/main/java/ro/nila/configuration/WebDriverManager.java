package ro.nila.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static ro.nila.utilities.Utilities.getValue;

public class WebDriverManager {

    private static WebDriver webDriver;
    private static Wait<WebDriver> driverWait;

    //  Browsers Names
    private static final String CHROME_BROWSER = "chrome";
    private static final String FIREFOX_BROWSER = "firefox";
    //  Driver wait
    private static final String DRIVER_WAIT = "config.driver.wait";
    private static final String DRIVER_POLLING = "config.driver.polling";
    //  Driver path
    private static final String CHROME_DRIVER_PATH = "config.chrome.driver.relative.path";
    private static final String FIREFOX_DRIVER_PATH = "config.firefox.driver.relative.path";
    private static final String ROOT = System.getProperty("user.dir");
    //  Chrome Options
    private static final String CHROME_SIZE = "config.chrome.size";
    private static final String CHROME_INFO_BARS = "config.chrome.info-bars";
    //  Firefox Options
    private static final String FIREFOX_SIZE = "config.chrome.size";
    private static final String FIREFOX_INFO_BARS = "config.chrome.info-bars";
    //  Config Browser Chose
    private static final String CONFIG_BROWSER = "config.browser";


    public static void loadWebDriver() {
        System.out.println("    Loading---> WebDriver");


        String browser = getValue(CONFIG_BROWSER);
        switch (browser) {
            case CHROME_BROWSER:
                System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, ROOT + getValue(CHROME_DRIVER_PATH));
                loadChromeDriver();
                break;
            case FIREFOX_BROWSER:
                System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, ROOT + getValue(FIREFOX_DRIVER_PATH));
                loadFirefoxDriver();
                break;
            default:
                break;
        }

        System.out.println("WebDriver <----Loaded");
    }

    //  load Chrome
    private static void loadChromeDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments(getValue(CHROME_SIZE));
        options.addArguments(getValue(CHROME_INFO_BARS));

        webDriver = new ChromeDriver(options);
        manageDriver();
    }

    //  load Firefox
    private static void loadFirefoxDriver() {
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        manageDriver();
    }

    private static void manageDriver() {
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(Integer.parseInt(getValue(DRIVER_WAIT)), TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(Integer.parseInt(getValue(DRIVER_WAIT)), TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(getValue(DRIVER_WAIT)), TimeUnit.SECONDS);

        driverWait = new FluentWait<>(webDriver)
                .withTimeout(Integer.parseInt(getValue(DRIVER_WAIT)), TimeUnit.SECONDS)
                .pollingEvery(Integer.parseInt(getValue(DRIVER_POLLING)), TimeUnit.SECONDS)
                .withMessage("FluentWait TimeOut after: " + DRIVER_WAIT);
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static Wait<WebDriver> getDriverWait() {
        return driverWait;
    }
}
