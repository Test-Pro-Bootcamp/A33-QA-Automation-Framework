package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class HomePage extends BasePage {
    private By userAvatarIcon = By.cssSelector("[img.avatar]");
    private By thirdPlaylist = By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a");
    private By playlistInputField = By.xpath("//input[@name='name']");
    private By editBtn = By.xpath("//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[1]");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void rightClickThirdPlaylist() {
        contextClick (thirdPlaylist);
    }
    public void clickEditBtn() {
        actions.click(findElement(editBtn)).perform();
    }

    public void renamePlaylist(String playlistName) {
        Actions action = new Actions(driver);
        WebElement playlistInputField = driver.findElement(By.xpath("//input[@name='name']"));
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean isPlaylistRenamed(String playlistName) {
        WebElement playlistRename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        return playlistRename.isDisplayed();
    }
    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }
}
