package test.java.news.pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import test.java.news.stepDefinitions.BaseClass;

public class NewsPage extends BaseClass {
    // locators
    public By newsImageInBrowser = By.xpath("//android.webkit.WebView/android.widget.Image");
    public By newsImageInApp = By.id("com.test.news:id/recyclerViewImageWidget");
    public By newsHomeScreenError = By.id("com.test.news:id/textViewError");

    protected BaseClass base;

    public NewsPage(BaseClass baseClass) {
        base = baseClass;
    }

    // to verify news image
    public void verifyNewsImages() {
        waitForElementToBeAvailable(newsImageInApp);
        Assertions.assertTrue(isElementPresent(newsImageInApp));
    }

    // clicks on the new image
    public void clickNewsImage() {
        appiumDriver.findElement(newsImageInApp).click();
    }

    // verifies the browser redirection for new image click
    public void verifyNewsBrowserRedirection() throws InterruptedException {
        appiumDriver.activateApp("com.android.chrome");
        waitForElementToBeAvailable(newsImageInBrowser);
        Assertions.assertTrue(isElementPresent(newsImageInBrowser));
    }

    // to verify the news screen
    public void verifyNewsScreen() {
        waitForElementToBeAvailable(newsImageInApp);
        Assertions.assertTrue(isElementPresent(newsImageInApp));
        Assertions.assertTrue(appiumDriver.findElements(By.id("com.test.news:id/recyclerViewImageWidget")).size()>2);
    }

    // to verify the news screen error
    public void verifyNewsScreenError() {
        waitForElementToBeAvailable(newsHomeScreenError);
        Assertions.assertTrue(isElementPresent(newsHomeScreenError));
        verifyElementText(newsHomeScreenError,"Failed to load news");


    }
}