package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchPage {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    //Define the search toolbar
    private By searchBox=By.xpath("//header/div[1]/form[1]/div[1]/input[1]");

    //define he last link of search results
    private By searchResult=By.xpath("//a[contains(text(),'Q: Python TypeError float is not callable while us')]");

    public SearchPage(WebDriver driver){

        this.driver=driver;
        navigate = driver.navigate();
    }

    //Searching for the text action
public void searchFor(String text){

        driver.findElement(searchBox).sendKeys(text);
    }

    //Skip recaptcha Test action
    public void recaptchaTest(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-')]")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark")));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }

    //Navigating to search results action
    public void goTo(String url){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        navigate.to(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }
    //Going to the last link visible in the first page action
    public void scrollDownToSearchResult(){
        WebElement lastLink=driver.findElement(searchResult);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String script="arguments[0].scrollIntoView();";
        js.executeScript(script,lastLink);

    }

    //Clicking on the last link visible in the first page action
    public LastLinkPage clickOnLastLink(){
        driver.findElement(searchResult).click();
        return new LastLinkPage(driver);
    }

}
