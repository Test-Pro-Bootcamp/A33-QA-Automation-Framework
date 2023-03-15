import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest {
    //
    @Test
    public void deletePlaylist() throws InterruptedException {
        String notification1 = "Deleted playlist ";

        enterEmail();
        enterPassword();
        submit();
        clickPlaylist();
        clickDelete();
        Assert.assertTrue(getNotification().contains(notification1));



    }
}