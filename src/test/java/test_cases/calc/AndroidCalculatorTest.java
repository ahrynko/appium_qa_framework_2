package test_cases.calc;

import android.nativeApp.page_object.calculator.AndroidCalculatorPage;
import common.BaseNativeAppTest;
import org.junit.Assert;
import org.junit.Test;

public class AndroidCalculatorTest extends BaseNativeAppTest {

    @Test
    public void verifyAndroidCalculatorSumTest() {

     AndroidCalculatorPage calculatorPage = new AndroidCalculatorPage(appiumDriver);
        String actualSumResult = calculatorPage.calculatorSumTest();

        String expectedSumResult = "= 12";

        Assert.assertEquals("Wrong amount in calculator", expectedSumResult, actualSumResult);
    }

}
