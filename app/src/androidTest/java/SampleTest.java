// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest {

    enum Platform {Android, IOS}
    Platform platform = Platform.Android;

    MobileObjects mobileObjects;
    private AppiumDriver driver;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        if(platform == Platform.Android) {
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("appium:deviceName", "Pixel 10");
            desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
            desiredCapabilities.setCapability("appium:appActivity", ".MainActivity");
            desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
            driver = new AndroidDriver(getUrl(), desiredCapabilities);
        } else if (platform == Platform.IOS) {

            driver = new IOSDriver(getUrl(), desiredCapabilities);
        }

        mobileObjects = new MobileObjects(driver);

    }

    @Test
    public void sampleTest() {
        if (platform == Platform.Android) {
            mobileObjects.buttonChange.isDisplayed();
            mobileObjects.buttonChange.click();

            mobileObjects.textToBeChanged.isDisplayed();
            Assertions.assertEquals("Hello UiAutomator!", mobileObjects.textToBeChanged.getText());
        } else if (platform == Platform.IOS) {

        }
    }

    @Test
    public void sampleTest2() {
        String textToSet = "123";
        if (platform == Platform.Android) {
            mobileObjects.userInput.isDisplayed();
            mobileObjects.userInput.sendKeys(textToSet);

            mobileObjects.buttonActivity.isDisplayed();
            mobileObjects.buttonActivity.click();

            mobileObjects.text.isDisplayed();
        Assertions.assertEquals(textToSet,mobileObjects.text.getText());
        } else if (platform == Platform.IOS) {

        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
