package hometask2;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by aleksandr.kot on 6/10/17.
 */
public class Capabilities {

    private static String SERVER_URL = "http://127.0.0.1:4723/wd/hub";
    private URL serverURL;

    public Capabilities() throws MalformedURLException {
        this.serverURL = new URL(SERVER_URL);
    }


    public DesiredCapabilities getCapabilities() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/aleksandr.kot/Documents/Projects/apiumStart/app/iOS/ContactsSimulator.app");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");

        return capabilities;
    }

    public URL getServerURL() {
        return serverURL;
    }
}
