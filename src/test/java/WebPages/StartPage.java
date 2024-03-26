package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //INCOGNITO POP-UP
    @FindBy(id = "startPrivateBrowsing")
    private WebElement btn_Private;

    public void pressPrivate() {
        btn_Private.click();
    }


    //CONSENT POP-UP
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement btn_Accept;
    @FindBy(id = "onetrust-pc-btn-handler")
    private WebElement btn_Scopuri;

    public void pressAccept() {
        btn_Accept.click();
    }

    public void pressScopuri() {
        btn_Scopuri.click();
    }




}
