package StepDefinitions;

import UtilityClasses.Hooks;
import UtilityClasses.StrTools;
import WebPages.MainPage;
import WebPages.RoRezultatePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class UpperButtons {
    WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(UpperButtons.class);
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
    public void the_blog_post_title_contains(String testTitle) {
        String pageTitle = driver.getTitle();
        try {
            logger.info(pageTitle + " / " + testTitle);
            Assert.assertTrue(pageTitle.contains(testTitle));
        } catch (AssertionError e) {
            logger.info("Removing diacritics from both expected and actual titles.");

            String modifiedTestTitle = StrTools.removeDiacriticsFromAll(testTitle);
            String modifiedPageTitle = StrTools.removeDiacriticsFromAll(pageTitle);
            logger.info(modifiedPageTitle + " / " + modifiedTestTitle);

            Assert.assertTrue(modifiedPageTitle.contains(modifiedTestTitle));
        }
    }
}
