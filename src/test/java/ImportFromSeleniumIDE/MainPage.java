package ImportFromSeleniumIDE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// https://www.storia.ro/
public class MainPage {
    WebDriver driver;

    //CONSTRUCTOR
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //INCOGNITO POP-UP
    By btn_Private = By.id("startPrivateBrowsing");

    public void pressPrivate() {
        driver.findElement(btn_Private).click();
    }

    //CONSENT POP-UP
    By btn_Accept = By.id("onetrust-accept-btn-handler");
    By btn_Scopuri = By.id("onetrust-pc-btn-handler");

    public void pressAccept() {
        driver.findElement(btn_Accept).click();
    }

    public void pressScopuri() {
        driver.findElement(btn_Scopuri).click();
    }


    // TOP ROW BUTTONS
    By btn_logo = By.cssSelector(".css-114aita > img");
    By btn_deVanzare = By.cssSelector("#sell > span");
    By btn_deInchiriat = By.cssSelector("#rent > span");
    By btn_ansambluRez = By.cssSelector("#primaryMarket > span");
    By btn_companii = By.cssSelector("#companies > span");
    By btn_finantare = By.cssSelector("#finance > span");
    By btn_contulMeu = By.cssSelector(".edaxo2a3 > a:nth-child(1) > span:nth-child(2)");

    public void pressLogo() {
        driver.findElement(btn_logo).click();
    }

    public void pressDeVanzare() {
        driver.findElement(btn_deVanzare).click();
    }

    public void pressDeInchiriat() {
        driver.findElement(btn_deInchiriat).click();
    }

    public void pressAnsambluRez() {
        driver.findElement(btn_ansambluRez).click();
    }

    public void pressCompanii() {
        driver.findElement(btn_companii).click();
    }

    public void pressFinantare() {
        driver.findElement(btn_finantare).click();
    }

    public void pressContulMeu() {
        driver.findElement(btn_contulMeu).click();
    }
}
