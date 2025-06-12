package BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {
    static BrowserManager bgm = new BrowserManager();
    protected  static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
    @BeforeClass
    public void setUp() {

        ExtentReportUtil.initReports("test-output/extent-report.html");
        ExtentReportUtil.startTest("MySeleniumTest");
    }
    public static void getDriver()
    {
        try {
            threadDriver.get();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void selectBrowser(String browserName)
    {
        WebDriver driver;

        switch(browserName.toLowerCase()) {
            case "chrome":
                driver = bgm.getchromeDriver();
                break;

            case "edge":
                driver = bgm.getedgeDriver();
                break;

            case "firefox":
                driver = bgm.getfirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }

        // Set it in ThreadLocal
        threadDriver.set(driver);

        // Now it's safe to use .get()
        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    public static void waitTime()
    {
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    public static void clickTheElement(By locator)
    {
        WebDriverWait wait = new WebDriverWait(threadDriver.get(), Duration.ofSeconds(10));

        WebElement element = threadDriver.get().findElement(locator);

        String buttonText = null;

        try {
            wait.until(ExpectedConditions.visibilityOf(element)).click();
            buttonText = element.getText().trim();
            ExtentReportUtil.logPass("Clicked on the '" + buttonText + "' button.");
        } catch (Exception e) {

            ExtentReportUtil.logFailWithScreenshot("Failed to click on element: " + locator);
        }

    }


    public static void enterInput(By locator , String input)
    {
        WebDriverWait wait = new WebDriverWait(threadDriver.get(), Duration.ofSeconds(10));

        WebElement element = threadDriver.get().findElement(locator);

        String FieldName = null;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(input);
            FieldName= element.getText();
            ExtentReportUtil.logPass("Enter text into the '" + FieldName );
        } catch (Exception e) {

            ExtentReportUtil.logFailWithScreenshot("Failed to Enter text into the field for this locator: " + locator);
            e.printStackTrace();
        }
    }
    public static String getTitle()

    {
        String title = threadDriver.get().getTitle();

        return title;
    }



    public static boolean isDisplayed(By locator)
    {
        try {
            WebElement element = threadDriver.get().findElement(locator);
            WebDriverWait wait = new WebDriverWait(threadDriver.get(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
    @AfterClass
    public static void closeTheBrowser()
    {
        ExtentReportUtil.endTest();
        if(threadDriver.get()!=null)
        {
            threadDriver.get().quit();
        }
    }
}
