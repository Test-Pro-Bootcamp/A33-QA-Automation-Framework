import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.Keys.RETURN;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotificationText = "Added 1 song into";

        navigateToPage();
        provideEmail("andytstith@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        createPlaylist();
        searchSong("dark days");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        deletePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));

    }
    public void searchSong (String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(2000);

    }
    public void clickViewAllBtn () throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResult.click();
        Thread.sleep(2000);

    }
    public void selectFirstSongResult () throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
        Thread.sleep(2000);
    }
    public void clickAddToBtn () throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(2000);
    }
    public void choosePlaylist () throws InterruptedException {
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'New Playlist')]"));
        playlistElement.click();
        Thread.sleep(2000);
    }
    public String getNotificationText() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }

    public void deletePlaylist () throws InterruptedException {
        WebElement clickDeletePlaylistElement = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        clickDeletePlaylistElement.click();
        WebElement deletePlaylistElement = driver.findElement(By.xpath("//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']"));
        deletePlaylistElement.click();
        WebElement okButtonElement = driver.findElement(By.xpath("//nav/button[@class='ok']"));
        okButtonElement.click();
        Thread.sleep(2000);
    }
    public void createPlaylist () throws InterruptedException {
        WebElement createBtn = driver.findElement(By.xpath("//i[@class='fa fa-plus-circle create']"));
        createBtn.click();
        Thread.sleep(2000);
        WebElement newPlaylistBtn = driver.findElement(By.xpath("//nav/ul/li[contains(text(),'New Playlist')]"));
        newPlaylistBtn.click();
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.sendKeys("New Playlist");
        driver.findElement(By.xpath("//input[@name='name']"));
        (nameField).sendKeys(RETURN);
        Thread.sleep(2000);
    }
}