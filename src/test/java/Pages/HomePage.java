package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

By firstPlaylist = By.cssSelector("#playlists > ul > li:nth-child(4) > a");

    public HomePage(WebDriver givenDriver){
        super(givenDriver);

    }
    public void doubleClickFirstPlaylist(){
       actions.doubleClick(driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(4) > a")));
    }
    public void contextClickPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(4) > a")));
        WebElement playlistElement = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(4) > a"));
        actions.contextClick(playlistElement).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(4) > nav > ul > li:nth-child(1)"))).click();
    }
    public void enterPlaylistName(String PlaylistName){
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a" ,Keys.BACK_SPACE));
        playlistInputField.sendKeys("newPlaylistName");
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public Boolean verifyNewPlaylist(String PlaylistName){
        WebElement playlistElement1 = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[4]/a"));
        return playlistElement1.isDisplayed();
    }



}

