package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LeavesPage {
    WebDriver driver;

    public LeavesPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy (linkText = "Leaves Request")
    public WebElement leaveRequestButton;

    @FindBy (xpath = "(//div[@class='fc-bg'])[5]//td[5]")
    public WebElement july31;

    @FindBy (xpath = "//div[@class='o_form_sheet_bg']")
    public WebElement leavesRequestMenu;

    @FindBy (xpath = "//div[@class='o_main_content']")
    public WebElement calendar;

    @FindBy (xpath = "//input[@id='o_field_input_26']")
    public WebElement july31DateInput;

    @FindBy(xpath = "//div[1]/div[2]/div[1]/div[1]/div/span")
    public WebElement addSearchFilter;

    @FindBy(xpath = "//div[3]/div[1]/div[1]/button")
    public WebElement filterButton;

    @FindBy(xpath = "//div[1]/div[3]/div[1]/div[1]//li[2]/a")
    public WebElement approvedLeavesFilter;

    @FindBy(xpath = "//div[1]/div[2]/div[1]/div[1]/div")
    public WebElement searchButton;

    @FindBy (css = ".btn.btn-primary.btn-sm.o_list_button_add")
    public  WebElement createVerification;

    @FindBy(xpath = "//div[2]/div[1]/ol/li")
    public WebElement leavesSummaryText;

    @FindBy (xpath = "/html/body/div[1]/div[1]/div[1]/div[12]/ul/li[3]/a/span")
    public WebElement allocationButton;

    @FindBy (xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy(xpath = "//input[@class='o_field_char o_field_widget o_input']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//input[@class='o_input ui-autocomplete-input']")
    public WebElement leaveTypeInput;

    @FindBy (xpath = "//input[@class='o_field_float o_field_number o_field_widget o_input oe_inline']")
    public WebElement daysNumInput;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm o_form_button_cancel']")
    public WebElement discardButton;

    @FindBy(xpath = "//*[@id=\"modal_36\"]/div/div/div[3]/button[1]/span")
    public WebElement okButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/p")
    public WebElement messageText;

    @FindBy(xpath = "//div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[12]/a")
    public WebElement currentYearFilter;
}
