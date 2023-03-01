import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void AddSongToPlaylist() throws InterruptedException {
        openPage("https://bbb.testpro.io/");
        //Log in
        enterEmail("linulya1411@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        //Search for a song
        searchForSong("Beautiful");
        Thread.sleep(2000);
        viewAllResults();
        //Select the song
        selectFirstSong();
        //Add song to the playlist
        clickAddTo();
        choosePlaylist();


        WebElement addedSongNotification = driver.findElement(By.cssSelector("success show"));
        Assert.assertTrue(addedSongNotification.isDisplayed());
    }



    /*public String addedSongNotification() {
 *       WebElement addedSongNotification = driver.findElement(By.cssSelector("success show"));
 *       return addedSongNotification.isDisplayed();

  *  }
  *  public boolean verifyNotificationMessage() {
  *      WebElement verifyMessage = driver.findElement(By.cssSelector("success show"));
  *      return verifyMessage.getText();
    }*/

}
