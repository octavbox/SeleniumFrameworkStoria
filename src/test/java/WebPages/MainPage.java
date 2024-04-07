package WebPages;

import UtilityClasses.StrTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://www.storia.ro/

public class MainPage {
    WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(MainPage.class);
    WebElement selectedUpperButton;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ________________________________________________UPPER BUTTONS_______________________________________________________
    @FindBy(xpath = "//a[@aria-label=\"Mergi la pagina principală\"]")
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

    public void pressLogo() {
        btn_logo.click();
    }

    public void pressUpperButton(String dropDownName) {
        switch (dropDownName) {
            case "De Vanzare" -> {
                logger.debug("Selected 'De Vanzare'.");
                selectedUpperButton = btn_deVanzare;
                btn_deVanzare.click();
            }
            case "De Inchiriat" -> {
                logger.debug("Selected 'De Inchiriat'.");
                selectedUpperButton = btn_deInchiriat;
                btn_deInchiriat.click();
            }
            case "Ansambluri Rezidentiale" -> {
                logger.debug("Selected 'Ansambluri Rezidentiale'.");
                selectedUpperButton = btn_ansambluriRezidentiale;
                btn_ansambluriRezidentiale.click();
            }
            case "Companii" -> {
                logger.debug("Selected 'Companii'.");
                selectedUpperButton = btn_companii;
                btn_companii.click();
            }
        }
    }

    public void pressItemOfUpperButtons(String item) {
        try {
            String xpath = String.format(".//a[contains(text(),'%s')]", item);
            selectedUpperButton.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            logger.info("First try failed. Replacing spaces with NBSP...");

            String modifiedItem = StrTools.replaceSpaceWithNBSP(item);
            String xpath = String.format(".//a[contains(text(),'%s')]", modifiedItem);
            selectedUpperButton.findElement(By.xpath(xpath)).click();
        }
    }

    public void pressCreditare() {
        btn_creditare.click();
    }


    //________________________________________________LOGGED IN BUTTONS (UPPER RIGHT)_______________________________________________________

    @FindBy(xpath = "//div[2]/a[@data-cy=\"navbar-my-account-button\"]") //element not interactable without div[2]
    private WebElement btn_contulMeu;

    final String userMenuXpath = "//div[2]/div/a[@data-cy=\"nav-user-menu.username\"]";
    @FindBy(xpath = userMenuXpath)
    private WebElement drp_userMenu;
    @FindBy(xpath = userMenuXpath + "/following-sibling::ul/li[5]/a")
    private WebElement btn_logout;

    final String favouritesXpath = "//div[2]/div/a/div[@data-testid=\"menu-icon-with-notifications\"]";
    @FindBy(xpath = favouritesXpath)
    private WebElement drp_favourites;
    @FindBy(xpath = favouritesXpath + "/parent::a/parent::div/ul/li/a")
    private WebElement btn_anunturi;
    @FindBy(xpath = favouritesXpath + "/parent::a/parent::div/ul/li/a/span")
    private WebElement fix_anunturiCounter;

    public void pressContulMeu() {
        btn_contulMeu.click();
    }

    public void pressFavourites() {
        drp_favourites.click();
    }

    public void pressAnunturi() {
        btn_anunturi.click();
    }

    public int getAnunturiCounter() {
        return Integer.parseInt(fix_anunturiCounter.getText());
    }

    public void pressLogout() {
        btn_logout.click();
    }

    public void pressUserMenu() {
        drp_userMenu.click();
    }


    //________________________________________________SEARCH FIELDS_______________________________________________________
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
