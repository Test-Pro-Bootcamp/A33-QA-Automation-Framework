package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private String playlistName = "HW22";
    private By userAvatarIcon = By.cssSelector("img.avatar");
    private By newPlaylistIcon = By.cssSelector("i[title='Create a new playlist']");
    private By newPlaylist = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    private By nameField = By.cssSelector("input[name='name']");
    private By searchSong = By.cssSelector("[type='search'");
    private By clickViewAllBtn = By.cssSelector("button[data-test = 'view-all-songs-btn']");
    private By firstSong = By.cssSelector("section#songResultsWrapper tr.song-item td.title");
    private By addToButton = By.cssSelector("button[class = 'btn-add-to']");
    private By clickPlaylistNameFromAddToBtn = By.xpath
            ("//section[@id='songResultsWrapper']//section/ul//li[contains(text(), ' " + playlistName + "')]");
    private By selectPlaylist = By.cssSelector("li[class='playlist playlist'");
    private By selectTheSong = By.xpath("//*[@id='playlistWrapper']/div/div/div[1]/table/tr/td[2]");
    private By deleteSong = By.xpath("//*[@id= 'playlistWrapper']/div/div/div[1]/table/tr");
    private By clickXPlaylistButton = By.cssSelector("button[title='Delete this playlist'");
    private By clickExistingPlaylist = By.cssSelector(".playlist:nth-child(3)");
    private By choosePlaylist = By.xpath("//a[contains(text(),'Active Songs')]");
    private By editButton = By.cssSelector("#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)");
    private By enterPlaylistNames = By.cssSelector("input[name='name']");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (userAvatarIcon));
    }

    public void createPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistIcon)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPlaylist)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys
                ((Keys.chord(playlistName, Keys.ENTER)));
    }

    public static boolean newPlaylistIsDisplayed() {
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("a[class='active']")));
        return newPlaylist.isDisplayed();
    }

    public void searchASong(String songName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchSong)).sendKeys(songName);
    }

    public void clickViewAllButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickViewAllBtn)).click();
    }

    public void selectFirstSong() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSong)).click();
    }

    public void clickAddToButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToButton)).click();
    }

    public void clickPlaylistNameFromAddToButton(String playlistName) {
        wait.until(ExpectedConditions.elementToBeClickable(clickPlaylistNameFromAddToBtn)).click();
    }

    public static boolean notificationMessageIsDisplayed() {
        WebElement getNotificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("div.success.show")));
        return getNotificationMessage.isDisplayed();
    }

    public void deleteSongFromPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectPlaylist)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectTheSong)).click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteSong)).click();
        actions.sendKeys(Keys.DELETE).perform();
    }

    public void contextClickExistingPlaylist() {
        contextClick(clickExistingPlaylist);
    }

    public void chooseEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }

    public void renamePlaylist(String newPlaylistName) {
        WebElement enterPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(enterPlaylistNames));
        enterPlaylistName.sendKeys((Keys.chord(Keys.CONTROL + "a",Keys.BACK_SPACE)));
        enterPlaylistName.sendKeys(newPlaylistName);
        enterPlaylistName.sendKeys(Keys.ENTER);
    }

    public static boolean displayUpdatedPlaylist(String newPlaylistName) {
        WebElement updatedPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//a[text()= '" + newPlaylistName + "']")));
        return updatedPlaylist.isDisplayed();
    }
}

