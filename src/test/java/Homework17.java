import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        createPlaylist();
        searchKeyWord("dark");
        clickViewAllBtn();
        selectFirstSong();
        clickAddToBtn();
        choosePlaylist();
        messageDisplay();
        Assert.assertTrue(messageDisplay().contains("Added 1 song into"));




    }


    public void createPlaylist() {
        WebElement newPlaylistName = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        newPlaylistName.click();
        WebElement clickPlusButton = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        clickPlusButton.click();
        WebElement typeNewName = driver.findElement(By.cssSelector("[name='name']"));
        typeNewName.sendKeys("TestNewPlaylist", Keys.RETURN);

    }

    public void searchKeyWord(String songKeyWord) throws InterruptedException {
        //search for a song
        WebElement newQuery = driver.findElement(By.cssSelector("[input='search']"));
        newQuery.sendKeys(songKeyWord);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() {
        // Click View All to display the search results
        WebElement viewAllBtn = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn]"));
        viewAllBtn.click();
    }

    public void selectFirstSong(){
        //Click the first song in the search results
        driver.findElement(By.xpath("//tr[@class='song-item selected']/td[2]")).click();
    }

    public void clickAddToBtn() {
        // Click ADD TO...
        driver.findElement(By.className("btn-add-to")).click();

    }

    public void choosePlaylist() {
        //Choose the playlist to add it to (create a new playlist)
        driver.findElement(By.linkText("TestNewPlaylist")).click();
    }


    // Verify that the notification appears
    public String messageDisplay() {
        WebElement notificationElement = driver.findElement(By.className("success hide"));
        return notificationElement.getText();

    }

}



