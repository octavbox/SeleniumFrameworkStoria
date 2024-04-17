package StepDefinitions;

import Configuration.Config;
import UtilityClasses.Hooks;
import UtilityClasses.MyRobot;
import WebPages.MainPage;
import WebPages.RoAnuntNouCategorie;
import WebPages.VanzareApartamentAnuntNou;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.testng.Assert;

public class AddNewListing {
    WebDriver driver;
    Logger logger;
    MainPage mainpage;
    RoAnuntNouCategorie roAnuntNouCategorie;
    VanzareApartamentAnuntNou vanzareApartamentAnuntNou;
    Actions actions;
    String firstPhotoPath = Config.projectPath + "\\src\\test\\resources\\Photos\\cats.jpg";
    String secondPhotoPath = Config.projectPath + "\\src\\test\\resources\\Photos\\dog.jpg";
    public AddNewListing(){
        driver = Hooks.getDriver();
        mainpage = new MainPage(driver);
        roAnuntNouCategorie = new RoAnuntNouCategorie(driver);
        vanzareApartamentAnuntNou = new VanzareApartamentAnuntNou(driver);
        actions = new Actions(driver);
    }
    @When("the user clicks the Adauga Anunt button")
    public void the_user_clicks_the_adauga_anunt_button() {
        mainpage.pressAdaugaAnunt();
    }
    @Then("the Adauga Anunt page appears")
    public void the_adauga_anunt_page_appears() {
        Assert.assertEquals(driver.getTitle(), "Postare anunț");
    }
    @When("the user clicks the Voi Vinde button")
    public void the_user_clicks_the_voi_vinde_button() {
        roAnuntNouCategorie.pressVoiVinde();
    }
    @When("the user clicks on the Apartaments rectangle")
    public void the_user_clicks_on_the_apartaments_rectangle() {
        roAnuntNouCategorie.pressApartamente();
    }
    @When("the user clicks on the Continua button")
    public void the_user_clicks_on_the_continua_button() throws InterruptedException {
        roAnuntNouCategorie.pressContinua();
    }
    @Then("the Adaugare Descriere page appears")
    public void the_vanzare_apartamente_page_appears() {
        Assert.assertEquals(driver.getTitle(), "Adaugare descriere");
    }
    @When("the user uploads a file to upload space number {string}")
    public void the_user_uploads_a_file_to_upload_space_number(String string) {
        vanzareApartamentAnuntNou.pressUploadButtonAt(string);
    }
    @When("the user enters {string} and presses Open in the pop-up page")
    public void the_user_enters_path_and_presses_open_in_the_pop_up_page(String path) throws InterruptedException {
        Thread.sleep(1000);
        MyRobot.enterPath(Config.projectPath + path);
        MyRobot.pressENTER();
    }
    @Then("the uploaded files are visible in the upload spaces")
    public void the_uploaded_files_are_visible_in_the_upload_spaces() {

    }
    @When("the user switches the position of the uploaded files")
    public void the_user_switches_the_position_of_the_uploaded_files() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the uploaded photos positions are switched")
    public void the_uploaded_photos_positions_are_switched() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
