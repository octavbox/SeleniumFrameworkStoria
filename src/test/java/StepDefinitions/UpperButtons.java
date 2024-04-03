package StepDefinitions;

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

    public UpperButtons() {
        driver = Hooks.getDriver();
        mainPage = new MainPage(driver);
        roRezultatePage = new RoRezultatePage(driver);
    }

    @When("the user clicks on {string} dropdown from upper buttons")
    public void the_user_clicks_on_dropdown_from_upper_buttons(String dropDownName) {
        mainPage.pressUpperButton(dropDownName);
    }

    @And("the user clicks the {string} item")
    public void the_user_clicks_the_item_of_upper_buttons(String button) {
        mainPage.pressItemOfUpperButtons(button);
    }

    @Then("the webpage title contains {string}")
    public void the_blog_post_title_contains(String blogPost) {
        String pageTitle = driver.getTitle();
        try {
            System.out.println(pageTitle + " / " + blogPost);
            Assert.assertTrue(pageTitle.contains(blogPost));

        } catch (AssertionError e) {
            System.out.println("Removing diacritics...");

            String modifiedBlogPost = StrTools.removeDiacriticsFromAll(blogPost);
            String modifiedPageTitle = StrTools.removeDiacriticsFromAll(pageTitle);
            System.out.println(modifiedPageTitle + " / " + modifiedBlogPost);

            Assert.assertTrue(modifiedPageTitle.contains(modifiedBlogPost));
        }


    }

}
