package UtilityClasses;

import Configuration.Config;
import WebPages.StartPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class Hooks {
    /* Before each scenario execution,the StepDefinition and Hooks classes are instantiated,
    The Webdriver instance in the Hooks class is set to static so that the Hooks instance in the StepDefinition constructor
    will receive the same WebDriver instance that was created in the Hooks class. */
    static WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(Hooks.class);
    StartPage startPage;
    Config config;
    FirefoxOptions firefoxOptions;
    FirefoxProfile firefoxProfile;
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp() {
        config = new Config();
        boolean incognito = Boolean.parseBoolean(config.getProperty("incognito"));
        boolean headless = Boolean.parseBoolean(config.getProperty("headless"));
        boolean driverLogs = Boolean.parseBoolean(config.getProperty("driverLogs"));

        switch (config.getProperty("browser")){
            case "chrome":
                chromeOptions = new ChromeOptions();
                if(driverLogs) {
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, Config.projectPath + "/target/Logs/chromedriver.log");
                }
                if(incognito) chromeOptions.addArguments("--incognito");
                if(headless) chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                logger.info("Opening Chrome browser...");
                logger.debug("Session ID: " + ((ChromeDriver) driver).getSessionId().toString());
                break;

            case "firefox":
                firefoxProfile = new FirefoxProfile();
                firefoxOptions = new FirefoxOptions();
                if(driverLogs) System.out.println("Driver logs for Firefox not yet implemented");
                if(incognito) {
                    firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
                    firefoxOptions.addArguments("--private");
                }
                if(headless) firefoxOptions.addArguments("--headless");

                firefoxOptions.setProfile(firefoxProfile);
                driver = new FirefoxDriver(firefoxOptions);
                logger.info("Opening Firefox browser...");
                logger.debug("Session ID: " + ((FirefoxDriver) driver).getSessionId().toString());
                break;

            case "edge":
                edgeOptions = new EdgeOptions();
                if(driverLogs) System.out.println("Driver logs for Edge not yet implemented");
                if(incognito) edgeOptions.addArguments("--inprivate");
                if(headless) edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                logger.info("Opening Edge browser...");
                logger.debug("Session ID: " + ((EdgeDriver) driver).getSessionId().toString());
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.debug("Thread ID: " + Thread.currentThread().getId());
        driver.get("https://www.storia.ro");

        startPage = new StartPage(driver);
        startPage.pressAccept();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

/*  SLF4J serves as a simple facade or abstraction for various logging frameworks, including Logback.
It provides a common interface for logging operations and allows developers to use SLF4J's API to perform
logging without being tied to a specific logging implementation.

Logback, on the other hand, is one of the logging implementations compatible with SLF4J.
SLF4J acts as an interface to Logback, allowing you to use SLF4J's API for logging operations while
Logback handles the actual logging implementation.

Here's how the relationship works:
1. You include SLF4J as a dependency in your project to provide a common logging interface.
2. You include Logback as a dependency in your project to handle the logging implementation.
3. Your code interacts with SLF4J's API for logging operations (org.slf4j.Logger interface, etc.).
4. At runtime, SLF4J routes the logging calls to the underlying logging implementation, which in this case is Logback.

This setup provides flexibility because if you ever need to switch to a different logging framework (such as Log4j or JUL), you can do so without needing to change your application's logging code. You would only need to swap out the logging implementation (e.g., replace Logback with Log4j) and keep using SLF4J's API for logging operations. */