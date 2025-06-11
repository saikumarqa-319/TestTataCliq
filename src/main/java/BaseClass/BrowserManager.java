package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserManager {
    WebDriver driver;

    public  WebDriver getchromeDriver()

    {
        driver = new ChromeDriver();
        VerifyBrowserOS();
        return driver;

    }
    public  WebDriver getedgeDriver()

    {
        driver = new EdgeDriver();
        VerifyBrowserOS();
        return driver;

    }
    public  WebDriver getfirefoxDriver()

    {
        driver = new FirefoxDriver();
        VerifyBrowserOS();
        return driver;

    }

    public WebDriver initBrowser(String browserName)
    {
        switch(browserName.toLowerCase())
        {
            case "chrome":
                getchromeDriver();
                break;

            case "edge":
                getedgeDriver();
                break;

            case "firefox":
                getfirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported" + browserName);
        }
        driver.manage().window().maximize();
        return driver;
    }
    public  void VerifyBrowserOS() {
        org.openqa.selenium.Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = ((org.openqa.selenium.Capabilities) caps).getBrowserName();
        String browserVersion = caps.getBrowserVersion();
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("OS = " + os + ", Browser = " + browserName + " "+ browserVersion);
    }
}
