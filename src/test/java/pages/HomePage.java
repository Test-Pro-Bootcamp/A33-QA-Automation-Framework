package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import static org.openqa.selenium.By.cssSelector;

public class HomePage extends BasePage {
    String newPlayListName = "New Playlist";

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    //locators
    private By playList = By.xpath(("//*[@id=\"playlists\"]/ul/li[3]/a"));
    private By xButton = cssSelector(("button[title='Delete this playlist']"));
    private By editOption = By.xpath(("//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[1]"));;
    private By textField = cssSelector(("input[name='name']"));
    private By avatarIcon = cssSelector(("img.avatar"));
    private By newPlayList = By.cssSelector("li>a.active");
    private By successMessage = By.cssSelector("#nprogress");

    public void clickPlayList() {
        WebElement clickOnPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(playList));
        actions.contextClick(clickOnPlaylist).perform();
    }
    public void chooseEdit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editOption)).click();
    }
    public void renamePlayListName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textField));
        WebElement textBox = driver.findElement(textField);
        textBox.sendKeys((Keys.chord(Keys.COMMAND,"a",Keys.SPACE)));
        textBox.sendKeys(name);
        textBox.sendKeys(Keys.ENTER);
    }
    public boolean verifyNewPlayListNameUpdated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        WebElement newPlaylistName = driver.findElement(successMessage);
        return newPlaylistName.isDisplayed();
    }
    public boolean verifyAvatarIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatarIcon));
        WebElement findAvatar = driver.findElement(avatarIcon);
        return findAvatar.isDisplayed();
    }
    public void clickXPlaylist() {
        WebElement clickX = wait.until(ExpectedConditions.elementToBeClickable(xButton));
        clickX.click();
    }
    public void clickPlaylistToDelete() {
        WebElement deleteElement = wait.until(ExpectedConditions.elementToBeClickable(playList));
        deleteElement.click();
    }
}