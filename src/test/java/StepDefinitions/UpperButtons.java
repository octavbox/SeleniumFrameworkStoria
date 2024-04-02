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
    @When("the user clicks on De Inchiriat dropdown button")
    public void the_user_clicks_on_de_inchiriat_dropdown_button() {
        mainPage.pressDeInchiriat();
    }
    @And("the user clicks the {string} button NBSP")
    public void the_user_clicks_the_button_NBSP(String button) {
        mainPage.pressUpperButtonsItem_NBSP(button);
    }
    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String blogPost) {
        mainPage.pressUpperButtonsItem_Space(blogPost);
    }
    @Then("the blog post title contains {string}")
    public void the_blog_post_title_contains(String blogPost) {
        String pageTitle = driver.getTitle();
        String modifiedBlogPost = StrTools.removeDiacriticsFromAll(blogPost);
        System.out.println(pageTitle + " / " + modifiedBlogPost);
        Assert.assertTrue(pageTitle.contains(modifiedBlogPost));
    }

}
