package test.java.news.stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class BaseClass {

    public static AppiumDriver appiumDriver;


    // to set up a device for testing
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesReader.getProperty("config", "platform_name"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesReader.getProperty("config", "platform_version"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesReader.getProperty("config", "device_name"));
        caps.setCapability("appPackage", PropertiesReader.getProperty("config", "appPackage"));
        caps.setCapability("appActivity", PropertiesReader.getProperty("config", "appActivity"));
        caps.setCapability(MobileCapabilityType.NO_RESET, PropertiesReader.getProperty("config", "noReset"));
        caps.setCapability(MobileCapabilityType.FULL_RESET, PropertiesReader.getProperty("config", "fullReset"));
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesReader.getProperty("config", "automationName"));
        caps.setCapability(MobileCapabilityType.APP, PropertiesReader.getProperty("config", "App_path"));

        appiumDriver = new AndroidDriver(new URL(PropertiesReader.getProperty("config", "Appium_hub")), caps);

    }
    // to verify element presence
    protected boolean isElementPresent(By by) {

        try {
            appiumDriver.findElement(by);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // to verify element text
    protected boolean verifyElementText(By by,String text) {

        try {
            if(appiumDriver.findElement(by).getText().equals(text)) {
                return true;
            }else{
                return false;
            }

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // wait for element to be present on screen
    protected static void waitForElementToBeAvailable(By locator) {
        new WebDriverWait(appiumDriver, 10).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // make internet connection active
    public void hasActiveInternetConnection() throws IOException {
        Runtime.getRuntime().exec("adb shell svc wifi enable");
        Runtime.getRuntime().exec("adb shell svc data enable");
    }

    // make internet connection inactive
    public void hasNoActiveInternetConnection() throws IOException {
        Runtime.getRuntime().exec("adb shell svc wifi disable");
        Runtime.getRuntime().exec("adb shell svc data disable");
    }

    // to close the instance after run finishes
    public void tearDown() {
        appiumDriver.quit();
    }

}
