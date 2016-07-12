package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Vladimir on 12.07.2016.
 * Test for Google Login
 */
public class GoogleLoginTest {
    AndroidDriver driver;

    public GoogleLoginTest(AndroidDriver driver) {
        this.driver = driver;
    }

    public void start() {
        clickOnGoogleLoginButton();
    }

    private void clickOnGoogleLoginButton() {
        WebElement signInWithGoogleBtn = driver.findElement(By.id("google_sign_in_button"));
        signInWithGoogleBtn.click();
    }
}
