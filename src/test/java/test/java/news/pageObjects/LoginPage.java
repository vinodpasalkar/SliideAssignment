package test.java.news.pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import test.java.news.stepDefinitions.BaseClass;

import java.time.Duration;

public class LoginPage extends BaseClass {

   // locators
    public By appHomeLogo = By.id("com.test.news:id/textViewLogo");
    public By userNameTextField = By.id("com.test.news:id/editTextUserName");
    public By passwordNameTextField = By.id("com.test.news:id/editTextPassword");
    public By loginButton = By.id("com.test.news:id/buttonLogin");
    public By wrongUserNameErrorMarker = By.id("com.test.news:id/error"); // @TBD locator not found in appium inspector, need to check with devs
    public By homeScreenTile = By.xpath("//android.widget.TextView[@text=\"News\"]");

    protected BaseClass base;
    public LoginPage(BaseClass baseClass) {
        base = baseClass;
    }

    // to verify app loaded correctly
    public void isAppLoaded() {
        waitForElementToBeAvailable(appHomeLogo);
    }

    // to verify login screen is seen
    public void isLoginScreenVisible() {
        Assertions.assertTrue(isElementPresent(userNameTextField));
        Assertions.assertTrue(isElementPresent(passwordNameTextField));
        Assertions.assertTrue(isElementPresent(loginButton));
    }

    // Enter incorrect values in the  username and password text fields
    public void provideWrongCredentials() {
        appiumDriver.findElement(userNameTextField).sendKeys("wrong");
        appiumDriver.findElement(userNameTextField).click();
        //appiumDriver.findElement(passwordNameTextField).sendKeys("wrong");
    }

   // clicks on the login button
    public void clickLoginButton() {
        appiumDriver.findElement(loginButton).click();
    }

    // to verify  the wrong username and/or password error
    public void verifyErrorMarker() {
        appiumDriver.getPageSource().contains("Wrong user name");
        System.out.println("Page source"+ appiumDriver.getPageSource());
        Assertions.assertTrue(appiumDriver.getPageSource().contains("wrong"));
        Assertions.assertTrue(isElementPresent(wrongUserNameErrorMarker));
    }

    // Enter correct values in the  username and password text fields
    public void provideRightCredentials() {
        appiumDriver.findElement(userNameTextField).sendKeys("user1");
        appiumDriver.findElement(passwordNameTextField).sendKeys("password");
    }

    // to verify home screen is seen
    public void verifyHomeScreen() {
     waitForElementToBeAvailable(homeScreenTile);
     Assertions.assertTrue(isElementPresent(homeScreenTile));
    }

    // relaunches the app
    public void relaunchTheApp() {
     // Following method to puts the application in background, it will relaunch the application after 5 sec automatically
        appiumDriver.runAppInBackground(Duration.ofSeconds(5));
    }
}