package WebPages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.storia.ro/ro/login
public class RoLoginPage {
    WebDriver driver;

    public RoLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //________________________________________________TAB AUTENTIFICARE_______________________________________________________
    @FindBy(xpath = "//div/div[1]/header/button[1]")
    private WebElement btn_autentificareTab;
    @FindBy(id = "username")
    private WebElement txt_emailField;
    @Getter
    @FindBy(xpath = "//fieldset/div[1]/div[2]")
    private WebElement fix_emailFieldErrorMessage;
    @FindBy(id = "password")
    private WebElement txt_passField;
    @Getter
    @FindBy(xpath = "//fieldset/div[2]/div[2]")
    private WebElement fix_passFieldErrorMessage;
    @FindBy(xpath = "//fieldset/div[2]/div/div/button/span/span")
    private WebElement btn_hiddenEye;
    @FindBy(xpath = "//a[@href=\"/ro/login/reset\"]")
    private WebElement btn_forgotPassword;
    @FindBy(xpath = "//button[@type=\"submit\"]")
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
    public String getPasswordHiddenStatus(){
        return txt_passField.getAttribute("type");
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
