package common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.Getter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

@Getter // for private driver
public abstract class BaseWebAppTest {

        protected AppiumDriver<AndroidElement> appiumDriver;
        protected WebDriverWait webDriverWait;

        @Before
        public void initDriver() throws MalformedURLException {

            final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();   // settings
            desiredCapabilities.setCapability("platformName","Android");
//        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,"false");
            desiredCapabilities.setCapability("platformVersion","9");
            desiredCapabilities.setCapability("deviceName","Redmi");
            desiredCapabilities.setCapability("udid","05f9990c0006");
            desiredCapabilities.setCapability("browserName","Chrome");
//        desiredCapabilities.setCapability("automationName","UiAutomator1");

            appiumDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities); //implement = AndroidDriver
        }

        @After
        public void tearDownDriver() {
            appiumDriver.close();
            appiumDriver.quit();
        }

    }
