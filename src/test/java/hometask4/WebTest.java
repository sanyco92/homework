package hometask4;

import hometask4.pageobjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by aleksandr.kot on 6/25/17.
 */
public class WebTest extends BaseTest {

    @Test
    public void firstWebTest() throws InterruptedException {
        driver.get("http://apple.com");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickBagIcon();
        homePage.closeBag();
        homePage.clickMenuIcon();
        homePage.closeMenu();


    }
}
