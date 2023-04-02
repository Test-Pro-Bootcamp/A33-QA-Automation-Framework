package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    private static Boolean playlistExists = Boolean.FALSE;

    //WebElements
    @FindBy (css = "#playlists")
    protected WebElement playlists;
    @FindBy (css = "nav.menu.playlist-item-menu ul")
    protected WebElement plsContextMenu;
    @FindBy (css = "li.playlist.playlist.editing input")
    protected WebElement newPlaylist;
    @FindBy (css = "div.success.show")
    protected WebElement notificationMessage;
    @FindBy (css = "div.success.show:nth-child(2)")
    protected WebElement notificationMessageChild2;
    @FindBy (css = "#homeWrapper")
    protected WebElement songsOnHomePage;
    @FindBy (css = "#songsWrapper")
    protected WebElement allSongs;
    @FindBy (css = "#playlistWrapper")
    protected WebElement playlistSongs;
    @FindBy (css = "img[alt = 'Sound bars']")
    protected WebElement soundBar;
    @FindBy (css = "li[data-testid *= 'playlist-context-menu-edit']")
    protected WebElement editPlaylist;
    @FindBy (css = "#sidebar a.songs")
    protected WebElement chooseAllSongs;
    @FindBy (css = "i[title='Create a new playlist']")
    protected WebElement createPlstButton;
    @FindBy (css = "li[data-testid='playlist-context-menu-create-simple']")
    protected WebElement createNewPlst;
    @FindBy (css = "#playlistWrapper button.del.btn-delete-playlist")
    protected WebElement deletePlstButton;
    @FindBy (css = "span.play>i")
    protected WebElement playSongButton;
    @FindBy (css = "#songResultsWrapper  tr > td.title")
    protected WebElement firstSongInSearch;
    @FindBy (css = "#songsWrapper tr > td.title")
    protected WebElement firstSong;
    @FindBy (css = "button.btn-add-to")
    protected WebElement addToPlstButton;
    @FindBy (css = "div.alertify button.ok")
    protected WebElement alertButtonOK;
//    @FindBy (css = "")
//    protected WebElement qweqweqweqewq;

    public HomePage(WebDriver submittedDriver) {
        super(submittedDriver);
    }

    public String updatePlaylist (String playlistToChange, String newPlaylistName) {
        //choosing and clicking the playlist that we want to change the name of
        wait.until(ExpectedConditions.visibilityOf(playlists));
        String xpathSelector = "//section[@id='playlists']//a[contains(text(),'" + playlistToChange + "')]";
        WebElement plstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSelector)));
        clickElement(plstElement);

        //editing the name of the playlist through context menu
        contextClickElement(plstElement);
        wait.until(ExpectedConditions.visibilityOf(plsContextMenu));
        clickElement(editPlaylist);

        newPlaylist.sendKeys(Keys.CONTROL + "a"); newPlaylist.sendKeys(Keys.DELETE);
        newPlaylist.sendKeys(newPlaylistName); newPlaylist.sendKeys(Keys.ENTER);

        //checking the notification message
        String msg = wait.until(ExpectedConditions.visibilityOf(notificationMessage)).getText();
        System.out.println(msg);
        return msg;
    }

    public String createThePlaylist (String playlist) {
//        wait.until(ExpectedConditions.visibilityOf(songsOnHomePage));
        /*clickElement(createPlstButton);
        wait.until(ExpectedConditions.visibilityOf(createNewPlst));
        clickElement(createNewPlst);*/
        wait.until(ExpectedConditions.visibilityOf(songsOnHomePage));
        clickElement(chooseAllSongs);
        clickElement(firstSong);
        clickElement(addToPlstButton);

        //type in the name of a new playlist and create it
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(
                                            By.cssSelector("#songsWrapper input[data-test='new-playlist-name']")));
        newPlaylist.sendKeys(playlist);
        newPlaylist.sendKeys(Keys.ENTER);

        //Checking the notification message
        String msg;
        msg = wait.until(ExpectedConditions.visibilityOf(notificationMessage)).getText();
        System.out.println("Message is: " + msg);
        return msg;
    }

    public void selectPlaylist (String playlist){
        wait.until(ExpectedConditions.visibilityOf(songsOnHomePage));
        String xpathSelector = "//section[@id='playlists']//a[contains(text(),'" + playlist + "')]";
        WebElement plstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSelector)));
        clickElement(plstElement);
        playlistExists = Boolean.TRUE;
        wait.until(ExpectedConditions.visibilityOf(playlistSongs));
        System.out.println("Playlist " + playlist + " has been selected");
    }

    public String deleteSelectedPlaylist(){
        clickElement(deletePlstButton);

        String msg = "";
        if (playlistExists) {
            clickElement(alertButtonOK);
            msg = wait.until(ExpectedConditions.visibilityOf(notificationMessage)).getText();
            playlistExists = Boolean.FALSE;
        }
        System.out.println("Message is: " + msg);
        return msg;
    }

    public HomePage playNextSong () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("i[title = 'Play next song']")
        )).click();
        clickElement(playSongButton);
        return this;
    }

    public Boolean isPlaying () {  //verifying by checking whether the sound bar is displayed
        return wait.until(ExpectedConditions.visibilityOf(soundBar)).isDisplayed();
    }

    public HomePage searchSong (String song){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.main-scroll-wrap")));
        WebElement songEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type = 'search']")));
        songEl.clear();
        String url = driver.getCurrentUrl();
        System.out.println("searching for " + song + " in " + url);
        songEl.sendKeys(song);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.results")));
        return this;
    }

    public HomePage viewSearchedSong () {
        //view all results for songs
        WebElement searchResult = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("section.songs h1 button")
        ));
        searchResult.click();
        String url = driver.getCurrentUrl();
        System.out.println("searching in " + url);
        clickElement(firstSongInSearch);
        return this;
    }

    public String clickAddToPls (String playlist) {
        clickElement(addToPlstButton);
        String xpathSelector = "//section[@id='songResultsWrapper']//li[contains(text(),'" + playlist + "')]";
        WebElement plstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSelector)));
        clickElement(plstElement);
        String msg = wait.until(ExpectedConditions.visibilityOf(notificationMessage)).getText();
        System.out.println(msg);
        return msg;
    }

}
