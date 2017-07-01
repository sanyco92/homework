package hometask4.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by aleksandr.kot on 7/2/17.
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//span[@class=\"ac-gn-menuicon-bread ac-gn-menuicon-bread-top\"]")
    private WebElement menuIcon;

    @FindBy(xpath = "//a[@class=\"ac-gn-link ac-gn-link-bag\"]")
    private WebElement bagIcon;

    private static AppiumDriver<MobileElement> driver;

    public HomePage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public HomePage clickMenuIcon() {
        menuIcon.click();
        return this;
    }

    public HomePage clickBagIcon() {
        bagIcon.click();
        return this;
    }

    public HomePage closeMenu() throws InterruptedException {
        Thread.sleep(1000);
        menuIcon.click();
        return this;
    }

    public HomePage closeBag() throws InterruptedException {
        Thread.sleep(1000);
        bagIcon.click();
        return this;
    }

}
