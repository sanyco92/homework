import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

class ContactDetailsPage extends BaseScreen {

    public ContactDetailsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getEmailAddress() {
        String result = null;
        if (android) result = driver.findElementById("email").getText();
        if (ios) result = driver.findElementById("").getText(); //TODO: add locator for iOS
        return result;
    }
}
