import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class SongListingPage extends BasePage {
    @FindBy(css = "input[name='name']")
    WebElement playlistInputTextField;

    @FindBy(css  = ".playlist:nth-child(3)")
    WebElement firstPlaylist;

    public SongListingPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void choosePlay (By locator){
            actions.contextClick(findElement(locator)).perform();
        }

        private void choosePlaylistByName (String name){
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//e[contains(text(), '" + name + "']")));
        }

        public List displayAllSongs () {
            return driver.findElements(By.cssSelector("select#playlistWrapper td.title"));
        }

        public String getPlaylistDetails () {
            return driver.findElement(By.cssSelector("span.meta.text-secondary spam.meta")).getText();
        }

        public void contextClickFirstSong () {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
            WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
            actions.contextClick(firstSong).perform();
        }

        public void chooseAllSongsList (By locator){
            actions.contextClick(findElement(locator)).perform();

        }

    }