package hometask2;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by aleksandr.kot on 6/11/17.
 */
public class SearchTest {

    @Test
    public void searchPositiveTest() throws MalformedURLException {

        Capabilities capabilities = new Capabilities();
        IOSDriver driver = new IOSDriver(capabilities.getServerURL(), capabilities.getCapabilities());
        WebDriverWait wait = new WebDriverWait(driver, 4);

        String searchName = "Sara";
        String resultName;

        MobileElement searchField = (MobileElement) driver.findElementByAccessibilityId("Search for contact");
        searchField.sendKeys(searchName);

        MobileElement tableCell = (MobileElement) driver.findElementByAccessibilityId("Sara Alston");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeCell")));
        resultName = tableCell.getText();
        assertTrue(resultName.contains(searchName));
    }

    @Test
    public void searchNegativeTest () throws MalformedURLException {
        Capabilities capabilities = new Capabilities();
        IOSDriver driver = new IOSDriver(capabilities.getServerURL(), capabilities.getCapabilities());
        WebDriverWait wait = new WebDriverWait(driver, 4);

        String searchName = "JKL:!@$JASLD:!@_)%";
        String resultName;

        MobileElement searchField = (MobileElement) driver.findElementByAccessibilityId("Search for contact");
        searchField.sendKeys(searchName);
        MobileElement noResultsLabel = (MobileElement) driver.findElementByAccessibilityId("No Results");
        assertTrue(noResultsLabel.isEnabled());
    }
}
