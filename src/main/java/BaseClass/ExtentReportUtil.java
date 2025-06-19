package BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExtentReportUtil  extends  BaseClass
{

    private static ExtentReports extent;
    private static  final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void initReports(String reportPath) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public static void startTest(String testName) {
        test.set(extent.createTest(testName));
    }

    public static void logInfo(String message) {
        test.get().info(message);
    }

    public static void logPass(String message) {
        test.get().pass(message);
    }

    public static void logFail(String message) {
        test.get().fail(message);
    }

    public static void logFailWithScreenshot(String message) {
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) threadDriver.get()).getScreenshotAs(OutputType.BASE64);
        test.get().fail(message,  MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }

    public static void endTest() {
        extent.flush();
    }

    private static String captureScreenshot() {
        // Implement screenshot capture logic here
        // For example, using threadDriver.get() to get the current driver
        WebDriver driver = threadDriver.get();
        // Capture and return screenshot path
        return "path/to/screenshot.png";
    }
}
