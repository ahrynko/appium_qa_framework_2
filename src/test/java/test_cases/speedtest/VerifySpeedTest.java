package test_cases.speedtest;

import android.nativeApp.page_object.speedtest.MainSpeedTestPage;
import android.nativeApp.page_object.speedtest.SpeedTestResultPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class VerifySpeedTest {

    private AppiumDriver<AndroidElement> appiumDriver;
    private Logger logger = Logger.getLogger(String.valueOf(VerifySpeedTest.class));

    @BeforeTest
    public void initDriverAndConnectDevice() throws MalformedURLException {

        final Dotenv environment = Dotenv.configure().filename("./src/main/resources/environment/capabilities.env").load();

        final DesiredCapabilities desiredCap = new DesiredCapabilities();   // settings

        desiredCap.setCapability("platformName",environment.get("platform"));
        desiredCap.setCapability("platformVersion",environment.get("version"));
        desiredCap.setCapability("deviceName",environment.get("device"));
        desiredCap.setCapability("udid",environment.get("udid"));

        try {
            desiredCap.setCapability("app",
                    new File(".").getCanonicalPath().replaceAll("\\\\" , "/") +
                            environment.get("app"));
        } catch (IOException e) {
            e.printStackTrace();  // refactoring
        }

        desiredCap.setCapability("appPackage",environment.get("package"));  //package
        desiredCap.setCapability("appActivity",environment.get("activity")); //page
        desiredCap.setCapability("autoGrantPermissions",environment.get("permissions"));

        appiumDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCap); //implement = AndroidDriver

    }

    @BeforeClass
    public void startSpeedTest() {
        MainSpeedTestPage mainSpeedTestPage = new MainSpeedTestPage(appiumDriver);
        mainSpeedTestPage.startSpeedTest();
    }

    @Test
    public void checkDownloadValue() {
        SpeedTestResultPage speedTestResultPage = new SpeedTestResultPage(appiumDriver);
        String downloadValue = speedTestResultPage.checkDownloadValue();

        Assert.assertFalse("Locator download value was not displayed! ", downloadValue.isEmpty());
        logger.info(String.format(" Download Mbps = %s", downloadValue));
    }

    @Test
    public void checkUploadValue() {
        SpeedTestResultPage speedTestResultPage = new SpeedTestResultPage(appiumDriver);
        String uploadValue = speedTestResultPage.checkUploadValue();

        Assert.assertFalse("Locator upload value was not displayed! ", uploadValue.isEmpty());
        logger.info(String.format(" Upload Mbps = %s", uploadValue));
    }

    @Test
    public void checkPingValue() {
        SpeedTestResultPage speedTestResultPage = new SpeedTestResultPage(appiumDriver);
        String pingValue = speedTestResultPage.checkPingValue();

        Assert.assertFalse("Locator ping value was not displayed! ", pingValue.isEmpty());
        logger.info(String.format(" Ping = %s", pingValue));
    }

    @Test
    public void checkJitterValue() {
        SpeedTestResultPage speedTestResultPage = new SpeedTestResultPage(appiumDriver);
        String jitterValue = speedTestResultPage.checkJitterValue();

        Assert.assertFalse("Locator jitter value was not displayed! ", jitterValue.isEmpty());
        logger.info(String.format(" Jitter = %s", jitterValue));
    }

    @Test
    public void checkLossValue() {
        SpeedTestResultPage speedTestResultPage = new SpeedTestResultPage(appiumDriver);
        String lossValue = speedTestResultPage.checkLossValue();

        Assert.assertFalse("Locator loss value was not displayed! ", lossValue.isEmpty());
        logger.info(String.format(" Loss = %s", lossValue));
    }

    @AfterTest(alwaysRun = true)
    public void tearDownDriver() {
        appiumDriver.closeApp();
    }


}
