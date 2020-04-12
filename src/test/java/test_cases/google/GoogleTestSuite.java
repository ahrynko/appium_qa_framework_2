package test_cases.google;

import android.webApp.page_object.google.GoogleSearchPage;
import android.webApp.page_object.google.GoogleSearchResultsPage;
import android.webApp.page_object.rozetka.RozetkaMainPage;
import common.BaseWebAppTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GoogleTestSuite extends BaseWebAppTest {

    @Test
    public void verifyGoogleSiteTitle() {

        appiumDriver.get("https://google.com/");

        final String title = appiumDriver.getTitle();
        Assert.assertEquals("There is incorrect title displayed!","Google", title);

    }

    @Test
    public void isLogoDisplayed() {

        appiumDriver.get("https://google.com/");

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(appiumDriver);
        Assert.assertTrue("There is no logo displayed!", googleSearchPage.isLogoVisible());

    }

    @Test
    public void verifyGooglePredictiveSearchFunctionality(){

        appiumDriver.get("https://www.google.com.ua/");

        GoogleSearchPage searchPage = new GoogleSearchPage(appiumDriver);
        searchPage.searchFor("rozetka");

        List<String> predictiveSearchList = searchPage.getPredictiveSearchListText();
        Assert.assertFalse("There are not item found! ",predictiveSearchList.isEmpty()); // проверка что List - не пустой

        predictiveSearchList.forEach(item -> { //item - строка,
            Assert.assertTrue("There is not such item present!",item.contains("rozetka"));
        });
    }

    @Test
    public void verifyGoogleSearch(){

        appiumDriver.get("https://www.google.com.ua/");

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(appiumDriver);

        GoogleSearchResultsPage resultsPage = googleSearchPage.searchForWithEnter("rozetka");

        String navUrl = resultsPage.getFirstUrl();
        appiumDriver.get(navUrl);

        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(appiumDriver);
        rozetkaMainPage.getTitle();
        final String title = appiumDriver.getTitle();

        Assert.assertEquals("There is incorrect title present, opened via first url",
                "Интернет-магазин Rozetka™ | Rozetka.ua", title);

    }


}
