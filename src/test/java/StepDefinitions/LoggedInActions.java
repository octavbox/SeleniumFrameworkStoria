package StepDefinitions;

import Configuration.Config;
import UtilityClasses.Hooks;
import WebPages.LoginPagePF;
import WebPages.MainPagePF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;


public class LoggedInActions {
    WebDriver driver;
    MainPagePF mainPage;
    LoginPagePF loginPage;
    Properties properties;
    Config props = new Config(properties);
    Hooks hooks;

    public LoggedInActions() {
        hooks = new Hooks();
        driver = hooks.getDriver();
        mainPage = new MainPagePF(driver);
        loginPage = new LoginPagePF(driver);
    }

    //<Background>
    @Given("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {
        mainPage.pressContulMeu();
        loginPage.enterEmail(props.getProperty("username"));
        loginPage.enterPassword(props.getProperty("password"));
        loginPage.pressAutentificareButton();
        Assert.assertEquals(driver.getTitle(), "Intră în cont");
        Thread.sleep(1000);
    }
    //</Background>

    @When("the user clicks on User Menu button")
    public void the_user_clicks_on_User_Menu_button() {
        mainPage.pressUserMenu();
    }
    @And("the user clicks on Logout button")
    public void the_user_clicks_on_Logout_button() throws InterruptedException {
        mainPage.pressLogout();
        Thread.sleep(3000);
    }
    @Then("the user should be logged out")
    public void the_user_should_be_logged_out() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".edaxo2a3 > a:nth-child(1) > span:nth-child(2)")).isDisplayed());
    }
    @And("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        Assert.assertEquals(driver.getTitle(), "Storia.ro - anunțuri imobiliare pentru apartamente, case, terenuri");
    }
}
