package hometask2;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

/**
 * Created by aleksandr.kot on 6/11/17.
 */
public class ContactsListTest {

    private static IOSDriver<MobileElement> driver;

    @BeforeTest
    private void preconditions() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        //hometask2.capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/aleksandr.kot/Documents/Projects/apiumStart/app/iOS/ContactsSimulator.app");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void openContact() throws MalformedURLException {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 4);
        MobileElement contactName;
        ArrayList<String> listOfNames = new ArrayList<String>();

        listOfNames.add("Byron Workman");
        listOfNames.add("Chris Heavener");
        listOfNames.add("Christin Steinberg");
        listOfNames.add("Duane Cedillo");
        listOfNames.add("Dulcie Moller");

        for (String each : listOfNames) {
            MobileElement cell = (MobileElement) driver.findElementByAccessibilityId(each);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//XCUIElementTypeTable/XCUIElementTypeCell[" + (listOfNames.indexOf(each) + 1) + "]")));
            cell.click();
            contactName = (MobileElement) driver.findElementByAccessibilityId(each);
            assertEquals(each, contactName.getText());
            MobileElement backBtn = (MobileElement) driver.findElementByAccessibilityId("Contacts");
            backBtn.click();
        }
    }
}