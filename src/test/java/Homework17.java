import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class Homework17 extends LoginTests {

    @Test
    public void addSongToPlaylist() {

        String playlistname = "test";
        loginValidAccount("Test321@gmail.com", "te$t$tudent");
        //deleteAddedSongPlaylist(playlistname);
        //clickCreatePlaylist();
        //inputPlaylist();
        //enterPress();
        //openHomeURL();
        clickViewAll();
        clickFirstSong();
        clickAddto();
        clickPlaylistfromAddto(playlistname);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getSuccessPopup()));
        System.out.println(getSuccessNotif());
        Assert.assertEquals(getSuccessNotif(), "Added 1 song into \"" + playlistname + ".\"");
        //Clean up and delete the first song from test playlist... so I can run this again
        deleteAddedSongPlaylist(playlistname);
    }

    private void loginValidAccount(String email, String password) {
        openLoginURL();
        inputEmail(email);
        inputPassword(password);
        clickLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(koelHome));
    }

    private void clickViewAll() {
        WebElement viewallButton = driver.findElement(By.cssSelector("button[data-testid='home-view-all-recently-played-btn']"));
        viewallButton.click();
    }

    private void clickFirstSong() {
            WebElement firstSong = driver.findElement(By.cssSelector("#recentlyPlayedWrapper [class='song-item']:nth-child(1)"));
            firstSong.click();
    }

    private void clickAddto() {
        WebElement Addto = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        Addto.click();
    }

    private void clickPlaylistfromAddto(String searchText) {
        WebElement playlistAddto = driver.findElement(By.xpath("//*[@id='recentlyPlayedWrapper'] //li[contains(text(),'" + searchText + "')]"));
        //WebElement playlistAddto = driver.findElement(By.cssSelector("#recentlyPlayedWrapper [class='existing-playlists'] [class='playlist']"));
        playlistAddto.click();
    }

    private String getSuccessNotif(){
        return driver.findElement(By.cssSelector("[class='success show']")).getText();
    }

    private WebElement getSuccessPopup(){
        return driver.findElement(By.cssSelector("[class='success show']"));
    }

    private void deleteAddedSongPlaylist(String searchText){
        WebElement testPlaylist = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
        //WebElement testPlaylist = driver.findElement(By.cssSelector("#playlists li[class='playlist playlist'] a"));
        testPlaylist.click();
        WebElement song_to_select = driver.findElement(By.cssSelector("#playlistWrapper [class='song-item']:nth-child(1)"));
        song_to_select.click();
        WebElement song_to_delete = driver.findElement(By.cssSelector("#playlistWrapper [class='song-item selected']:nth-child(1)"));
        //song_to_delete.sendKeys(Keys.BACK_SPACE);
        Actions actions = new Actions(driver);
        actions.moveToElement(song_to_delete).click().sendKeys(Keys.DELETE).perform();
    }
}
