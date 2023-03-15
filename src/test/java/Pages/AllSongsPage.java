package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public AllSongsPage createPlaylist() {
        WebElement playlistbtn = driver.findElement(By.cssSelector("i[title='Create a new playlist']"));
        playlistbtn.click();
        WebElement playlistcontextmenu = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        playlistcontextmenu.click();
        WebElement inputplaylistname = driver.findElement(By.cssSelector("input[name='name']"));
        inputplaylistname.sendKeys("Test");
        inputplaylistname.sendKeys(Keys.ENTER);
        return this;

    }
    public AllSongsPage searchinput(){
        //input[type='search']
        WebElement searchfield = driver.findElement(By.cssSelector("input[type='search']"));
        searchfield.click();
        searchfield.sendKeys("dark");
        searchfield.sendKeys(Keys.ENTER);
        WebElement allsongsbnt = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        allsongsbnt.click();
        return this;

    }
    public AllSongsPage clickAllSongs() {
        WebElement allsongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        allsongs.click();
        return this;
    }
    public AllSongsPage addFirstSongToPlaylist(){
        WebElement song = driver.findElement(By.xpath("//tr/td[4]"));
        song.click();
        WebElement addbtn= driver.findElement(By.cssSelector(".btn-add-to"));
        addbtn.click();
        WebElement playlistbtn = driver.findElement(By.cssSelector("li[class='playlist']"));
        playlistbtn.click();
        return this;
    }
}
