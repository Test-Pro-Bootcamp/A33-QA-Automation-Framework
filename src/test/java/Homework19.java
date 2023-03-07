import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest {

    @Test(dataProvider = "loginData")
    public void deletePlayList(String email, String password) throws InterruptedException {
        setUpBrowser("https://bbb.testpro.io/");
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        Thread.sleep(2000);
        clickPlaylistToDelete();
        Thread.sleep(2000);
        clickXPlaylist();
        clickOkToConfirm();

    }
}