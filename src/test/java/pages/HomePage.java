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

    @FindBy(css = "div.success.show")
    private WebElement popUpnotification;

    @FindBy(css = "i[class='fa fa-plus-circle create']")
    private WebElement playlistPlusBtn;

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement simplePlaylist;

    @FindBy(css = "[class='del btn-delete-playlist']")
    private WebElement deleteBtn;

    @FindBy(css = "button[class='ok']")
    private WebElement okBtn;

    @FindBy(css = "[class='home']")
    private WebElement homePage;

    @FindBy(xpath = "//*[@id='playlists']  //li[@class='playlist playlist']")
    private List<WebElement> playlistLocators;

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
        deleteBtn.click();
        return this;
    }

    public HomePage deleteFilledPlaylist() {
        deleteBtn.click();
        okBtn.click();
        return this;
    }

    public HomePage deleteFullPlaylist() {
        WebElement button = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        button.click();
        WebElement okbutton = driver.findElement(By.cssSelector("button[class='ok']"));
        okbutton.click();
        return this;
    }

    public HomePage openPlaylist() {
        playlistElement.click();
        return this;
    }

    public WebElement isPlaylistvisible() {
        return playlistElement;
    }

    public WebElement getNotification(){
        return popUpnotification;
    }

    public String confirmPlaylistNameChange(String searchText) {
        for (WebElement locator : playlistLocators) {
            if (locator.getText().contains(searchText)) {
                return "true";
            }
        }
        return "false";
    }
}
