package StepDefinitions;

import Configuration.Config;
import UtilityClasses.Hooks;
import UtilityClasses.StrTools;
import WebPages.MainPage;
import WebPages.RoRezultatePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


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
    @And("the user clicks the {string} button of De Vanzare")
    public void the_user_clicks_the_button_of_de_vanzare(String button) {
        mainPage.pressButtonOfDeVanzare(button);
    }
    @When("the user clicks on De Inchiriat dropdown button")
    public void the_user_clicks_on_de_inchiriat_dropdown_button() {
        mainPage.pressDeInchiriat();
    }
    @And("the user clicks the {string} button of De Inchiriat")
    public void the_user_clicks_the_button_of_de_inchiriat(String button) {
        mainPage.pressButtonOfDeInchiriat(button);
    }

    @Then("the blog post title contains {string}")
    public void the_blog_post_title_contains(String blogPost) {
        String pageTitle = driver.getTitle();
        String modifiedBlogPost = StrTools.removeDiacriticsFromAll(blogPost);
        System.out.println(pageTitle + " / " + modifiedBlogPost);
        Assert.assertTrue(pageTitle.contains(modifiedBlogPost));
    }

}
