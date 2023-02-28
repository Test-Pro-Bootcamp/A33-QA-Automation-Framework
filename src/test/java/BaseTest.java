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


public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public void enterAllSongs() throw InterruptedException {
        WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        Thread.sleep(1000);
        allSongs.click();
    }

    public void selectSong () throw InterruptedException {
        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']"));
        Thread.sleep(1000);
        song.click();
    }

    public void enterButtonPlaySong() throw InterruptedException {
        WebElement buttonPlaySong = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        Actions actions = new Actions(driver);
        actions.click(buttonPlaySong).perform();
    }


    public boolean isDisplayedPlayingSong() {

        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return songIsPlaying.isDisplayed();



    }

}





    }

