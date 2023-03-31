package K_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AllSongsPage extends BasePage{
 @FindBy(css=".playlist:nth-child(3)")
WebElement playlistLocator;
protected @FindBy(css="input[name='name']")
   WebElement playlistInputFieldLocator;
    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    public void doubleClickOnPlaylist(){
        doubleClick(playlistLocator);
    }

    public  void enterPlaylistNewName (String playlistName) {
        WebElement playlistInputField = driver.findElement((By) playlistInputFieldLocator);
        playlistInputField.sendKeys((Keys.chord(Keys.chord(Keys.COMMAND, "a",Keys.BACK_SPACE))));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);

    }

    public void openPlaylist() {
        driver.findElement((By) playlistLocator).click();
    }



    public static boolean doesPlaylistExist (String playlistName) {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }


}
