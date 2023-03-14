package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IExpectedExceptionsHolder;

import java.time.Duration;

public class HomePage extends BasePage {
  static WebDriver driver;
   static WebDriverWait wait;
   String playlistName = "Sleepy Songs";

   private By userAvatarIcon = By.cssSelector("img.avatar");
   @FindBy(css = "i[title='Create a new playlist']")
   private WebElement newPlaylistIcon;
   @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
   private WebElement newPlaylist;
   @FindBy(css = "input[name='name']")
   private WebElement nameField;
   @FindBy(css = "[type='search'")
   private WebElement searchSong;
   @FindBy(css = "button[data-test = 'view-all-songs-btn']")
   private WebElement clickViewAllBtn;
   @FindBy(css = "section#songResultsWrapper tr.song-item td.title")
   private WebElement firstSong;
   @FindBy(css = "button[class = 'btn-add-to']")
   private WebElement addToButton;
   @FindBy(css = "li[class='playlist playlist'")
   private WebElement selectPlaylist;
   @FindBy(xpath = "//*[@id='playlistWrapper']/div/div/div[1]/table/tr/td[2]")
   private WebElement selectTheSong;
   @FindBy(xpath = "//*[@id= 'playlistWrapper']/div/div/div[1]/table/tr")
   private WebElement deleteSong;
   @FindBy(xpath = "//a[contains(text(), 'Sleepy Songs')]")
   private WebElement clickPlaylist;
   @FindBy(css = "button[title='Delete this playlist'")
   private WebElement clickPlaylistButton;
   @FindBy(css = "button[title='Delete this playlist'")
   private WebElement clickXPlaylistButton;
   @FindBy(css = ".playlist:nth-child(3)")
   private WebElement clickExistingPlaylist;
   @FindBy(xpath = "//a[contains(text(),'Active Songs')]")
   private WebElement choosePlaylist;
   @FindBy(css = "#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")
   private WebElement editButton;
   @FindBy(css = "input[name='name']")
   private WebElement enterPlaylistNames;
   @FindBy(xpath = "//*[@id= 'songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]")
   private WebElement clickPlaylistNameFromAddBtn;
   public HomePage(WebDriver givenDriver){ super(givenDriver);
      driver = givenDriver;
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   }
   public WebElement getUserAvatar(){
      return findElement(userAvatarIcon);
   }
   public HomePage createPlaylist(){
      wait.until(ExpectedConditions.visibilityOf(newPlaylistIcon)).click();
      wait.until(ExpectedConditions.visibilityOf(newPlaylist)).click();
      nameField.sendKeys((Keys.chord(playlistName, Keys.ENTER)));
      return this;
   }
   public static boolean newPlaylistIsDisplayed(){
      WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
              ("a[class='active']")));
      return newPlaylist.isDisplayed();
   }
   public HomePage searchASong(String songName){
      wait.until(ExpectedConditions.visibilityOf(searchSong)).sendKeys(songName);
      return this;
   }
   public HomePage clickViewAllButton(){
      wait.until(ExpectedConditions.visibilityOf(clickViewAllBtn)).click();
      return this;
   }
   public HomePage selectFirstSong(){
      wait.until(ExpectedConditions.visibilityOf(firstSong)).click();
      return this;
   }
   public HomePage clickAddToButton(){
      wait.until(ExpectedConditions.visibilityOf(addToButton)).click();
      return this;
   }
   public HomePage clickPlaylistNameFromAddToButton(String playlistName){
       wait.until(ExpectedConditions.visibilityOf(clickPlaylistNameFromAddBtn));
      clickPlaylistNameFromAddBtn.click();
      return this;
      }
    public static boolean notificationMessageIsDisplayed(){
        WebElement getNotificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("div.success.show")));
        return getNotificationMessage.isDisplayed();
    }

   public HomePage deleteSongFromPlaylist(){
      wait.until(ExpectedConditions.visibilityOf(selectPlaylist)).click();
      wait.until(ExpectedConditions.visibilityOf(selectTheSong)).click();
      wait.until(ExpectedConditions.visibilityOf(deleteSong)).click();
      actions.sendKeys(Keys.DELETE).perform();
      return this;
   }
   public HomePage clickUpdatedPlaylist(){
      wait.until(ExpectedConditions.visibilityOf(choosePlaylist)).click();
      return this;
   }
   public HomePage deleteExistingPlaylist(){
      wait.until(ExpectedConditions.visibilityOf(clickXPlaylistButton)).click();
      return this;
   }
   public static boolean getNotificationMessage(){
      WebElement notificationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
              ("div.success.show")));
      return notificationMessage.isDisplayed();
   }
   public HomePage contextClickExistingPlaylist(){
      WebElement existingPlaylist = wait.until(ExpectedConditions.visibilityOf(clickExistingPlaylist));
      actions.contextClick(existingPlaylist).perform();
      return this;
   }
   public HomePage chooseEdit(){
      editButton.click();
      return this;
   }
   public HomePage renamePlaylist(String newPlaylistName){
      wait.until(ExpectedConditions.visibilityOf(enterPlaylistNames));
      enterPlaylistNames.sendKeys((Keys.chord(Keys.CONTROL + "a",Keys.BACK_SPACE)),newPlaylistName,Keys.ENTER);
      return this;
   }
   public static boolean displayUpdatedPlaylist(String newPlaylistName){
      WebElement updatedPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
              ("//a[text()= '" +newPlaylistName+"']")));
      return updatedPlaylist.isDisplayed();
   }

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "avatar")
    public WebElement avatar;

    public void isUserAvatarDisplayed() {
        Assert.assertTrue(avatar.isDisplayed());
    }


}
