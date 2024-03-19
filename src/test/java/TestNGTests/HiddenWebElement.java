package TestNGTests;

import WebPages.MainPagePF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HiddenWebElement {
    static WebDriver driver;
    static MainPagePF mainPage;

    public static void main(String[] args) {
        findHidden();
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

}
