package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistInputField = By.xpath("//input[@data-testid='inline-playlist-name-input']");

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    public void doubleClickFirstPlaylist() {
        WebElement FP = driver.findElement(firstPlaylist);
        doubleClick(FP);
    }

    public void enterPlaylistName(String playlistName) {
        WebElement playlistnameTextField = driver.findElement(playlistInputField);
        playlistnameTextField.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        playlistnameTextField.sendKeys(playlistName);
        playlistnameTextField.sendKeys(Keys.ENTER);
    }

    public boolean ifNewPlaylistExists(){
        WebElement newPlaylistName = driver.findElement(By.xpath("//a[text()='"+"Ferrari"+"']"));
        return newPlaylistName.isDisplayed();
    }






}
