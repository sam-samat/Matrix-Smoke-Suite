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

    @Test
    public void clickLeaveButtonRequst()throws Exception{
        HomePage hp=new HomePage();
        hp.leavesButton.click();

        LeavesPage lp=new LeavesPage();
        lp.addSearchFilter.click();

        lp.filterButton.click();

        lp.currentYearFilter.click();

        String actualText ="Current Year";
        Assert.assertEquals(lp.currentYearFilter.getText(),actualText);
        Assert.assertTrue(lp.currentYearFilter.isDisplayed());

        @Test
    public void addDetatilsOfLeaveRequest() {
        HomePage homePage = new HomePage();
        homePage.leavesButton.click();

        LeavesPage leaves = new LeavesPage();
        leaves.createButton.click();
        leaves.descriptionInput.sendKeys("Vacation");
        leaves.leaveTypeInput.sendKeys("Unpaid");
        leaves.daysNumInput.sendKeys("3");
        leaves.saveButton.click();
        Assert.assertTrue(leaves.alert.isDisplayed());
        leaves.okButton.click();
    }
    @Test
    public void locateButtonsInLeaves() {
        HomePage homePage = new HomePage();
        homePage.leavesButton.click();

        LeavesPage leaves = new LeavesPage();
        leaves.leavesSummaryButton.click();
        String expectedTitle="Leaves Summary";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle,"Leaves Summary title verification didin't pass");
        leaves.allocationButton.click();
        String expectedTitleAllocation="Allocation Request";
        String actualTitleAllocation=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitleAllocation,actualTitleAllocation,"Allocation requset title didn't pass");
        leaves.leaveRequestButton.click();
        String expectedTitleRequest="Leaves Request";
        String actualTitleRequest=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitleRequest,actualTitleRequest,"Leaves request title didn't pass");


    }
        @Test
        public void LeavesSummaryVerification()throws InterruptedException {
            HomePage homepage = new HomePage();
            Thread.sleep(1000);
            homepage.leavesButton.click();
            LeavesPage leavesPage = new LeavesPage();
            leavesPage.leavesSummary.click();
            Thread.sleep(1500);
            Assert.assertEquals(leavesPage.leavesSummaryText.getText(), "Leaves Summary");
        }
        @Test
        public void  LeavesSummaryCreateError() throws InterruptedException {
            HomePage homepage =new HomePage();
            Thread.sleep(1000);
            homepage.leavesButton.click();
            LeavesPage leavesPage = new LeavesPage();
            leavesPage.leavesSummary.click();
            Thread.sleep(2000);
            leavesPage.SummaryCreate.click();
            Thread.sleep(2000);
            leavesPage.SummarySave.click();
            Thread.sleep(1000);
            Assert.assertTrue(leavesPage.errMessage.isDisplayed());


        }
}
