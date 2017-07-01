package hometask4;

import org.testng.annotations.Test;

/**
 * Created by aleksandr.kot on 6/25/17.
 */
public class WebTest extends BaseTest {

    @Test
    public void firstWebTest() {
        driver.get("http://google.com.ua");

    }
}
