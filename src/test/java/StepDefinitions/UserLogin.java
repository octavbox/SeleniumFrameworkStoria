package StepDefinitions;

import Configuration.Config;
import UtilityClasses.Hooks;
import WebPages.MainPage;
import WebPages.RoLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;


public class UserLogin {
    WebDriver driver;
    MainPage mainPage;
    RoLoginPage loginPage;
    Properties properties;
    Config props = new Config(properties);

    public UserLogin() {
        driver = Hooks.getDriver();
        mainPage = new MainPage(driver);
        loginPage = new RoLoginPage(driver);
    }


    //<Background>
    @Given("Storia main page is visible")
    public void storia_main_page_is_visible() {
        Assert.assertEquals(driver.getTitle(), "Storia.ro - anunțuri imobiliare pentru apartamente, case, terenuri");
    }
    //</Background>

    @When("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        mainPage.pressContulMeu();
    }

    @And("the user enters valid login credentials")
    public void the_user_enters_valid_login_credentials() {
        loginPage.enterEmail(props.getProperty("username"));
        loginPage.enterPassword(props.getProperty("password"));
    }

    @And("the user submits the login form")
    public void the_user_submits_the_login_form() {
        loginPage.pressAutentificareButton();
    }

    @Then("the user should be logged in")
    public void the_user_should_be_logged_in() {
        Assert.assertEquals(driver.getTitle(), "Intră în cont");
    }

    @When("the user enters invalid login credentials")
    public void the_user_enters_invalid_login_credentials() {
        loginPage.enterEmail(props.getProperty("wrongUsername"));
        loginPage.enterPassword(props.getProperty("wrongPassword"));
    }

    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message() {
        Assert.assertTrue(driver.findElement(By.id("form-error-banner")).isDisplayed());
    }

    @And("the user should remain on the login page")
    public void the_user_should_remain_on_the_login_page() {
        Assert.assertEquals(driver.getTitle(), "Intră în cont");
    }
}
