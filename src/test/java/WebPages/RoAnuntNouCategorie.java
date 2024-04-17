package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoAnuntNouCategorie {
    WebDriver driver;
    public RoAnuntNouCategorie(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //___________________________________________VOI VINDE / VOI INCHIRIA_______________________________________________
    final String bothButtonsXpath = "//div[@data-testid=\"category-type-radio-input\"]";
    @FindBy(xpath = bothButtonsXpath + "/label[1]")
    private WebElement btn_voiVinde;
    @FindBy(xpath = bothButtonsXpath + "/label[2]")
    private WebElement btn_voiInchiria;
    public void pressVoiVinde(){
        btn_voiVinde.click();
    }
    public void pressVoiInchiria(){
        btn_voiInchiria.click();
    }
    //___________________________________________TIP PROPROIETATE_______________________________________________
    @FindBy(xpath = "//button[@data-testid=\"posting-form-button\"]")
    private WebElement btn_continua;
    public void pressContinua(){
        btn_continua.click();
    }

    final String gridVoiVindeXpath = "//div[@data-testid=\"category-grid-input\"]";
    @FindBy(xpath = gridVoiVindeXpath + "/label")
    private WebElement btn_apartamente;
    public void pressApartamente(){
        btn_apartamente.click();
    }

}
