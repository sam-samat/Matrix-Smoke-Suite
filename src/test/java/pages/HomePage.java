package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    WebDriver driver;

    public HomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);

    }
    @FindBy (css = "//*[@id='oe_main_menu_navbar']//ul/li[12]")
    public WebElement leavesButton;
}