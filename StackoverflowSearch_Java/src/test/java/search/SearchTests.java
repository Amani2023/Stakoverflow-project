package search;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.LastLinkPage;

import static org.testng.AssertJUnit.assertEquals;
public class SearchTests extends BaseTests {
    @Test
    public void testsSuccessfulSearch(){
        //Searching for the text "python typeerror"
        searchPage.searchFor("python typeerror"+ Keys.ENTER);
        //Try to skip recaptcha
        searchPage.recaptchaTest();
        searchPage.goTo("https://stackoverflow.com/search?q=python+typeerror");

        //Go to the last link visible in the page
        searchPage.scrollDownToSearchResult();

        //Clicking on the last link visible in the page
       LastLinkPage lastLinkPage =searchPage.clickOnLastLink();

       //Scroll down to the last section of answer page
       lastLinkPage.scrollDownToSearchResult();

       //Verify that the blue "Post your answer" button is on the page
       assertEquals(lastLinkPage.getAnswerBoxText(),"Post an Answer box","Box text is incorrect");

    }
}
