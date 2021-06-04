package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
   protected SearchPage searchPage;

 //Initializing Chrome browser and get the desired website
   @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver3.exe");
        driver=new ChromeDriver();
        driver.get("https://stackoverflow.com/");
        searchPage=new SearchPage(driver);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

    }
    @AfterClass
    public void tearDown(){
       driver.quit();
    }

}
