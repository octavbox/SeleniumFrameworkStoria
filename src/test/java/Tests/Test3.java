package Tests;

import Configuration.Config;
import WebPages.LoginPagePF;
import WebPages.MainPagePF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Test3 {
    WebDriver driver;
    MainPagePF mainPage;
    LoginPagePF loginPage;
    Properties properties;
    Config props = new Config(properties);


    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.storia.ro");

        System.out.println("Session ID: " + ((FirefoxDriver) driver).getSessionId().toString());
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        mainPage = new MainPagePF(driver);
        mainPage.pressAccept();
    }

    @AfterClass
    public void tearDown() {
            driver.quit();
    }

    @Test(priority = 2)
    public void allButtons() {
        mainPage.pressDeVanzare();
        mainPage.pressDeInchiriat();
        mainPage.pressAnsambluRez();
        mainPage.pressCompanii();
        mainPage.pressFinantare();
        Assert.assertTrue(driver.getTitle().contains("Simulare credit ipotecar"));
    }

    @Test(priority = 1)
    public void login() {
        mainPage.pressContulMeu();
        loginPage = new LoginPagePF(driver);
        loginPage.enterEmail(props.getProperty("username"));
        loginPage.enterPassword(props.getProperty("password"));
        loginPage.pressEye();
        loginPage.pressEye();
        loginPage.pressEye();
        loginPage.pressAutentificareButton();
        Assert.assertEquals(driver.getTitle(),"Intră în cont");
    }

//(threadPoolSize = 4, invocationCount = 4, timeOut = 1000)
    @Test(priority = 0)
    public void search(){
        mainPage.enterCategory("Garsoniere");
        mainPage.enterSellOrRent("De vânzare");
        mainPage.enterLocationOption("Brasov");
        mainPage.pressSearchButton();
    }
}
