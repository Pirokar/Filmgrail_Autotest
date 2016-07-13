package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vladimir on 12.07.2016.
 * Test for Google Login
 */
public class GoogleLoginTest {
    AndroidDriver driver;
    WebDriverWait wait;

    public GoogleLoginTest(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void start() {
        clickOnGoogleLoginButton();
    }

    private void clickOnGoogleLoginButton() {
        WebElement signInWithGoogleBtn = driver.findElement(By.id("google_sign_in_button"));
        signInWithGoogleBtn.click();
    }
}
