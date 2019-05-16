package ro.nila.runner;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty",
        "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"},
        features = "src/test/java/ro/nila/features",
        glue = {"ro/nila/steps"},
        monochrome = true)
public class TestRunner {

    @BeforeClass
    public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("target/extent-report/extent-report.html");
    }

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/test/resources/extent-config.xml");
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Windows 10." + " 64 Bit");
        Reporter.setSystemInfo("Selenium", "3.4.0");
        Reporter.setSystemInfo("Maven", "3.5.4");
        Reporter.setSystemInfo("Java Version", "1.8.0_201");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
