package android.webApp.page_object.rozetka;

import android.AbstractPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RozetkaMainPage extends AbstractPage {

    public RozetkaMainPage(AppiumDriver<AndroidElement> appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(xpath = "//title[contains(text(),'| Rozetka.ua')]")
    private WebElement title;

    @FindBy(xpath = "//a[@class='btn-link btn-link-green main-content-btn']")
    private WebElement catalog;

    public void getTitle(){
        webDriverWait.until(ExpectedConditions.visibilityOf(catalog));
        title.getText();
    }

}
