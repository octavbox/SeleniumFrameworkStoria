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
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

import java.util.concurrent.TimeUnit;

public class Hooks {
    /* Before each scenario execution,the StepDefinition and Hooks classes are instantiated,
    The Webdriver instance in the Hooks class is set to static so that the Hooks instance in the StepDefiniton constructor
    will receive the same WebDriver instance that was created in the Hooks class. */
    static WebDriver driver;
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

        switch (config.getProperty("browser")){
            case "chrome":
                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"C:/Users/oboca/IdeaProjects/Storia2/target/Logs/chromedriver.log");
                chromeOptions = new ChromeOptions();
                if(incognito) chromeOptions.addArguments("--incognito");
                if(headless) chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                System.out.println("Session ID: " + ((ChromeDriver) driver).getSessionId().toString());
                break;

            case "firefox":
                firefoxProfile = new FirefoxProfile();
                firefoxOptions = new FirefoxOptions();

                if(incognito) {
                    firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
                    firefoxOptions.addArguments("--private");
                }
                if(headless) firefoxOptions.addArguments("--headless");

                firefoxOptions.setProfile(firefoxProfile);
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("Session ID: " + ((FirefoxDriver) driver).getSessionId().toString());
                break;

            case "edge":
                edgeOptions = new EdgeOptions();
                if(incognito) edgeOptions.addArguments("--inprivate");
                if(headless) edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                System.out.println("Session ID: " + ((EdgeDriver) driver).getSessionId().toString());
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        driver.get("https://www.storia.ro");

        startPage = new StartPage(driver);
        startPage.pressAccept();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
