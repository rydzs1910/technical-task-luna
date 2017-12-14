import engine.BaseEngine;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AkamaiBaseTestCase
{
    private static WebDriver webDriver;
    final static Properties properties = new Properties();

    private static WebDriver initFirefoxDriverAndNavigateToURL(String url) throws Exception
    {
        webDriver = BaseEngine.getWebDriver();
        webDriver.manage().window().maximize();
        System.out.println("Navigate to " + url);
        webDriver.navigate().to(url);
        return webDriver;
    }

    @BeforeClass
    public static void initializeAkamaiBaseTestCase() throws Exception
    {
        initFirefoxDriverAndNavigateToURL(System.getProperty("url","https://akamaijobs.referrals.selectminds.com/"));
    }

    @AfterClass
    public static void tearDown()
    {
        if(webDriver != null)
        webDriver.quit();
    }
}
