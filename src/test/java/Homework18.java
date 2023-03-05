import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

    public class Homework18 extends BaseTest {
  @Test
  public void playSong() throws InterruptedException {

      setupClass();
      launchBrowser();
      navigateToPage();
      provideEmail("test@test.com");
      providePassword("te$t$tudent");
      clickSubmit();
      Thread.sleep(2000);
      allSongsPage();
      clickPlayNextSong();
      clickPlayBtn();
      Assert.assertTrue(confirmSoundBarIsDisplayed());



  }

  public void allSongsPage() {
      WebElement allSongs = driver.findElement(By.cssSelector("a[class='songs']"));
      allSongs.click();
  }
    public void clickPlayNextSong() throws InterruptedException {
      WebElement playNextBtn = driver.findElement(By.xpath("//footer[@id='mainFooter']/div/i[@role='button'][2]"));
      playNextBtn.click();
      Thread.sleep(1000);

    }

    public void clickPlayBtn() {
        WebElement playMusicBtn = driver.findElement(By.cssSelector("span[class='play']"));
        playMusicBtn.click();


    }

    public boolean confirmSoundBarIsDisplayed() {
        WebElement soundBarDisplayed = driver.findElement(By.xpath("//div[@class='bars']"));
        return soundBarDisplayed.isDisplayed();
    }




  }

















