package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// https://www.storia.ro/rezultate
public class RoRezultatePage {
    WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(RoRezultatePage.class);
    public RoRezultatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //________________________________________________SEARCH RESULTS HEADER_______________________________________________________
    final String searchListingHeadingXpath = "//h1[@data-cy='search-listing.heading']";
    @FindBy(xpath = searchListingHeadingXpath)
    private WebElement fix_searchListingHeading;
    @FindBy(xpath = searchListingHeadingXpath + "/following-sibling::div/div")
    private WebElement fix_nrAnunturi;

    public int getCounterFromAnunturi() {
        String text = fix_nrAnunturi.getText().substring(8).replaceAll("[^0-9]","");
        return Integer.parseInt(text);
    }
    public String getSearchListingHeading(){
        return fix_searchListingHeading.getText();
    }


    //________________________________________________SEARCH RESULTS_______________________________________________________
    @FindAll({@FindBy(css = "[data-cy='listing-subscribe-button.subscribe']")})
    private List<WebElement> hearts;

    public void pressHeartAt(int index){
        hearts.get(index).click();
    }
    public boolean getHeartStateAt(int index){
        String subscribedValue = hearts.get(index).getAttribute("data-cy-subscribed"); //Returns "true" or "false" as strings.
        boolean isPressed = Boolean.parseBoolean(subscribedValue); //Converts strings to boolean value.
        return isPressed;

        /*When you use @FindAll (or similar annotations like @FindBy) to initialize a list of web elements in a page object,
        Selenium locates all matching elements on the web page at that moment and creates references to them.
        These references are maintained throughout the lifetime of the page object.

        However, the actual attributes and properties of the web elements (such as data-cy-subscribed)are not "saved"
        with the list itself. Instead, they are accessed dynamically when you interact with the web elements through WebDriver methods.

        When you call a WebDriver method (such as getAttribute()) on a web element,
        WebDriver dynamically retrieves the current state of that element from the browser's DOM (Document Object Model).
        This means that WebDriver queries the browser to get the most up-to-date attribute values of the element
        at the moment when the method is called.*/
    }

}
