package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.storia.ro/
public class MainPagePF {

    //CONSTRUCTOR
    WebDriver driver;

    public MainPagePF(WebDriver driver) {
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

    // TOP ROW BUTTONS
    @FindBy(css = ".css-114aita > img")
    private WebElement btn_logo;
    @FindBy(css = "#sell > span")
    private WebElement btn_deVanzare;
    @FindBy(css = "#rent > span")
    private WebElement btn_deInchiriat;
    @FindBy(css = "#primaryMarket > span")
    private WebElement btn_ansambluRez;
    @FindBy(css = "#companies > span")
    private WebElement btn_companii;
    @FindBy(id = "finance")
    private WebElement btn_finantare;
    @FindBy(css = ".edaxo2a3 > a:nth-child(1) > span:nth-child(2)")
    private WebElement btn_contulMeu;

    public void pressLogo() {
        btn_logo.click();
    }

    public void pressDeVanzare() {
        btn_deVanzare.click();
    }

    public void pressDeInchiriat() {
        btn_deInchiriat.click();
    }

    public void pressAnsambluRez() {
        btn_ansambluRez.click();
    }

    public void pressCompanii() {
        btn_companii.click();
    }

    public void pressFinantare() {
        btn_finantare.click();
    }

    public void pressContulMeu() {
        btn_contulMeu.click();
    }

    //SEARCH FIELDS
    @FindBy(css = "[data-cy='search-form--field--estate']")
    private WebElement drp_category;
    @FindBy(css = "[data-cy='search-form--field--transaction']")
    private WebElement drp_sellOrRent;
    @FindBy(id = "location")
    private WebElement drp_location;
    @FindBy(id = "location-picker-input")
    private WebElement txt_locationField;
    @FindBy(css = "[data-cy='search-form--field--distanceRadius']")
    private WebElement drp_radius;
    @FindBy(id = "priceMin")
    private WebElement txt_priceMin;
    @FindBy(id = "priceMax")
    private WebElement txt_priceMax;
    @FindBy(id = "areaMin")
    private WebElement txt_areaMin;
    @FindBy(id = "areaMax")
    private WebElement txt_areaMax;
    @FindBy(id = "search-form-submit")
    private WebElement btn_searchButton;


    public void enterCategory(String value) {
        drp_category.click();
        driver.findElement(By.xpath(String.format("//div[text()='%s']", value))).click();
    }

    public void enterSellOrRent(String value) {
        drp_sellOrRent.click();
        driver.findElement(By.xpath(String.format("//div[text()='%s']", value))).click();
    }

    public void enterLocationOption(String value) {
        drp_location.click();
        txt_locationField.sendKeys(value);
        driver.findElement(By.xpath(String.format("//strong[text()='%s']", value))).click();
    }

    public void enterRadius(String value) {
        drp_radius.click();
        driver.findElement(By.xpath(String.format("//div[text()='%s']", value))).click();
    }
    public void enterPriceMin(String value){txt_priceMin.sendKeys(value);}
    public void enterPriceMax(String value){txt_priceMax.sendKeys(value);}
    public void enterAreaMin(String value){txt_areaMin.sendKeys(value);}
    public void enterAreaMax(String value){txt_areaMax.sendKeys(value);}
    public void pressSearchButton() {
        btn_searchButton.click();
    }
    public int getCounterFromSearchButton(){
        String text = btn_searchButton.getText().replaceAll("[^0-9]", "");
        int number = Integer.parseInt(text);
        return number;
    }

    //LOGGED IN BUTTONS
    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[2]/div[2]")
    private WebElement btn_userMenu;

    @FindBy(css = ".css-2wtrb3.e167po0p6")
    private WebElement btn_logout;

    public void pressUserMenu(){
        btn_userMenu.click();
    }
    public void pressLogout(){btn_logout.click();}


}
