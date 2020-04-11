package test_cases.google;

import android.webApp.page_object.google.GoogleSearchPage;
import common.BaseWebAppTest;
import org.junit.Assert;
import org.junit.Test;

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
}
