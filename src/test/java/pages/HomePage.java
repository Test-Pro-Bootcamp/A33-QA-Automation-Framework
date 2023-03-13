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

    WebElement playlistElement = null;

    @FindBy(css = "input[name='name']")
    WebElement playlistInputfield;

    @FindBy(css = "div.success.show")
    WebElement popUpnotification;


    @FindBy(css = "i[class='fa fa-plus-circle create']")
    WebElement playlistPlusBtn;

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement simplePlaylist;

    @FindBy(css = "[class='del btn-delete-playlist']")
    WebElement deleteBtn;

    @FindBy(css = "button[class='ok']")
    WebElement okBtn;

    @FindBy(css = "[class='home']")
    WebElement homePage;

    @FindBy(xpath = "//*[@id='playlists']  //li[@class='playlist playlist']")
    List<WebElement> playlistLocators;


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }


    public void openHome() {
        homePage.click();
    }
    public void reinitializePlaylistLocators() {
        PageFactory.initElements(driver, this);
        //playlistLocators = driver.findElements(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a"));
    }

    public void createPlaylist(String name) {
        wait.until(ExpectedConditions.visibilityOf(playlistPlusBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(simplePlaylist)).click();
        inputPlaylistName(name);
        reinitializePlaylistLocators();
    }

    public void inputPlaylistName(String name) {
        wait.until(ExpectedConditions.visibilityOf(playlistInputfield));
        playlistInputfield.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE),name, Keys.ENTER);
    }

    public void findPlaylist(String searchText) {
        WebElement testPlaylist = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
        playlistElement = testPlaylist;
        List<WebElement> locators  = getPlaylistLocators();
        //for (WebElement locator : playlistLocators) {
        //    if (locator.getText().contains(searchText)) {
        //        playlistElement = locator;
        //        break;
        //    }
        //}
        //createPlaylist(searchText);
        //findPlaylist(searchText);
    }

    private List<WebElement> getPlaylistLocators() {
        return playlistLocators;
    }

    public void startRenamingPlaylist() {
        doubleClickElement(playlistElement);
    }

    public WebElement getPlaylistElement(){
        return playlistElement;
    }

    public void deleteEmptyPlaylist() {
        deleteBtn.click();
    }

    public void deleteFilledPlaylist() {
        deleteBtn.click();
        okBtn.click();
    }

    public void deleteFullPlaylist() {
        WebElement button = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        button.click();
        WebElement okbutton = driver.findElement(By.cssSelector("button[class='ok']"));
        okbutton.click();
    }

    public void openPlaylist() {
        playlistElement.click();
    }

    public WebElement isPlaylistvisible(String searchText) {
        WebElement testPlaylist = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
        return testPlaylist;
        //return playlistElement.isDisplayed();
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
