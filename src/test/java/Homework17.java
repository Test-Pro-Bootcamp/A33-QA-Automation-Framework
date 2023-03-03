import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        setupClass();
        launchBrowser();

        navigateToPage();
        provideEmail("test@test.com");
        providePassword("te$t$tudent");
        clickSubmit();

        createPlaylist();
        searchKeyWord("dark");
        clickViewAllBtn();
        selectFirstSong();
        clickAddToBtn();
        choosePlaylist();
        messageDisplay();
        Assert.assertTrue(messageDisplay().contains("Added 1 song into"));

    }


    public void createPlaylist() throws InterruptedException {
        WebElement newPlaylistName = driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
        newPlaylistName.click();
        WebElement clickPlusButton = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        clickPlusButton.click();
        WebElement typeNewName = driver.findElement(By.cssSelector("[name='name']"));
        typeNewName.sendKeys("TestNewPlaylist", Keys.RETURN);
        Thread.sleep(2000);

    }

    public void searchKeyWord(String songKeyWord) throws InterruptedException {
        //search for a song
        WebElement newQuery = driver.findElement(By.cssSelector("input[type='search']"));
        newQuery.click();
        newQuery.clear();
        newQuery.sendKeys(songKeyWord);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        // Click View All to display the search results
        WebElement viewAllBtn = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllBtn.click();
        Thread.sleep(2000);
    }

    public void selectFirstSong() throws InterruptedException {
        //Click the first song in the search results
        driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap search-results']//tr[@class='song-item']//td[@class='title']")).click();
        Thread.sleep(2000);
    }

    public void clickAddToBtn() throws InterruptedException {
        // Click ADD TO...
        driver.findElement(By.className("btn-add-to")).click();
        Thread.sleep(1000);

    }

    public void choosePlaylist() throws InterruptedException {
        //Choose the playlist to add it to (create a new playlist)
        WebElement playlistClickInMenu = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'TestNewPlaylist')]"));
        playlistClickInMenu.click();
        Thread.sleep(2000);
    }


    // Verify that the notification appears
    public String messageDisplay() throws InterruptedException {
        WebElement notificationRightTop = driver.findElement(By.cssSelector("div.success.show"));
        return notificationRightTop.getText();


    }

}



