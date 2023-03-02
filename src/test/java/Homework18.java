import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        navigateToPage("https://bbb.testpro.io/");

        // Login to the Homepage Koel
        provideEmail("janezelenova@gmail.com");
        providePassword("Floridaliving2023$");
        clickSubmit();
        Thread.sleep(2000);


       enterAllSongs();
       selectSong();
       enterButtonPlaySong();

        Assert.assertTrue(isDisplayedPlayingSong());


