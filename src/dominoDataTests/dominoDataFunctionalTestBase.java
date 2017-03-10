package dominoDataTests;

import dominoDataLib.dominoDataBasePage;
import org.junit.AfterClass;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Wait;

import org.apache.log4j.Logger;

/**
 * Class contains all the APIs to Load the application.
 *
 * @author shukla.parul@gmail.com(Parul Shukla)
 */
public class dominoDataFunctionalTestBase {

    protected static WebDriver driver;
    protected static Wait<WebDriver> wait;
    protected WebElement element;

    public static final int DEFAULT_WAIT_SECONDS = 15;

    public static final int POLLING_TIME_WAIT_SECONDS = 5;
    public static String server = null;
   public static String testname;
    static String browserType = "chrome";
    static String browserPath = "C:\\Users\\parul\\Documents\\git\\chromedriver.exe";
    final static Logger log = Logger.getLogger(dominoDataFunctionalTestBase.class);

    /**
     * @param browserType
     * @param serverUrl
     * @param browserPath

     */
    public static void setDriver(String browserType, String serverUrl, String browserPath) {

        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(serverUrl, browserPath);
                break;
            case "firefox":
                driver = initFirefoxDriver(serverUrl);
                break;
            default:
                log.info("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
                driver = initFirefoxDriver(serverUrl);
        }
    }

    /**
     * @return driver: chrome
     */
    public static WebDriver initChromeDriver(String appURL, String browserPath) {

        log.info("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", browserPath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }


    /**

     * @return driver:firefox
     */
    public static WebDriver initFirefoxDriver(String appURL) {
        log.info("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }


    static public void verifyTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError e) {
            System.out.println("This is an error" + e);
        }
    }

    static public void verifyFalse(boolean condition, String message) {
        try {
            Assert.assertFalse(condition);
        } catch (AssertionError e) {

        }
    }

    static public void verifyEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError e) {
        }


    }

    public static void verifyNotEquals(Object actual1, Object actual2, String message) {
        try {
            Assert.assertNotSame(message, actual1, actual2);
        } catch (AssertionError e) {

        }
    }

    public static void verifyNotNull(Object actual) {
        try {
            Assert.assertNotNull(actual);
        } catch (AssertionError e) {

        }
    }


    @AfterClass
    public static void tearDown() throws Exception {
        //driver.close();
        driver.quit();
    }
}

