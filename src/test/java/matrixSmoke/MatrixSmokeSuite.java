package matrixSmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Ignore;
import pages.HomePage;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeavesPage;
import utilities.Driver;
import utilities.TestBase;

public class MatrixSmokeSuite extends TestBase {
    @Ignore
    @Test
    public void checkIfCalendarIsDisplayed() {

        HomePage homePage = new HomePage();
        homePage.leavesButton.click();

        LeavesPage leaves = new LeavesPage();
        leaves.leaveRequestButton.click();

        Assert.assertTrue(leaves.calendar.isDisplayed(), "Calendar is not displayed");

    }

    @Ignore
    @Test
    public void createLeaveThroughCalendar() {
        HomePage homePage = new HomePage();

        homePage.leavesButton.click();

        LeavesPage leaves = new LeavesPage();
        leaves.leaveRequestButton.click();
        leaves.july31.click();

        Assert.assertTrue(leaves.july31DateInput.getAttribute("value").contains("07/31/2019"), "Leaves date verification failed");
        Assert.assertTrue(leaves.leavesRequestMenu.isDisplayed(), "Leaves request menu verification failed");

    }
//
    @Test
    public void SaveButton() {
        HomePage homePage = new HomePage();
        homePage.leavesButton.click();
        LeavesPage leaves = new LeavesPage();
        leaves.leaveRequestButton.click();
        WebElement date = Driver.getDriver().findElement(By.xpath("//tbody/tr/td[6]"));
        date.click();
        WebElement description = Driver.getDriver().findElement(By.xpath("//" +
                "td[@style='width: 100%;']//input[@name='name']"));
        description.sendKeys("vacation");
        WebElement leaveType = Driver.getDriver().findElement(By.xpath("(//" +
                "div[@class='o_input_dropdown']//input[@class='o_input ui-autocomplete-input'])[1]"));
        leaveType.click();
        //        Select select = new Select(leaveType);
//        select.selectByIndex(3);
        WebElement leaveTypeDetails = Driver.getDriver().findElement(By.xpath("(//span[@role=\"status\"]//div[@style='display: none;'])[5]"));
        leaveTypeDetails.click();
        WebElement durationFrom = Driver.getDriver().findElement(By.name("date_from"));
        Select select1 = new Select(durationFrom);
        select1.selectByIndex(3);
        WebElement durationTo = Driver.getDriver().findElement(By.name("date_to"));
        Select select2 = new Select(durationTo);
        select2.selectByIndex(5);
        WebElement numberOfDays = Driver.getDriver().findElement(By.name("number_of_days_temp"));
        numberOfDays.sendKeys("15");
        WebElement saveButton = Driver.getDriver().findElement(By.linkText("Save"));
        saveButton.click();
        WebElement errorMessage = Driver.getDriver().findElement(By.linkText(" - Validation Error"));

        Assert.assertTrue(errorMessage.isDisplayed(), "Validation Error message is not displayed");
    }


    @Test
    public void DiscardButton() {
        HomePage homePage = new HomePage();

        homePage.leavesButton.click();

        LeavesPage leaves = new LeavesPage();
        leaves.leaveRequestButton.click();


        WebElement date = Driver.getDriver().findElement(By.xpath("//tbody/tr/td[6]"));
        date.click();

        WebElement description = Driver.getDriver().findElement(By.xpath("//td[@style='width: 100%;']//input[@name='name']"));
        description.sendKeys("vacation");
        WebElement leaveTypeDetails = Driver.getDriver().findElement(By.xpath("(//span[@role=\"status\"]//div[@style='display: none;'])[5]"));
        leaveTypeDetails.click();
        Select select = new Select(leaveTypeDetails);
        select.selectByVisibleText("Compensatory Days");

        WebElement durationFrom = Driver.getDriver().findElement(By.name("date_from"));
        Select select1 = new Select(durationFrom);
        select1.selectByIndex(3);

        WebElement durationTo = Driver.getDriver().findElement(By.name("date_to"));
        Select select2 = new Select(durationTo);
        select2.selectByIndex(5);

        WebElement numberOfDays = Driver.getDriver().findElement(By.name("number_of_days_temp"));
        numberOfDays.sendKeys("15");

        WebElement discardButton = Driver.getDriver().findElement(By.linkText("Discard"));
        discardButton.click();

        WebElement warningMessage = Driver.getDriver().findElement(By.xpath("//h4[@class='modal-title']"));

        Assert.assertTrue(warningMessage.isDisplayed(), "Warning message is not displayed");


    }

    @Test
    public void LeaveRequestSearchButton() {
        HomePage homePage = new HomePage();

        homePage.leavesButton.click();

        LeavesPage leaves = new LeavesPage();
        leaves.leaveRequestButton.click();

        WebElement searchButton = Driver.getDriver().findElement(By.className("o_searchview_input"));
        searchButton.sendKeys("James Bond");

        WebElement calendar = Driver.getDriver().findElement(By.className("o_calendar_container"));

        Assert.assertTrue(calendar.isDisplayed(), "Calendar is not displayed");


    }


}









