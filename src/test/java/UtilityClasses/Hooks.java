package UtilityClasses;

import WebPages.MainPagePF;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    //        Before each scenario execution,the StepDefinition and Hooks classes are instantiated,
    //        The Webdriver instance in the Hooks class is set to static so that the Hooks instance in the StepDefiniton constructor
    //        will receive the same WebDriver instance that was created in the Hooks class.
    static WebDriver driver;
    MainPagePF mainPage;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Session ID: " + ((FirefoxDriver) driver).getSessionId().toString());
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        driver.get("https://www.storia.ro");
        mainPage = new MainPagePF(driver);
        mainPage.pressAccept();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
