package WebPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class SalvatAnunturiPage {

    WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(SalvatAnunturiPage.class);
    JavascriptExecutor js;

    //CONSTRUCTOR
    public SalvatAnunturiPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "link-SAVED_ADS")
    private WebElement btn_anunturiTab;

    @FindAll({@FindBy(css = "[data-cy='single-saved-ad']")})
    private List<WebElement> list_savedListings;

    @FindAll({@FindBy(css = "[data-cy='ad-page-subscribe-button.subscribe']")})
    private List<WebElement> list_hearts;

    public int getCounterFromAnunturiTab() {
        String text = btn_anunturiTab.getText().replaceAll("[^0-9]", "");
        logger.debug(text);
        return Integer.parseInt(text);
    }

    public WebElement getSavedListingAt(int index){
        return list_savedListings.get(index);
    }
    public int getListCountFromSavedListings(){
        return list_savedListings.size();
    }

    public void pressHeartAt(int index) {
        list_hearts.get(index).click();
    }

    public boolean getHeartStateAt(int index) {
        String subscribedValue = list_hearts.get(index).getAttribute("data-cy-subscribed");
        return Boolean.parseBoolean(subscribedValue);
    }

}
