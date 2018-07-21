package com.automation;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.AppiumCommandExecutor;
import org.apache.bcel.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by joe on 5/9/2018.
 */
public class BaseClass {

    public static DesiredCapabilities capabilities;
    public static AppiumDriver driver;
    public static String androidAppPath = "/Users/joe/Documents/Apk/android-release.apk";

    @BeforeClass
    public  void setup() throws Exception {

        capabilities = new DesiredCapabilities().android();
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("deviceName", "Samsung galaxy");
        capabilities.setCapability("appium-version","1.7.1");
        capabilities.setCapability("platformName", Labels.ANDROID_CAPABILITIES_PLATFORM_NAME);
        capabilities.setCapability("appPackage", Labels.ANDROID_CAPABILITIES_PACKAGE_NAME);
        //File app = new File(Labels.ANDROID_CAPABILITIES_APP_PATH);
        //String appPathCapability = app.getAbsolutePath();
        capabilities.setCapability("app", androidAppPath);
       // capabilities.setCapability("appWaitActivity",Labels.ANDROID_CAPABILITIES_APP_WAIT_ACTIVITY);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("newCommandTimeOut", "7200");
        capabilities.setCapability("deviceId", "Android");
        driver = new AndroidDriver(new URL(Labels.ANDROID_CAPABILITIES_URL),capabilities);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @AfterClass
    public void teardown() throws  Exception{
        driver.quit();
    }

    //@BeforeClass
    public static void isScreenDisplayed(){


    }

    public static boolean waitUntilPageLoads(String xPath) {

        int counter = 0;
        while (counter <= 4) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 500);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
                return true;
            } catch (ElementNotVisibleException e) {
                System.out.println("trying to find out element attempt" + counter);
                counter++;
                sleep(500);
            }
        }

        return false;
    }

    public static boolean waitUntilNavigationIndicatorDismiss(String className) {

        int counter = 0;
        while(counter <= 4) {

            try {

                WebDriverWait wait = new WebDriverWait(driver, 500);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(className)));
                return true;
            }catch (Exception e) {
                System.out.println("trying to find out element" + counter);
                counter++;
                sleep(500);
            }
        }
        return false;
    }

    public static void sleep(long millSecond) {

        try {
            Thread.sleep(millSecond);
        } catch (InterruptedException e) {
        }
    }

    public static boolean isAlertDisplayed() {
        int counter = 0;
        while(counter < 4) {
            try {
                WebElement element = driver.findElement(By.id("com.android.packageinstaller:id/dialog_container"));
                if (element.isDisplayed())
                    return true;
            } catch (Exception e) {
                fail("Element not found" + e);
                counter++;
            }
        }
        return false;
    }

    public static boolean findElementByIdAndClick(String Id) {

        int counter = 0;
        while(counter < 4) {
            try {

                driver.findElement(By.id(Id)).click();
                return  true;
            }catch (Exception e) {
                fail("Element not found");
                counter++;
            }
        }
        return  false;
    }

    public static boolean findElementByXpathAndClick(String xPath) {

        int counter = 0;
        while(counter < 4) {
            try {

                WebElement buttonName = driver.findElement(By.xpath(xPath));
                buttonName.click();
                return true;
            }catch (Exception e) {
                fail("Element not found");
                counter++;
            }
        }
        return false;
    }

}
