package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VanzareApartamentAnuntNou {

    WebDriver driver;
    public VanzareApartamentAnuntNou(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul/li[@id=\"add-file-1\"]")
    private WebElement btn_uploadButton_1;
    @FindBy(xpath = "//ul/li[@id=\"add-file-2\"]")
    private WebElement btn_uploadButton_2;
    @FindBy(xpath = "//ul/li[@id=\"add-file-3\"]")
    private WebElement btn_uploadButton_3;
    @FindBy(xpath = "//ul/li[@id=\"add-file-4\"]")
    private WebElement btn_uploadButton_4;
    @FindBy(xpath = "//ul/li[@id=\"add-file-19\"]")
    private WebElement btn_uploadButton_19;

    public void pressUploadButtonAt(String index){
        switch (index) {
            case "1" -> btn_uploadButton_1.click();
            case "2" -> btn_uploadButton_2.click();
            case "3" -> btn_uploadButton_3.click();
            case "4" -> btn_uploadButton_4.click();
            case "19" -> btn_uploadButton_19.click();
        }
    }




}
