package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@Data
public abstract class AbstractPage {

    protected AppiumDriver<AndroidElement> appiumDriver;
    protected WebDriverWait webDriverWait;

    public AbstractPage(final AppiumDriver<AndroidElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        webDriverWait = new WebDriverWait(appiumDriver,30); // класс отвечает за явные ожидания
        appiumDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   // класс отвечает за неявные ожидания (call 1 раз)
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

}
