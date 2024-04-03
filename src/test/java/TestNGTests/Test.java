//package TestNGTests;
//
//import Configuration.Config;
//import WebPages.MainPage;
//import WebPages.RoLoginPage;
//import WebPages.StartPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//public class Test {
//    WebDriver driver;
//    MainPage mainPage;
//    StartPage startPage;
//    RoLoginPage loginPage;
//    Config props = new Config();
//
//    @BeforeClass
//    public void setUp() {
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.storia.ro");
//
//        System.out.println("Session ID: " + ((FirefoxDriver) driver).getSessionId().toString());
//        System.out.println("Thread ID: " + Thread.currentThread().getId());
//        mainPage = new MainPage(driver);
//        startPage.pressAccept();
//    }
//
//    @AfterClass
//    public void tearDown() {
//            driver.quit();
//    }
//
//   @org.testng.annotations.Test
//    public void allButtons() {
//        mainPage.pressDeVanzare();
//        mainPage.pressDeInchiriat();
//        mainPage.pressAnsambluRez();
//        mainPage.pressCompanii();
//        mainPage.pressFinantare();
//        Assert.assertTrue(driver.getTitle().contains("Simulare credit ipotecar"));
//    }
//
//    @org.testng.annotations.Test(priority = 1)
//    public void login() {
//        mainPage.pressContulMeu();
//        loginPage = new RoLoginPage(driver);
//        loginPage.enterEmail(props.getProperty("username"));
//        loginPage.enterPassword(props.getProperty("password"));
//        loginPage.pressEye();
//        loginPage.pressEye();
//        loginPage.pressEye();
//        loginPage.pressAutentificareButton();
//        Assert.assertEquals(driver.getTitle(),"Intră în cont");
//    }
//
////(threadPoolSize = 4, invocationCount = 4, timeOut = 1000)
//    @org.testng.annotations.Test(priority = 0)
//    public void search(){
//        mainPage.enterCategory("Garsoniere");
//        mainPage.enterSellOrRent("De vânzare");
//        mainPage.enterLocationOption("Brasov");
//        mainPage.pressSearchButton();
//    }
//}
