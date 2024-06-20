package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import config.ConfigManager;

public class Hooks {
    private static ExtentReports extent;
    private static ExtentTest test;

    @Before
    public void setUp() {
        if (extent == null) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ConfigManager.getInstance().getProperty("report.path") + "extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        test = extent.createTest("API Test");
    }

    @After
    public void tearDown() {
        extent.flush();
    }

    public static ExtentTest getTest() {
        return test;
    }
}
