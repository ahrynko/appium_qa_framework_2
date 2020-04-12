package android.webApp.page_object.google;

import android.AbstractPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchPage extends AbstractPage {

    @FindBy(xpath="//img[@id='hplogo']")
    private AndroidElement logo;

    @FindBy(xpath="//input[@name='q']")
    private WebElement searchInput;

    @FindBys({                      //принимает значение массива
            @FindBy(xpath = "//li[@class='sbct' and not (@id='sbt')]")
    })
    private List<WebElement> predictiveSearchList;

    public GoogleSearchPage(AppiumDriver<AndroidElement> appiumDriver) {
        super(appiumDriver);
    }

    public boolean isLogoVisible() {
         webDriverWait.until(ExpectedConditions.visibilityOf(logo));
         return logo.isDisplayed();
    }

    public void searchFor(String searchText){
        webDriverWait = new WebDriverWait(appiumDriver,10);
        searchInput.sendKeys(searchText);
    }

    public GoogleSearchResultsPage searchForWithEnter(String searchText){  // любой текст
        searchInput.sendKeys(searchText, Keys.ENTER); // класс Keys- нажатия клавиатуры (input)
        return new GoogleSearchResultsPage(appiumDriver);
    }

    public List<String> getPredictiveSearchListText() {
        return predictiveSearchList
                .stream()
                .map(item -> item.getText())
                //.map(WebElement::getText) - упрощенная запись - метод референс, для обработки одного элемента
                //.map(item -> Integer.parseInt(item))   // парсить строку в число
                .collect(Collectors.toList());
    }

}
