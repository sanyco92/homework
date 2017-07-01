package hometask3;

import capabilities.Capabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import hometask3.pageobjects.MainPage;
import hometask3.pageobjects.SettingsPage;

import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by aleksandr.kot on 6/24/17.
 */
public class CheckTotalAmountValue {


    static AppiumDriver<MobileElement> driver;
    public Platform platform = Platform.IOS;
    static int TIP_PERCENTAGE_MAX_VALUE = 30;
    static int CHECK_AMOUNT_MAX_VALUE = 10000;


    enum Platform {
        IOS,
        ANDROID
    }

    @BeforeTest
    public void setUp() throws MalformedURLException {
        if (platform.equals(Platform.IOS)) {
            Capabilities capabilities = new Capabilities();
            driver = new IOSDriver<MobileElement>(capabilities.getServerURL(), capabilities.getIOSCapabilities());

        } else if (platform.equals(Platform.ANDROID)) {
            Capabilities capabilities = new Capabilities();
            driver = new AndroidDriver<MobileElement>(capabilities.getServerURL(), capabilities.getAndroidCapabilities());
        }
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
    }

    @Test
    public void checkTotalAmountValue() throws InterruptedException {

        Integer tipPercentage = generateRandomNumber(TIP_PERCENTAGE_MAX_VALUE);
        Integer checkAmount = generateRandomNumber(CHECK_AMOUNT_MAX_VALUE);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSettingsButton();
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.typeTipPercentage(tipPercentage.toString());
        settingsPage.clickSaveSettingsButton();
        if (platform.equals(platform.IOS)) {
            assertEquals(mainPage.getTipPercentageValue(), tipPercentage + ".00%");
        } else {
            assertEquals(mainPage.getTipPercentageValue(), tipPercentage + "%");
        }
        mainPage.typeBillAmount(checkAmount.toString());
        mainPage.clickCalculateTipButton();
        assertEquals(mainPage.getTotalAmountValue(), "$" + calculateTotalAmountValue(checkAmount, tipPercentage));


    }

    public Integer generateRandomNumber(int maxValue) {
        Random random = new Random();
        return random.nextInt(maxValue);
    }

    public String calculateTotalAmountValue(Integer checkAmount, Integer tipPercentage) {
        return new DecimalFormat("#0.00").format(((tipPercentage.floatValue() / 100) * checkAmount) + checkAmount);
    }
}
