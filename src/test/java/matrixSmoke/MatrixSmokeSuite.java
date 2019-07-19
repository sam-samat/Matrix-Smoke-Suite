package matrixSmoke;

import pages.HomePage;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeavesPage;
import utilities.Driver;
import utilities.TestBase;

public class MatrixSmokeSuite extends TestBase {

    @Test
    public void checkIfCalendarIsDisplayed(){

        HomePage homePage = new HomePage();
        homePage.leavesButton.click();

        LeavesPage leaves = new LeavesPage();
        leaves.leaveRequestButton.click();

        Assert.assertTrue(leaves.calendar.isDisplayed(),"Calendar is not displayed");

    }

    @Test
    public void createLeaveThroughCalendar(){
        HomePage homePage = new HomePage();

        homePage.leavesButton.click();

        LeavesPage leaves = new LeavesPage();
        leaves.leaveRequestButton.click();
        leaves.july31.click();

        Assert.assertTrue(leaves.july31DateInput.getAttribute("value").contains("07/31/2019"),"Leaves date verification failed");
        Assert.assertTrue(leaves.leavesRequestMenu.isDisplayed(),"Leaves request menu verification failed");
        System.out.println(leaves.july31DateInput.getAttribute("value"));
    }

    @Test
    public void searchFilterByApproved()throws InterruptedException{
        HomePage hp=new HomePage();
        hp.leavesButton.click();

        LeavesPage lp=new LeavesPage();
        lp.addSearchFilter.click();

        lp.filterButton.click();

        lp.approvedLeavesFilter.click();

        String expected="Approved Leaves";
        String actual=lp.searchButton.getText();
        Assert.assertTrue(actual.contains(expected));
        Assert.assertTrue(lp.approvedLeavesFilter.isDisplayed());
    }

@Test
    public void createButtonVerification(){

    HomePage hp=new HomePage();
    hp.leavesButton.click();

    LeavesPage lp=new LeavesPage();

    Assert.assertTrue(lp.leavesSummaryText.isDisplayed());

    lp.createVerification.click();
    String Expected="Create";
    String actual= Driver.getDriver().getTitle();
    Assert.assertTrue(actual.contains(actual));

    }

    @Test
    public void discardAllocationRequest(){
        HomePage homePage = new HomePage();
        homePage.leavesButton.click();

        LeavesPage leavesPage = new LeavesPage();
        leavesPage.allocationButton.click();
        leavesPage.createButton.click();
        leavesPage.descriptionInput.sendKeys("off");
        leavesPage.leaveTypeInput.sendKeys("shopping");
        leavesPage.daysNumInput.clear();
        leavesPage.daysNumInput.sendKeys("3");
        leavesPage.discardButton.click();
        leavesPage.okButton.click();

        Assert.assertTrue(leavesPage.messageText.isDisplayed(),"Message is not displayed");
    }
}
