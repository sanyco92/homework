package hometask4;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;

/**
 * Created by aleksandr.kot on 6/24/17.
 */
public class BaseTest {

    static AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(BROWSER_NAME, BrowserType.CHROME);
        capabilities.setCapability(DEVICE_NAME, "hometask4.WebTest");

    }
}
