package hometask1;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by aleksandr.kot on 6/8/17.
 */
public class SettingsScreen extends BaseScreen {
    private IOSDriver driver;

    @Override
    public String getTitle(IOSDriver driver) {

        WebElement titleLocator = driver.findElement(By.name("title"));
        String titleName = titleLocator.getText();
        return titleName;
    }
}
