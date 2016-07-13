package scenarios;

import controllers.GetGenresController;
import helpers.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static helpers.Driver.WAIT_TIME_IN_SEC;

/**
 * Created by Vladimir on 12.07.2016.
 * Test for sign in via email
 */
public class SignInTest implements Callback<String[]> {
    AndroidDriver driver;
    WebDriverWait wait;

    private int countOfGetGenres = 0;

    public SignInTest(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void start() {
        clickToSignIn();
        setName();
        setPassword();
        clickToLogin();
        waitOnboarding();
        getGenres();
    }

    private void clickToSignIn() {
        WebElement signInWithEmailBtn = driver.findElement(By.id("sign_in_text"));
        signInWithEmailBtn.click();
    }

    private void setName() {
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

    private void waitOnboarding() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("grid_view")));
    }

    private void getGenres() {
        new GetGenresController(this).execute();
    }

    private void selectGenres(String[] allGenres) {
        System.out.print("...");
    }

    public void success(String[] strings, Response response) {
        selectGenres(strings);
    }

    public void failure(RetrofitError retrofitError) {
        if(++countOfGetGenres < 5) {
            getGenres();
        }
    }
}
