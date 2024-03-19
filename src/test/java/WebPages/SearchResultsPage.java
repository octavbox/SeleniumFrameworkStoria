package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.storia.ro/rezultate
public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Header zone
    @FindBy(css = ".css-o0w5yo.e1fw9pn56")
    public WebElement tzt_nrAnunturi;

    public int getCounterFromAnunturi() {
        String text = tzt_nrAnunturi.getText().substring(8).replaceAll("[^0-9]","");
        return Integer.parseInt(text);
    }

}
