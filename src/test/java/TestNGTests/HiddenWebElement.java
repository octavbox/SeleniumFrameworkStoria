package TestNGTests;

import WebPages.MainPagePF;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HiddenWebElement {
    static WebDriver driver;
    static MainPagePF mainPage;

    public static void main(String[] args) {
        int x = 10;
        System.out.println(x++);
    }


    public static void findHidden(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.storia.ro");
        mainPage = new MainPagePF(driver);
        mainPage.pressAccept();
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
        mainPage = new MainPagePF(driver);
        mainPage.pressAccept();
        WebElement element = driver.findElement(By.id("search-form-submit"));

        // Get the JavaScript executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript to get computed styles of the element
        String property = (String) js.executeScript("return window.getComputedStyle(arguments[0]).getPropertyValue('font-weight')", element);

        // Print the color
        System.out.println(property);

        // Close the browser
        driver.quit();
    }

}
