import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseScreen {
    public static final String projectName = "My Application";
    private String username;
    private IOSDriver driver;

    public abstract void getTitle();

    public void goBack(IOSDriver driver) {
        WebElement backBtn = driver.findElement(By.name("Back"));
        backBtn.click();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static void main(String[] args) {
        System.out.println(projectName);
    }

}
