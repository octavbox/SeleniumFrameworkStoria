package WebPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SalvatAnunturiPage {

    //CONSTRUCTOR
    WebDriver driver;
    JavascriptExecutor js;

    public SalvatAnunturiPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll({@FindBy(css = "[data-cy='ad-page-subscribe-button.subscribe']")})
    private List<WebElement> hearts;

    public void pressHeartAt(int index){
        hearts.get(index).click();
    }
    public boolean getHeartStateAt(int index) {
        String subscribedValue = hearts.get(index).getAttribute("data-cy-subscribed");
        boolean isPressed = Boolean.parseBoolean(subscribedValue);
        return isPressed;
    }

}
