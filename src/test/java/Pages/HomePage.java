package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    private String playlistName = "Med23";
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(css = "[class='fa fa-plus-circle create']")
    private WebElement newPlaylistIcon;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylist;
    @FindBy(css = "input[name='name']")
    private WebElement nameField;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public WebElement getUserAvatar(){
        return wait.until(ExpectedConditions.visibilityOf(userAvatarIcon));
    }
    public HomePage createPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistIcon)).click();
        wait.until(ExpectedConditions.visibilityOf(newPlaylist)).click();
        wait.until(ExpectedConditions.visibilityOf(nameField)).sendKeys((Keys.chord(playlistName,Keys.ENTER)));
        return this;
    }
    public boolean newPlaylistIsDisplayed(){
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("a[class='active']")));
        return newPlaylist.isDisplayed();    }
}
