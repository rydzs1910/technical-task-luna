package engine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseEngine
{
    private static WebDriver webDriver;
    private static Logger log = LoggerFactory.getLogger(BaseEngine.class);

    public static WebDriver getWebDriver()
    {
        if(webDriver == null)
        {
            setWebDriver();
        }
        return webDriver;
    }

    private static void setWebDriver()
    {
        String browser = System.getProperty("browser", "firefox");
        switch (browser)
        {
            case "chrome":
                webDriver = initChromeDriver();
                break;
            case "firefox":
                webDriver = initFirefoxDriver();
                break;
            default:
                throw new WebDriverException("Browser " + browser + " no supported.");
        }
    }
        private static WebDriver initFirefoxDriver()
        {
            System.setProperty("webdriver.gecko.driver","src/main/resources/" + System.getProperty("driver", "geckodriver.exe"));
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            System.out.println("Launching Firefox browser..");
            webDriver = new FirefoxDriver();
            return webDriver;
        }
        private static WebDriver initChromeDriver()
        {
            System.out.println("Launching google chrome with new profile..");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/"
                    + System.getProperty("driver", "chromedriver.exe"));
            webDriver = new ChromeDriver();
            return webDriver;
        }

}
