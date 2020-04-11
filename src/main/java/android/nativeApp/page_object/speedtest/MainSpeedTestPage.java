package android.nativeApp.page_object.speedtest;

import android.AbstractPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainSpeedTestPage extends AbstractPage {

    public MainSpeedTestPage(AppiumDriver<AndroidElement> appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(className="//android.widget.Button[@text='Next']") //Next
    private AndroidElement nextButton;

    @FindBy(className="//android.widget.Button[@text='Continue']")  //Continue
    private AndroidElement continueButton;

    @FindBy(xpath="//android.view.View[@content-desc='Start a Speedtest']")  //Go
    private AndroidElement goButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Results']")
    private AndroidElement tabResult;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Speed']")
    private AndroidElement tabInternet;

    public void startSpeedTest() {
        /*webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();*/
        webDriverWait = new WebDriverWait(appiumDriver,30);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(tabResult));
        tabResult.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(tabInternet));
        tabInternet.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(goButton));
        goButton.click();
    }

}
