import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Instant;

public class Homework21 {
    String playlistName = "Test Pro Playlist";

    @Test
    public void renamePlaylist() {
        logIn();
        choosePlaylist();
        contextClickChoosePlaylist();
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
    }
    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }
    public void contextClickChoosePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        action.contextClick(playlistElement).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']"))).click();
    }
    public void enterPlaylistName() {
        WebElement playlistInputField = driver.findELement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+playlistName"']"));
        return  playlistElement.isDisplayed();
    }
}
