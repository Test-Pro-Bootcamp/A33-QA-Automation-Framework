import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {

    @Test
    public static void playSong() throws InterruptedException {
        openPage("https://bbb.testpro.io/");
        //Log in
        enterEmail("linulya1411@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        playButton();

    }
}