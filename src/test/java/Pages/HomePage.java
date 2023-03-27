package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class HomePage extends BasePage {
By firstPlaylist = By.cssSelector("#playlists > ul > li:nth-child(4) > a");
By playlistInputField = By.cssSelector("input[name='name']");
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    public void doubleClickFirstPlaylist(){
       doubleClick(firstPlaylist);
    }
    public void enterPlaylistName(String PlaylistName){
        WebElement playlistNameTextField = driver.findElement(playlistInputField);
        playlistNameTextField.sendKeys(Keys.chord(Keys.CONTROL, "a" ,Keys.BACK_SPACE));
        playlistNameTextField.sendKeys("newPlaylistName");
        playlistNameTextField.sendKeys(Keys.ENTER);
    }
    public Boolean verifyNewPlaylist(String PlaylistName){
        WebElement playlistElement1 = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[4]/a"));
        return playlistElement1.isDisplayed();
    }
}
