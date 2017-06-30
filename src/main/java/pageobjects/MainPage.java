package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by aleksandr.kot on 6/24/17.
 */
public class MainPage {

    @AndroidFindBy(accessibility = "Settings")
    @iOSFindBy(accessibility = "Settings")
    private MobileElement goToSettingsButton;

    @AndroidFindBy(id = "billAmtEditText")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField")
    private MobileElement billAmountTextField;

    @AndroidFindBy(id = "calcTipButton")
    @iOSFindBy(accessibility = "Calculate Tip")
    private MobileElement calculateTipButton;

    @AndroidFindBy(id = "org.traeg.fastip:id/tipPctTextView")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[2]")
    private MobileElement tipPercentageValue;

    @AndroidFindBy(accessibility = "tipAmtTextView")
    @iOSFindBy(accessibility = "tipAmtTextView") //TODO: check
    private MobileElement tipAmountValue;

    @AndroidFindBy(id = "totalAmtTextView")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[4]")
    private MobileElement totalAmountValue;




    public MainPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MainPage clickSettingsButton() {
        goToSettingsButton.click();
        return this;
    }

    public MainPage typeBillAmount(java.lang.String value) {
        billAmountTextField.clear();
        billAmountTextField.sendKeys(value);
        return this;
    }

    public MainPage clickCalculateTipButton() {
        calculateTipButton.click();
        return this;
    }

    public java.lang.String getTipPercentageValue() {
        return tipPercentageValue.getText();
    }

    public java.lang.String getTipAmountValue() {
        return tipAmountValue.getText();
    }

    public java.lang.String getTotalAmountValue() {
        return totalAmountValue.getText();
    }
}
