package helpers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Vladimir on 12.07.2016.
 */
public class Driver {
    public static final int WAIT_TIME_IN_SEC = 30;

    public static AndroidDriver setup() throws MalformedURLException {
        String workingDir = System.getProperty("user.dir");
        File appDir = new File(workingDir, "apps");
        File app = new File(appDir, "app-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName", "Custom Phone");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("app-package", "com.Filmgrail.android.debug");
        capabilities.setCapability("app-activity", ".HomeActivity");

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
