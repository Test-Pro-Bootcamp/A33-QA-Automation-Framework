package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class HomePage extends BasePage {

@FindBy (css = "#playlists > ul > li:nth-child(4) > a")
WebElement firstPlaylist;
@FindBy (css = "input[name='name']")
WebElement playlistInputField;
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    public void doubleClickFirstPlaylist(){

       doubleClick(firstPlaylist);
    }
    public void enterPlaylistName(String PlaylistName){

        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a" ,Keys.BACK_SPACE));
        playlistInputField.sendKeys("newPlaylistName");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public Boolean verifyNewPlaylist(String PlaylistName){
        WebElement playlistElement1 = driver.findElement(By.xpath("//a[text()='"+ PlaylistName +"']"));
        return playlistElement1.isDisplayed();
    }
}
