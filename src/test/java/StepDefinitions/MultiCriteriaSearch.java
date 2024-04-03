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

public class MultiCriteriaSearch {

    WebDriver driver;
    MainPage mainPage;
    RoRezultatePage searchResultsPage;
    int counter1;

    public MultiCriteriaSearch() {
        driver = Hooks.getDriver();
        mainPage = new MainPage(driver);
        searchResultsPage = new RoRezultatePage(driver);
    }

    @When("the user selects {string} from the property type dropdown")
    public void the_user_selects_from_the_property_type_dropdown(String propertyType) {
        mainPage.enterCategory(propertyType);
    }

    @And("the user selects {string} from the transaction type dropdown")
    public void the_user_selects_from_the_transaction_type_dropdown(String transactionType) {
        mainPage.enterSellOrRent(transactionType);
    }

    @When("the user selects {string} from the radius dropdown")
    public void the_user_selects_from_the_radius_dropdown(String radius) {
        mainPage.enterRadius(radius);
    }

    @And("the user selects {string} from the city dropdown")
    public void the_user_selects_from_the_city_dropdown(String city) {
        if (city.isBlank()) {
            System.out.println("No city selected");
        } else {
            mainPage.enterLocationOption(city);
        }
    }

    @When("the user enters {string} in the lower end price field")
    public void the_user_enters_in_the_lower_end_price_field(String priceMin) {
        mainPage.enterPriceMin(priceMin);
    }

    @When("the user enters {string} in the higher end price field")
    public void the_user_enters_in_the_higher_end_price_field(String priceMax) {
        mainPage.enterPriceMax(priceMax);
    }

    @When("the user enters {string} in the lower end surface field")
    public void the_user_enters_in_the_lower_end_surface_field(String areaMin) {
        mainPage.enterAreaMin(areaMin);
    }

    @When("the user enters {string} in the higher end surface field")
    public void the_user_enters_in_the_higher_end_surface_field(String areaMax) {
        mainPage.enterAreaMax(areaMax);
    }

    @Then("the search button contains a count of the results")
    public void the_search_button_contains_a_count_of_the_results() throws InterruptedException {
        Thread.sleep(1000);
        counter1 = mainPage.getCounterFromSearchButton();
    }

    @When("the user clicks the Search button")
    public void the_user_clicks_the_Search_button() {
        mainPage.pressSearchButton();
    }

    @Then("the search results page title contains {string} {string} {string}")
    public void the_search_results_title_page_contains(String propertyType, String transactionType, String city) {
        String pageTitle = driver.getTitle();
        String modifiedTransactionType = StrTools.makeFirstCharLowerCase(transactionType);
        String modifiedCity = StrTools.removeDiacriticsFromAll(city);

        String concatTitle = propertyType + " " + modifiedTransactionType + ": " + modifiedCity;
        System.out.println("Web page title: " + pageTitle + " // " + concatTitle);

        Assert.assertTrue(pageTitle.contains(propertyType));
        Assert.assertTrue(pageTitle.contains(modifiedTransactionType));
        Assert.assertTrue(pageTitle.contains(modifiedCity));
    }

    @And("the search results match the search criteria {string} {string} {string}")
    public void the_search_results_match_the_search_criteria(String propertyType, String transactionType, String city) {
        String pageHeader = searchResultsPage.getSearchListingHeading();
        String modifiedTransactionType = StrTools.makeFirstCharLowerCase(transactionType);
        String modifiedCity = StrTools.removeDiacriticsFromAll(city);

        String concatTitle = propertyType + " " + modifiedTransactionType + ": " + modifiedCity;
        System.out.println(pageHeader + " / " + concatTitle);

        Assert.assertTrue(pageHeader.contains(propertyType));
        Assert.assertTrue(pageHeader.contains(modifiedTransactionType));
        Assert.assertTrue(pageHeader.contains(modifiedCity));
    }

    @And("the counter number on the search button matches the number in the search results")
    public void the_counter_number_on_the_search_button_matches_the_number_in_the_search_results() {
        Assert.assertEquals(counter1, searchResultsPage.getCounterFromAnunturi());
        System.out.println("Search counter: " + counter1);
    }
}
