package android.webApp.page_object.google;

import android.AbstractPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchPage extends AbstractPage {

    @FindBy(xpath="//img[@id='hplogo']")
    private AndroidElement logo;

    public GoogleSearchPage(AppiumDriver<AndroidElement> appiumDriver) {
        super(appiumDriver);
    }

    public boolean isLogoVisible() {
         webDriverWait.until(ExpectedConditions.visibilityOf(logo));
         return logo.isDisplayed();
    }

}
