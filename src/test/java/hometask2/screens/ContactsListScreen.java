package hometask2.screens;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by aleksandr.kot on 6/11/17.
 */
public class ContactsListScreen {
    private final IOSDriver driver;
    private final WebDriverWait wait;

    public ContactsListScreen(IOSDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 4);
    }
}
