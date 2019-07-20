package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.Config;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){

    }

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            String browser = Config.getProperty("browser");
            if ("chrome".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }

            driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        return driver;
    }


    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}