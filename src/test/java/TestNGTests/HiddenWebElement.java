package TestNGTests;


import WebPages.MainPage;
import WebPages.RoLoginPage;
import WebPages.StartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HiddenWebElement {
    static WebDriver driver;
    static MainPage mainPage;
    static StartPage startPage;
    static RoLoginPage loginPage;

    public static void main(String[] args) {
        heart();
    }


    public static void findHidden(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.storia.ro");
        mainPage = new MainPage(driver);
        startPage.pressAccept();
        driver.findElement(By.cssSelector("[data-cy='search-form--field--transaction']")).click();
        String text = driver.getPageSource().toString();
        System.out.println(text);
    }
    public static void webElementProperty(){
        //String property = (String) js.executeScript("return window.getComputedStyle(arguments[0]).background", element);
        //String property = (String) js.executeScript("return window.getComputedStyle(arguments[0]).getPropertyValue('background')", element);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.storia.ro");
        mainPage = new MainPage(driver);
        startPage.pressAccept();
        WebElement element = driver.findElement(By.id("search-form-submit"));

        // Get the JavaScript executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript to get computed styles of the element
        String property = (String) js.executeScript("return window.getComputedStyle(arguments[0]).getPropertyValue('background')", element);

        // Print the color
        System.out.println(property);

        // Close the browser
        driver.quit();
    }

    public static void heart() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.storia.ro");

        mainPage = new MainPage(driver);
        startPage.pressAccept();
        mainPage.pressContulMeu();

        loginPage = new RoLoginPage(driver);
        loginPage.enterEmail("octavian.testwork@gmail.com");
        loginPage.enterPassword("Qwerty11!");
        loginPage.pressAutentificareButton();

        mainPage.pressSearchButton();
        List<WebElement> elements = driver.findElements(By.cssSelector("[data-cy='listing-subscribe-button.subscribe']"));
        elements.get(1).click();


    }

}
