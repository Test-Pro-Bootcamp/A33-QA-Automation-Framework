import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Homework21 extends BaseTest {

    String playlistName = "Emiliia Music";

    @Test
    public void renamePlaylist()  {

        logIn();
        choosePlaylist();
        doubleClickOnPlaylist();
        enterPlaylistNewName();
        Assert.assertTrue(doesPlaylistExist());

    }

    public void enterPlaylistNewName() {
//
        WebElement playlistInputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-testid='inline-playlist-name-input']")));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistInputField).perform();
// Send keys to the playlist name element to enter a new name
        actions.sendKeys(Keys.chord(Keys.CONTROL), playlistName).perform();

// Press the Enter key to save the changes
        actions.sendKeys(Keys.ENTER).perform();

    }


    private void doubleClickOnPlaylist(){
        Actions action = new Actions(driver);
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        action.doubleClick(playlist).perform();

    }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }

    public boolean doesPlaylistExist() {
        WebElement playlistElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='" + playlistName + "']")));
        return playlistElement.isDisplayed();
    }
}