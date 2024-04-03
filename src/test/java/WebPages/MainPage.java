package WebPages;

import UtilityClasses.StrTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.storia.ro/

public class MainPage {
    WebDriver driver;
    WebElement selectedUpperButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // TOP ROW BUTTONS
    @FindBy(css = ".css-114aita > img")
    private WebElement btn_logo;
    @FindBy(id = "sell-container")
    private WebElement btn_deVanzare;
    @FindBy(id = "rent-container")
    private WebElement btn_deInchiriat;
    @FindBy(id = "primaryMarket-container")
    private WebElement btn_ansambluriRezidentiale;
    @FindBy(id = "companies-container")
    private WebElement btn_companii;
    @FindBy(id = "finance")
    private WebElement btn_creditare;
    @FindBy(css = ".edaxo2a3 > a:nth-child(1) > span:nth-child(2)")
    private WebElement btn_contulMeu;

    public void pressLogo() {
        btn_logo.click();
    }

    public void pressUpperButton(String dropDownName) {
        switch (dropDownName) {
            case "De Vanzare" -> {
                selectedUpperButton = btn_deVanzare;
                btn_deVanzare.click();
            }
            case "De Inchiriat" -> {
                selectedUpperButton = btn_deInchiriat;
                btn_deInchiriat.click();
            }
            case "Ansambluri Rezidentiale" -> {
                selectedUpperButton = btn_ansambluriRezidentiale;
                btn_ansambluriRezidentiale.click();
            }
            case "Companii" -> {
                selectedUpperButton = btn_companii;
                btn_companii.click();
            }
        }
    }

    public void pressItemOfUpperButtons(String item){
        try{
            String xpath = String.format(".//a[contains(text(),'%s')]", item);
            selectedUpperButton.findElement(By.xpath(xpath)).click();
        }catch (Exception e){
            System.out.println("1st try failed. Replacing spaces with NBSP...");

            String modifiedItem = StrTools.replaceSpaceWithNBSP(item);
            String xpath = String.format(".//a[contains(text(),'%s')]", modifiedItem);
            selectedUpperButton.findElement(By.xpath(xpath)).click();
        }
    }

    public void pressCreditare() {
        btn_creditare.click();
    }

    public void pressContulMeu() {
        btn_contulMeu.click();
    }

    //LOGGED IN BUTTONS (UPPER RIGHT)
    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[2]/div[2]")
    private WebElement drp_userMenu;

    public void pressUserMenu() {
        drp_userMenu.click();
    }

    @FindBy(css = ".css-2wtrb3.e167po0p6")
    private WebElement btn_logout;

    public void pressLogout() {
        btn_logout.click();
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/a/div")
    private WebElement drp_favourites;

    public void pressFavourites() {
        drp_favourites.click();
    }

    @FindBy(css = ".css-1w8zttu.e167po0p4")
    private WebElement btn_anunturi;
    @FindBy(css = ".css-16jlbcj.e167po0p7")
    private WebElement btn_anunturiCounter;

    public void pressAnunturi() {
        btn_anunturi.click();
    }

    public int getAnunturiCounter() {
        return Integer.parseInt(btn_anunturiCounter.getText());
    }


    //SEARCH FIELDS
    @FindBy(css = "[data-cy='search-form--field--estate']")
    private WebElement drp_categoryType;
    @FindBy(css = "[data-cy='search-form--field--transaction']")
    private WebElement drp_transactionType;
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
        drp_categoryType.click();
        driver.findElement(By.xpath(String.format("//div[text()='%s']", value))).click();
    }

    public void enterSellOrRent(String value) {
        drp_transactionType.click();
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

    public void enterPriceMin(String value) {
        txt_priceMin.sendKeys(value);
    }

    public void enterPriceMax(String value) {
        txt_priceMax.sendKeys(value);
    }

    public void enterAreaMin(String value) {
        txt_areaMin.sendKeys(value);
    }

    public void enterAreaMax(String value) {
        txt_areaMax.sendKeys(value);
    }

    public void pressSearchButton() {
        btn_searchButton.click();
    }

    public int getCounterFromSearchButton() {
        String text = btn_searchButton.getText().replaceAll("[^0-9]", "");
        int number = Integer.parseInt(text);
        return number;
    }


}
