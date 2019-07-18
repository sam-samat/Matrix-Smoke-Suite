package matrixSmoke;

import pages.HomePage;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeavesPage;
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
}
