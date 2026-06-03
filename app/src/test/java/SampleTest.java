// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.net.MalformedURLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest {

    private AndroidDriver driver;

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
                desiredCapabilities.setCapability("platformName", "android");
                desiredCapabilities.setCapability("appium:deviceName", "Pixel 10");
                desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
                desiredCapabilities.setCapability("appium:appActivity", ".MainActivity");
                desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
                desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
                desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
                desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
                desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(getUrl(), desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        WebElement el1 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
        el1.click();
        WebElement el2 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
        Assertions.assertEquals("Hello UiAutomator!",el2.getText());
    }

    @Test
    public void sampleTest2() {
        String textToSet = "123";
        WebElement el3 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        el3.sendKeys(textToSet);
        WebElement el4 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/buttonActivity"));
        el4.click();
        WebElement el5 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/text"));
        Assertions.assertEquals(textToSet,el5.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
