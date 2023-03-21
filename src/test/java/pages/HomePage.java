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
        wait.until(ExpectedConditions.visibilityOf(playList));
        actions.contextClick(playList).perform();
    }
    public void chooseEdit() {
        wait.until(ExpectedConditions.visibilityOf(editOption)).click();
    }
    public void renamePlayListName(String name) {
        textField.sendKeys((Keys.chord(Keys.COMMAND,"a",Keys.SPACE)));
        textField.sendKeys(name);
        textField.sendKeys(Keys.ENTER);
    }
    public boolean verifyNewPlayListNameUpdated() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }
    public boolean verifyAvatarIcon(){
        wait.until(ExpectedConditions.visibilityOf(avatarIcon));
        return avatarIcon.isDisplayed();
    }
    public void clickXPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(xButton));
        xButton.click();
    }
    public void clickPlaylistToDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(playList));
        playList.click();
    }
    public static boolean verifyNotification(){
        wait.until(ExpectedConditions.visibilityOf(notificationMessage));
        return notificationMessage.isDisplayed();
    }
}
