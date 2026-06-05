import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;

public class MobileObjects {


    public WebElement buttonChange;

    public WebElement textToBeChanged;

    public WebElement userInput;

    public WebElement buttonActivity;

    public WebElement text;
    private AppiumDriver driver;

    MobileObjects (AppiumDriver driver){
        this.driver = driver;
        if (driver instanceof AndroidDriver){
            buttonChange = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
            textToBeChanged = driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
            userInput = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
            buttonActivity = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonActivity"));
            text = driver.findElement(By.id("ru.netology.testing.uiautomator:id/text"));
        } else if (driver instanceof iOSXCUITFindBy) {
            
        }
    }
}
