package hometask4.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by aleksandr.kot on 7/2/17.
 */
public class BasePage {

    AppiumDriver<MobileElement> driver;
    //WebDriverWait wait;
    FluentWait wait;

    public BasePage(AppiumDriver<MobileElement> driver, FluentWait wait) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        this.wait = wait;

    }
}
