package K_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.By.*;

public class AllSongsPage extends BasePage{
static By playlistLocator= cssSelector(".playlist:nth-child(3)");
static By playlistInputFieldLocator= cssSelector("input[name='name']");
    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    public void doubleClickOnPlaylist(){
        doubleClick(playlistLocator);
    }

    public  void enterPlaylistNewName (String playlistName) {
        WebElement playlistInputField = driver.findElement(playlistInputFieldLocator);
        playlistInputField.sendKeys((Keys.chord(Keys.chord(Keys.COMMAND, "a",Keys.BACK_SPACE))));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public void openPlaylist() {
        driver.findElement(playlistLocator).click();
    }



    public static boolean doesPlaylistExist (String playlistName) {
        WebElement playlistElement = driver.findElement(xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }


}
