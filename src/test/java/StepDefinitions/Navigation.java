package StepDefinitions;

import Configuration.Config;
import UtilityClasses.Hooks;
import WebPages.MainPage;
import WebPages.RoLoginPage;
import WebPages.RoRezultatePage;
import WebPages.SalvatAnunturiPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Random;

public class Navigation {
    WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(LoggedInActions.class);
    MainPage mainPage;
//    RoLoginPage loginPage;
//    RoRezultatePage roRezultatePage;
//    SalvatAnunturiPage salvatAnunturiPage;
    Actions actions;
    ArrayList<String> tabs;

    public Navigation(){
        driver = Hooks.getDriver();
        actions = new Actions(driver);
        mainPage = new MainPage(driver);
//        loginPage = new RoLoginPage(driver);
//        roRezultatePage = new RoRezultatePage(driver);
//        salvatAnunturiPage = new SalvatAnunturiPage(driver);
    }
    @When("the user returns to the previous page")
    public void the_user_returns_to_the_previous_page() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(1000);
    }
    @When("the user opens a new tab")
    public void the_user_opens_a_new_tab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }
    @When("the user switches to second tab")
    public void the_user_switches_to_second_tab() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
    }
    @When("the user navigates to Storia main page")
    public void the_user_navigates_to_storia_main_page() {
        driver.get("https://www.storia.ro");
    }
    @When("the user switches to first tab")
    public void the_user_switches_to_first_tab() {
        driver.switchTo().window(tabs.get(0)); //switches to new tab
    }
    @When("the user refreshes the page")
    public void the_user_refreshes_the_page() {
        driver.navigate().refresh();
    }
    @When("the Anunturi counter is not visible")
    public void the_anunturi_counter_is_not_visible() {
        Assert.assertEquals(mainPage.getFix_anunturiCounter().size(),0);
    }

}
