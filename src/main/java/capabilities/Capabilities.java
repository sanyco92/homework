package capabilities;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;

/**
 * Created by aleksandr.kot on 6/10/17.
 */
public class Capabilities {

    private static String SERVER_URL = "http://127.0.0.1:4723/wd/hub";
    private URL serverURL;

    public Capabilities() throws MalformedURLException {
        this.serverURL = new URL(SERVER_URL);
    }


    public DesiredCapabilities getIOSCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/app/iOS");
        File app = new File(appDir, "FasTip.app");
        capabilities.setCapability(PLATFORM_NAME, "iOS");
        capabilities.setCapability(PLATFORM_VERSION, "10.3");
        capabilities.setCapability(DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(FULL_RESET, "false");
        capabilities.setCapability(APP, app.getAbsolutePath());
        capabilities.setCapability("bootstrapPath", "/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent");
        capabilities.setCapability("agentPath", "/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/WebDriverAgent.xcodeproj");
        return capabilities;
    }

    public DesiredCapabilities getAndroidCapabilities() {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/app/Android");
        File app = new File(appDir, "FasTip.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, "Android");
        capabilities.setCapability(DEVICE_NAME, "NotUsed");
        capabilities.setCapability(APP, app.getAbsolutePath());
        capabilities.setCapability("appPackage", "org.traeg.fastip");
        capabilities.setCapability("appActivity", "org.traeg.fastip.MainActivity");
        return capabilities;

    }


    public URL getServerURL() {
        return serverURL;
    }
}
