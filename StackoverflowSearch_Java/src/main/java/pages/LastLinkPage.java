package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LastLinkPage {

    private WebDriver driver;

    //Define "Post your answer" button
    private By answerBox=By.cssSelector("#submit-button");

    public LastLinkPage(WebDriver driver){
        this.driver=driver;

    }

    //Scroll down in the page 2
    public void scrollDownToSearchResult(){
        WebElement postAnAnswerBox=driver.findElement(answerBox);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String script="arguments[0].scrollIntoView();";
        js.executeScript(script,postAnAnswerBox);

    }

    //get the text of "Post your answer" button
    public String getAnswerBoxText(){

        return driver.findElement(answerBox).getText();
    }
}
