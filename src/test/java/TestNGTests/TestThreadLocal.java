package TestNGTests;

import Configuration.Config;
import WebPages.MainPage;
import WebPages.RoLoginPage;
import WebPages.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class TestThreadLocal {
    private final ThreadLocal<WebDriver> TLDriver = new ThreadLocal<>();

    MainPage mainPage;
    StartPage startPage;
    RoLoginPage loginPage;
    Properties properties;
    Config props = new Config(properties);


    @BeforeMethod
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private");

        TLDriver.set(new FirefoxDriver(options));
        WebDriver driver = TLDriver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.findElement(By.id("startPrivateBrowsing")).click();
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = TLDriver.get();
        if (driver != null) {
            driver.quit();
        }
    }

    @org.testng.annotations.Test
    public void allButtons() {
        WebDriver driver = TLDriver.get();
        driver.get("https://www.storia.ro");

        System.out.println("Session ID: " + ((FirefoxDriver) driver).getSessionId().toString());
        System.out.println("Thread ID: " + Thread.currentThread().getId());

        mainPage = new MainPage(driver);
        startPage.pressAccept();
        mainPage.pressDeVanzare();
        mainPage.pressDeInchiriat();
        mainPage.pressAnsambluRez();
        mainPage.pressCompanii();
        mainPage.pressFinantare();
        Assert.assertTrue(driver.getTitle().contains("Simulare credit ipotecar"));

        System.out.println("Test1 finished...");

    }

    @org.testng.annotations.Test
    public void login() {
        WebDriver driver = TLDriver.get();
        driver.get("https://www.storia.ro");

        System.out.println("Session ID: " + ((FirefoxDriver) driver).getSessionId().toString());
        System.out.println("Thread ID: " + Thread.currentThread().getId());

        mainPage = new MainPage(driver);
        startPage.pressAccept();
        mainPage.pressContulMeu();

        loginPage = new RoLoginPage(driver);
        loginPage.enterEmail(props.getProperty("username"));
        loginPage.enterPassword(props.getProperty("password"));
        loginPage.pressEye();
        loginPage.pressEye();
        loginPage.pressEye();
        loginPage.pressAutentificareButton();
        Assert.assertEquals(driver.getTitle(),"Intră în cont");
        System.out.println("Test2 finished...");
    }
//(threadPoolSize = 4, invocationCount = 4, timeOut = 1000)
    @Test
    public void search(){
        WebDriver driver = TLDriver.get();
        driver.get("https://www.storia.ro");

        System.out.println("Session ID: " + ((FirefoxDriver) driver).getSessionId().toString());
        System.out.println("Thread ID: " + Thread.currentThread().getId());

        mainPage = new MainPage(driver);
        startPage.pressAccept();

        mainPage.enterCategory("Garsoniere");
        mainPage.enterSellOrRent("De vânzare");
        mainPage.enterLocationOption("Brasov");
        mainPage.pressSearchButton();
        Assert.fail();
    }
}
