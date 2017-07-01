package hometask2;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by aleksandr.kot on 6/8/17.
 */
public class LoginScreen extends BaseScreen {
    private IOSDriver driver;
    private String name;

    @Override
    public String getTitle(IOSDriver driver) {

        WebElement title = driver.findElement(By.name("title"));
        String titleName = title.getText();
        return titleName;
    }

    public void printNames(ArrayList<String> names) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }
    private void printNames(HashSet<String> names) {
        for (String each : names) {
            System.out.println(each);
        }

        System.out.println("\n");
        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
