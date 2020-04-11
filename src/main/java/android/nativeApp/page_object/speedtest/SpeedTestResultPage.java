package android.nativeApp.page_object.speedtest;

import android.AbstractPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpeedTestResultPage extends AbstractPage {

    public SpeedTestResultPage(AppiumDriver<AndroidElement> appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(xpath="//android.widget.FrameLayout[@content-desc='DOWNLOAD']")
    private AndroidElement downloadText;

    @FindBy(xpath="//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")
    private AndroidElement downloadValue;

    @FindBy(xpath="//android.widget.FrameLayout[@content-desc='UPLOAD']")
    private AndroidElement uploadText;

    @FindBy(xpath="//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")
    private AndroidElement uploadValue;

    @FindBy(xpath="//android.view.ViewGroup[@content-desc='Ping']")
    private AndroidElement pingText;

    @FindBy(xpath="//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")
    private AndroidElement pingValue;

    @FindBy(xpath="//android.view.ViewGroup[@content-desc='Jitter']")
    private AndroidElement jitterText;

    @FindBy(xpath="//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")
    private AndroidElement jitterValue;

    @FindBy(xpath="//android.view.ViewGroup[@resource-id='org.zwanoo.android.speedtest:id/test_result_item_packet_loss']")
    private AndroidElement lossText;

    @FindBy(xpath="//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")
    private AndroidElement lossValue;


    public String checkDownloadValue() {
        webDriverWait = new WebDriverWait(appiumDriver,30);
        webDriverWait.until(ExpectedConditions.visibilityOf(downloadText));
        downloadText.isDisplayed();
        return downloadText.findElement(By.xpath("//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")).getText();
    }

    public String checkUploadValue() {
        webDriverWait = new WebDriverWait(appiumDriver,30);
        webDriverWait.until(ExpectedConditions.visibilityOf(uploadText));
        uploadText.isDisplayed();
        return uploadText.findElement(By.xpath("//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")).getText();
    }

    public String checkPingValue() {
        webDriverWait = new WebDriverWait(appiumDriver,30);
        webDriverWait.until(ExpectedConditions.visibilityOf(pingText));
        pingText.isDisplayed();
        return pingText.findElement(By.xpath("//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")).getText();
    }

    public String checkJitterValue() {
        webDriverWait = new WebDriverWait(appiumDriver,30);
        webDriverWait.until(ExpectedConditions.visibilityOf(jitterText));
        jitterText.isDisplayed();
        return jitterText.findElement(By.xpath("//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")).getText();
    }

    public String checkLossValue() {
        webDriverWait = new WebDriverWait(appiumDriver,30);
        webDriverWait.until(ExpectedConditions.visibilityOf(lossText));
        lossText.isDisplayed();
        return lossText.findElement(By.xpath("//*[@resource-id='org.zwanoo.android.speedtest:id/txt_test_result_value']")).getText();
    }


}
