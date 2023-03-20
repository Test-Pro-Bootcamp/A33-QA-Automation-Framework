package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Homepage extends Basepage {
   private By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
   private By playlistInputField = By.cssSelector("input[name='name']");

    public Homepage(WebDriver givenDriver){
        super(givenDriver);
    }

public void doubleClickFirstPlaylist() {
    doubleClick(firstPlaylist);
}

    private void doubleClick(By firstPlaylist) {
    }

    public void enterPlaylistName(String playlistName){
    WebElement PlaylistNameTextField = driver.findElement(playlistInputField);
    PlaylistNameTextField.sendKeys((Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE)));
    PlaylistNameTextField.sendKeys(playlistName);
    PlaylistNameTextField.sendKeys(Keys.ENTER);

}
public boolean doesPlaylistExist(String playlistName){
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
}

    public void doubleCLickFirstPlaylist() {
        doubleClick(firstPlaylist);
    }
}


