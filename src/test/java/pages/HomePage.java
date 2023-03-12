package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private final By allSongs = By.cssSelector("a[href='#!/songs']");

    public HomePage(WebDriver givenDriver) { super(givenDriver); }


    public void enterAllSongs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement songs = wait.until(ExpectedConditions.visibilityOfElementLocated(allSongs));
        songs.click();

    }


   // public HomePage(WebDriver givenDriver) {
       // super(givenDriver);
    //}

    //public void enterAllSongs() {

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        //WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/songs']")));
        //allSongs.click();

        // WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        //allSongs.click();

        //Thread.sleep(1000);
        // allSongs.click();
        //

    public void selectSong() {
        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']"));
        song.click();


    }

    public void enterButtonPlaySong() {
        WebElement buttonPlaySong = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        Actions actions = new Actions(driver);
        actions.click(buttonPlaySong).perform();
    }


    public boolean isDisplayedPlayingSong() {

        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return songIsPlaying.isDisplayed();


    }

    //Methods to rename a playlist
    public void doubleClickOnPlaylist() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        Actions actions = new Actions(driver);
        WebElement myPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/nav/section[2]/ul/li[3]/a")));
        actions.doubleClick(myPlayList).perform();

    }

    public void provideNewName() {


        WebElement nameField = driver.findElement(By.xpath("/html/body/div/div/div/nav/section[2]/ul/li[3]/a"));
        nameField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        nameField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }


    //Additional things for Login test
    public boolean isHomePageElementDisplayed() {
        WebElement homePage = driver.findElement(By.xpath("/html/body/div/div/div/nav/section[1]/ul/li[1]/a"));
        return homePage.isDisplayed();

    }
}
