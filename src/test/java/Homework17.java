import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotificationText = "Added 1 song into";

        login("demo@class.com", "te$t$tudent");
        searchSong("Pluto");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));

    }
    public void searchSong (String songTitleKeyword)  {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitleKeyword);
    }
    public void clickViewAllBtn ()  {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResult.click();
    }
    public void selectFirstSongResult()   {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
    }
    public void clickAddToBtn()   {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();

    }
    public void choosePlaylist()  {
//       We created a playlist named "Test Pro Playlist"
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id ='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlistElement.click();
    }
    public String getNotificationText(){
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }
}