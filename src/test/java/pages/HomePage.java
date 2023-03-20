package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistInputField = By.cssSelector("input[name='name']");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void doubleClickFirstPlaylist() {
        WebElement playlistNameTextField = findElement(playlistInputField);
        playlistNameTextField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistNameTextField.sendKeys(playlistName);
        playlistNameTextField.sendKeys(Keys.ENTER);
    }
    public void enterPlaylistName(String playlistName) {
        WebElement playlistNameTextField = findElement(playlistInputField);
        playlistNameTextField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistNameTextField.sendKeys(playlistName);
        playlistNameTextField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist(String playlistName) {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }
}
