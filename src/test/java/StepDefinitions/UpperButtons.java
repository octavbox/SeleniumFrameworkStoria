package StepDefinitions;

import Configuration.Config;
import UtilityClasses.Hooks;
import WebPages.MainPage;
import WebPages.RoLoginPage;
import WebPages.RoRezultatePage;
import WebPages.SalvatAnunturiPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Random;


public class UpperButtons {
    WebDriver driver;
    MainPage mainPage;
    RoRezultatePage roRezultatePage;
    Config config = new Config();

    public UpperButtons() {
        driver = Hooks.getDriver();
        mainPage = new MainPage(driver);
        roRezultatePage = new RoRezultatePage(driver);
    }

    @When("the user clicks on De Vanzare dropdown button")
    public void the_user_clicks_on_de_vanzare_dropdown_button() {
        mainPage.pressDeVanzare();
    }
    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String propertyType) {
        mainPage.pressDeVanzareItem(propertyType);
    }
}
