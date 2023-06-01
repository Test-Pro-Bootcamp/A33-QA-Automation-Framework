import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {

    
    WebDriver driver;
    WebDriverWait wait;

    By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }


    public void enterPlaylistName(String playlistName) {
        WebElement playlistNameTextField;
        playlistNameTextField = (WebElement) BaseTest.driver.findElements(By.xpath("playlistInputTextField"));
        playlistNameTextField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistNameTextField.sendKeys(playlistName);
        playlistNameTextField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlayListExit(String playlistName) {
        WebElement playlistElement = BasePage.driver.findElement(By.xpath("//a[text()= '" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("playlist:nth-child(3)"))).click();

    }
    public void doubleClickFirstPlayList() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector("playlist:nth-child(3)"));
        actions.doubleClick(playlistElement).perform();
    }
}