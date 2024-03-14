package ImportFromSeleniumIDE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// https://www.storia.ro/ro/login
public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //TAB AUTENTIFICARE
    By btn_autentificareTab = By.className("css-1smixo2");
    By txt_emailField = By.id("username");
    By txt_passField = By.id("password");
    By btn_hiddenEye = By.className("css-1f5c5n2");
    By btn_forgotPassword = By.className("css-1ie4kvm");
    By getBtn_autentificareButton = By.className("e1msim225");

    public void pressAutentificareTab() {
        driver.findElement(btn_autentificareTab).click();
    }

    public void enterEmail(String email) {
        driver.findElement(txt_emailField).sendKeys(email);
    }

    public void enterPassword(String pass) {
        driver.findElement(txt_passField).sendKeys(pass);
    }

    public void pressEye() {
        driver.findElement(btn_hiddenEye).click();
    }

    public void pressForgotPassword(){
        driver.findElement(btn_forgotPassword).click();
    }

    public void pressAutentificareButton(){
        driver.findElement(getBtn_autentificareButton).click();
    }

}
