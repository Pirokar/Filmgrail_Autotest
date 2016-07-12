package scenarios;

import helpers.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by Vladimir on 11.07.2016.
 * Here is test starts
 */

public class StartPoint {
    AndroidDriver driver;

    @BeforeMethod
    protected void prepareAndroidForAppium() throws MalformedURLException {
        driver = Driver.setup();
    }

    @Test
    public void startTesting() {
        new GoogleLoginTest(driver).start();
        new SignInTest(driver).start();
    }

    @AfterMethod
    private void quitDriver() {
        driver.quit();
    }
}