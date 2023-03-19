package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{

    private WebElement playlistElement = null;

    @FindBy(css = "input[name='name']")
    private WebElement playlistInputfield;

    @FindBy(css = "div[class='success show']")
    private WebElement popUpnotification;

    //<div class="success show">Added 1 song into "xxx."</div>

    @FindBy(css = "i[role='button']")
    private WebElement playlistPlusBtn;

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement simplePlaylist;

    @FindBy(css = "button[title='Delete this playlist']")
    private WebElement deleteBtn;

    @FindBy(css = "button[class='ok']")
    private WebElement okBtn;

    @FindBy(css = "[class='home']")
    private WebElement homePage;

    @FindBy(xpath = "//*[@id='playlists']  //li[@class='playlist playlist']")
    private List<WebElement> playlistLocators;

    @FindBy(xpath = "//*[@id='playlists']  //li[@class='playlist playlist'] //a[@class='active']")
    private WebElement activePlaylist;

    @FindBy(className = "avatar")
    private WebElement avatar;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }


    public HomePage openHome() {
        homePage.click();
        return this;
    }

    private void openHomeSelf() {
        driver.get(koelHome);
    }

    public String getkoelHomePage() {
        return koelHome;
    }

    private HomePage reinitializePlaylistLocators() {
        PageFactory.initElements(driver, this);
        return this;
        }

    private List<WebElement> getPlaylistLocators() {
        return playlistLocators;
    }

    public HomePage createPlaylist(String name) {
        wait.until(ExpectedConditions.visibilityOf(playlistPlusBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(simplePlaylist)).click();
        inputPlaylistName(name);
        reinitializePlaylistLocators();
        return this;
    }

    public HomePage inputPlaylistName(String name) {
        wait.until(ExpectedConditions.visibilityOf(playlistInputfield));
        playlistInputfield.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE),name, Keys.ENTER);
        return this;
    }

    public HomePage findPlaylist(String searchText) {
        //WebElement testPlaylist = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
        //playlistElement = testPlaylist;
        List<WebElement> locators  = getPlaylistLocators();
        for (WebElement locator : playlistLocators) {
            if (locator.getText().contains(searchText)) {
                playlistElement = locator;
                break;
            }
        }
        if (playlistElement == null){
            createPlaylist(searchText);
            openHomeSelf();
            findPlaylist(searchText);
        }
        return this;
    }

    public HomePage startRenamingPlaylist() {
        wait.until(ExpectedConditions.visibilityOf(playlistElement));
        doubleClickElement(playlistElement);
        return this;
    }

    public WebElement getPlaylistElement(){
        return playlistElement;
    }

    public HomePage deleteEmptyPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable((deleteBtn)));
        deleteBtn.click();
        return this;
    }

    public HomePage deleteFilledPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable((deleteBtn)));
        deleteBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable((okBtn)));
        okBtn.click();
        return this;
    }

    public HomePage deleteFullPlaylist() {
        WebElement button = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        button.click();
        WebElement okButton = driver.findElement(By.cssSelector("button[class='ok']"));
        okButton.click();
        return this;
    }

    public HomePage openPlaylist() {
        playlistElement.click();
        return this;
    }

    public WebElement isPlaylistvisible() {
        return playlistElement;
    }

    public WebElement isUserAvatarDisplayed() {
        return avatar;
    }

    public WebElement getNotification(){
        return popUpnotification;
    }

    public String getSuccessNotif(){
        return popUpnotification.getText();
    }

    public boolean confirmPlaylistNameChange(String searchText) {
        if (activePlaylist.getText().contains(searchText)) {
                return true;
            }
        else {
            return false;
        }
    }

    public HomePage startRenameActivePlaylist() {
        wait.until(ExpectedConditions.visibilityOf(activePlaylist));
        doubleClickElement(activePlaylist);
        return this;
    }
}
