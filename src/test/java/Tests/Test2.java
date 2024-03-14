package Tests;

import Configuration.Config;
import WebPages.LoginPagePF;
import WebPages.MainPagePF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Test2 {
    WebDriver driver;
    MainPagePF mainPage;
    LoginPagePF loginPage;
    Properties properties;
    Config props = new Config(properties);


    @BeforeMethod
    public void setUp() {

        System.out.println("Thread ID: " + Thread.currentThread().getId());
//        driver.findElement(By.id("startPrivateBrowsing")).click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void allButtons() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.storia.ro");

        System.out.println("Session ID: " + ((FirefoxDriver) driver).getSessionId().toString());

        mainPage = new MainPagePF(driver);
        mainPage.pressAccept();
        mainPage.pressDeVanzare();
        mainPage.pressDeInchiriat();
        mainPage.pressAnsambluRez();
        mainPage.pressCompanii();
        mainPage.pressFinantare();
        Assert.assertTrue(driver.getTitle().contains("Simulare credit ipotecar"));

        System.out.println("Test1 finished...");

    }

    @Test
    public void login() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.storia.ro");

        System.out.println("Session ID: " + ((ChromeDriver) driver).getSessionId().toString());

        mainPage = new MainPagePF(driver);
        mainPage.pressAccept();
        mainPage.pressContulMeu();

        loginPage = new LoginPagePF(driver);
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
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.storia.ro");

        System.out.println("Session ID: " + ((EdgeDriver) driver).getSessionId().toString());

        mainPage = new MainPagePF(driver);
        mainPage.pressAccept();

        mainPage.enterCategory("Garsoniere");
        mainPage.enterSellOrRent("De vânzare");
        mainPage.enterLocationOption("Brasov");
        mainPage.pressSearchButton();
    }
}
