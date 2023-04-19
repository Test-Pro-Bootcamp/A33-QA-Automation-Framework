package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;
public class HomePage extends BasePage {
    @FindBy (css = "[img.avatar]")
    WebElement userAvatarIcon;
    @FindBy (xpath = "//*[@id=\"playlists\"]/ul/li[3]/a")
    private WebElement thirdPlaylist;
    @FindBy  (xpath = "//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[1]")
    private WebElement editBtn;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public HomePage rightClickThirdPlaylist() {
        actions.contextClick(thirdPlaylist).perform();
        return this;
    }
    public HomePage clickEditBtn() {
        actions.click(editBtn).perform();
        return this;
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
//    public WebElement getUserAvatar() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
//    }
}
