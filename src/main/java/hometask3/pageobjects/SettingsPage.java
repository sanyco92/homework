package hometask3.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by aleksandr.kot on 6/24/17.
 */
public class SettingsPage {

    @AndroidFindBy(id = "org.traeg.fastip:id/tipPercentageEditText")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField") //TODO: check
    private MobileElement tipPercentageField;

    @AndroidFindBy(id = "org.traeg.fastip:id/saveSettingsButton")
    @iOSFindBy(accessibility = "Done") //TODO: check
    private MobileElement saveSettingsButton;

    public SettingsPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public SettingsPage clickSaveSettingsButton() {
        saveSettingsButton.click();
        return this;
    }

    public SettingsPage typeTipPercentage(String value) {
        tipPercentageField.clear();
        tipPercentageField.sendKeys(value);
        return this;
    }
}
