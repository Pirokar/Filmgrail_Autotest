package scenarios;

import helpers.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.Driver.WAIT_TIME_IN_SEC;

/**
 * Created by Vladimir on 12.07.2016.
 * Test for sign in via email
 */
public class SignInTest {
    AndroidDriver driver;

    public SignInTest(AndroidDriver driver) {
        this.driver = driver;
    }

    public void start() {
        clickToSignIn();
        setName();
        setPassword();
        clickToLogin();
    }

    private void clickToSignIn() {
        WebElement signInWithEmailBtn = driver.findElement(By.id("sign_in_text"));
        signInWithEmailBtn.click();
    }

    private void setName() {
        WebDriverWait wait = new WebDriverWait(driver, Driver.WAIT_TIME_IN_SEC);

        WebElement userNameInputField =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username_field")));
        userNameInputField.click();
        userNameInputField.sendKeys("filmgrailtest@gmail.com");
    }

    private void setPassword() {
        WebElement passwordInputField = driver.findElement(By.id("password_field"));
        passwordInputField.click();
        passwordInputField.sendKeys("123456");
    }

    private void clickToLogin() {
        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();
    }
}
