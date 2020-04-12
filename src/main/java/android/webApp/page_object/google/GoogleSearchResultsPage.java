package android.webApp.page_object.google;

import android.AbstractPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GoogleSearchResultsPage extends AbstractPage {

    @FindBys({
            @FindBy( xpath = "//a[@class='C8nzq BmP5tf']")
    })
    private List<WebElement> navigationUrls;  //list urls

    public GoogleSearchResultsPage(AppiumDriver<AndroidElement> appiumDriver) {
        super(appiumDriver);
    }

    public String getFirstUrl(){  //получить первый атрибут URL
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(navigationUrls));
        return navigationUrls.get(0).getAttribute("href");
    }


}
