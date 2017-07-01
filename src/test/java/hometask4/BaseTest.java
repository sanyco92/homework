package hometask4;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by aleksandr.kot on 6/24/17.
 */
public class BaseTest {

    static AppiumDriver<MobileElement> driver;
    static WebDriverWait wait;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, "iOS");
        capabilities.setCapability(PLATFORM_VERSION, "10.3");
        capabilities.setCapability("browserName", "Safari");
        capabilities.setCapability(DEVICE_NAME, "iPhone 6");
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //driver.manage().timeouts().implicitlyWait(4, SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }
}
