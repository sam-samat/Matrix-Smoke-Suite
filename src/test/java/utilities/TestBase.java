package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @BeforeClass

    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod

    public void setUp()throws InterruptedException{

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        Driver.getDriver().get("http://54.148.96.210/web/login");

        LoginPage leavesLP = new LoginPage();
        leavesLP.ERPLogin("EventsCRM_Manager8@info.com","Ugh45wQ19");


//        WebElement usernameInput = Driver.getDriver().findElement(By.id("login"));
//        usernameInput.sendKeys("EventsCRM_Manager8@info.com");
//        WebElement passwordInput = Driver.getDriver().findElement(By.id("password"));
//        passwordInput.sendKeys("Ugh45wQ19");
//        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
//        loginButton.click();
    }


    @AfterMethod
    public void tearDown()throws InterruptedException{
        Thread.sleep(10000);
        driver.close();
    }

}