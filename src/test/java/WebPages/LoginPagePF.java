package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.storia.ro/ro/login
public class LoginPagePF {
    WebDriver driver;

    public LoginPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //TAB AUTENTIFICARE
    @FindBy(className = "css-1smixo2")
    private WebElement btn_autentificareTab;
    @FindBy(id = "username")
    private WebElement txt_emailField;
    @FindBy(id = "password")
    private WebElement txt_passField;
    @FindBy(className = "css-1f5c5n2")
    private WebElement btn_hiddenEye;
    @FindBy(className = "css-1ie4kvm")
    private WebElement btn_forgotPassword;
    @FindBy(className = "e1msim225")
    private WebElement btn_autentificareButton;

    public void pressAutentificareTab() {
        btn_autentificareTab.click();
    }

    public void enterEmail(String email) {
        txt_emailField.sendKeys(email);
    }

    public void enterPassword(String pass) {
        txt_passField.sendKeys(pass);
    }

    public void pressEye() {
        btn_hiddenEye.click();
    }

    public void pressForgotPassword() {
        btn_forgotPassword.click();
    }

    public void pressAutentificareButton() {
        btn_autentificareButton.click();
    }

}
