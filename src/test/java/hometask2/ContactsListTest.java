package hometask2;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

/**
 * Created by aleksandr.kot on 6/11/17.
 */
public class ContactsListTest {

    @Test
    public void openContact() throws MalformedURLException {

        Capabilities capabilities = new Capabilities();
        IOSDriver driver = new IOSDriver(capabilities.getServerURL(), capabilities.getCapabilities());
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