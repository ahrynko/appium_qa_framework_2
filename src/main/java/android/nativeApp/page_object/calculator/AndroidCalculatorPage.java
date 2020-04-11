package android.nativeApp.page_object.calculator;

import android.AbstractPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AndroidCalculatorPage extends AbstractPage {

    public AndroidCalculatorPage(AppiumDriver<AndroidElement> appiumDriver) {
        super(appiumDriver);
    }

    private AppiumDriver<AndroidElement> appiumDriver;

    @FindBy(xpath="//android.widget.Button[2]")
    private AndroidElement acceptButton;

    @FindBy(id="com.miui.calculator:id/btn_5_s")
    private AndroidElement digitFive;

    @FindBy(id="com.miui.calculator:id/btn_plus_s")
    private AndroidElement signPlus;

    @FindBy(id="com.miui.calculator:id/btn_7_s")
    private AndroidElement digitSeven;

    @FindBy(id="com.miui.calculator:id/btn_equal_s")
    private AndroidElement equals;

    @FindBy(id="com.miui.calculator:id/result")
    private AndroidElement actualSumResult;

    public String calculatorSumTest() {
        webDriverWait.until(ExpectedConditions.visibilityOf(acceptButton));
        acceptButton.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(digitFive));
        digitFive.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(signPlus));
        signPlus.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(digitSeven));
        digitSeven.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(equals));
        equals.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(actualSumResult));
        return actualSumResult.getText();

    }

}
