package ro.nila.utilities;

import com.vimalselvam.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ro.nila.base.Page;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static ro.nila.configuration.WebDriverManager.getWebDriver;

public class Utilities {

    private static Properties textProperties, configProperties;

    public static String getValue(String key) {
        String value;
        if (key.contains("txt")) {
            textProperties = Page.getTextProperties();
            value = textProperties.getProperty(key);
        } else if(key.contains("config")) {
            configProperties = Page.getConfigProperties();
            value = configProperties.getProperty(key);
        } else {
            value = key;
        }
        return value;
    }

    public static void addScreenshotOnFail() throws IOException {
        WebDriver driver = getWebDriver();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenFile = new File(System.getProperty("user.dir") + "/target/extent-report/" + screenshot.getName());
        FileUtils.copyFile(screenshot, screenFile);
        Reporter.addScreenCaptureFromPath(screenshot.getName());
    }
}
