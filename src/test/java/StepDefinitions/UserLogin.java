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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class UserLogin {
    WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(UpperButtons.class);
    MainPage mainPage;
    RoLoginPage roLoginPage;

    Config props = new Config();

    public UserLogin() {
        driver = Hooks.getDriver();
        mainPage = new MainPage(driver);
        roLoginPage = new RoLoginPage(driver);
    }

    //<Background>
    @Given("Storia main page is visible")
    public void storia_main_page_is_visible() {
        Assert.assertEquals(driver.getTitle(), "Storia.ro - anunțuri imobiliare pentru apartamente, case, terenuri");
    }
    //</Background>

    @When("the user clicks on the Contul Meu button")
    public void the_user_is_on_the_login_page() {
        mainPage.pressContulMeu();
    }

    @And("the user enters valid login credentials")
    public void the_user_enters_valid_login_credentials() {
        roLoginPage.enterEmail(props.getProperty("username"));
        roLoginPage.enterPassword(props.getProperty("password"));
    }
    @When("the user clicks the Eye button")
    public void the_user_clicks_the_eye_button() {
        roLoginPage.pressEye();

    }
    @Then("the password is hidden")
    public void the_password_is_hidden() {
        Assert.assertEquals("password",roLoginPage.getPasswordHiddenStatus());
    }
    @Then("the password is visible")
    public void the_password_is_visible() {
        Assert.assertEquals("text",roLoginPage.getPasswordHiddenStatus());
    }

    @And("the user clicks the Autentificare button")
    public void the_user_submits_the_login_form() {
        roLoginPage.pressAutentificareButton();
    }

    @Then("the user should be logged in")
    public void the_user_should_be_logged_in() {
        Assert.assertEquals(driver.getTitle(), "Intră în cont");
    }

    @When("the user enters invalid login credentials: {string} and {string}")
    public void the_user_enters_invalid_login_credentials(String email, String password) {
        roLoginPage.enterEmail(email);
        roLoginPage.enterPassword(password);
    }

    @Then("a message appears if email input \\({string}) is blank")
    public void a_message_appears_if_email_input_is_blank(String email) {
        if(email.isBlank())
            Assert.assertTrue(roLoginPage.getFix_emailFieldErrorMessage().isDisplayed(),"Email field is blank.");
    }
    @Then("a message appears if password input \\({string}) is blank")
    public void a_message_appears_if_password_input_is_blank(String password) {
        if(password.isBlank())
            Assert.assertTrue(roLoginPage.getFix_passFieldErrorMessage().isDisplayed(),"Password field is blank.");
    }

    @Then("an error message appears if {string} and {string} are not blank")
    public void an_error_message_appears_if_credentials_are_not_blank(String email, String password) {
        if(!(email.isBlank() || password.isBlank()))
            Assert.assertTrue(driver.findElement(By.id("form-error-banner")).isDisplayed());
    }

    @And("the user should remain on the login page")
    public void the_user_should_remain_on_the_login_page() {
        Assert.assertEquals(driver.getTitle(), "Intră în cont");
    }
}
