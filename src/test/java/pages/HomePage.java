package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    @FindBy(css = "button[title='Delete this playlist']")
    WebElement xButton;
    @FindBy(css = "input[name='name']")
    WebElement textField;
    @FindBy(css = "img.avatar")
    WebElement avatarIcon;
    @FindBy(css = "li>a.active")
    WebElement newPlayList;
    @FindBy(css = "#nprogress")
    WebElement successMessage;
    @FindBy(css = "div.success.show")
    static WebElement notificationMessage;
    @FindBy(xpath = "//*[@id=\"playlists\"]/ul/li[3]/a")
    WebElement playList;
    @FindBy(xpath = "//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[1]")
    WebElement editOption;
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
    public static boolean verifyNotification(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationMessage));
        WebElement messageElement = driver.findElement((notificationMessage));
        return messageElement.isDisplayed();
    }
}