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
    @FindBy (css = "nav.menu.playlist-item-menu")
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

    public HomePage(WebDriver submittedDriver) {
        super(submittedDriver);
    }

    public String updatePlaylist (String playlistToChange, String newPlaylistName) {
        //choosing and clicking the playlist that we want to change the name of
        wait.until(ExpectedConditions.visibilityOf(playlists));
        String xpathSelector = "//section[@id='playlists']//a[contains(text(),'" + playlistToChange + "')]";
        clickElement(By.xpath(xpathSelector));

        //editing the name of the playlist through context menu
        contextClickElement(By.xpath(xpathSelector));
        wait.until(ExpectedConditions.visibilityOf(plsContextMenu));
        clickElement(By.cssSelector("li[data-testid *= 'playlist-context-menu-edit']"));

        newPlaylist.sendKeys(Keys.CONTROL + "a"); newPlaylist.sendKeys(Keys.DELETE);
        newPlaylist.sendKeys(newPlaylistName); newPlaylist.sendKeys(Keys.ENTER);

        //checking the notification message
        String msg = wait.until(ExpectedConditions.visibilityOf(notificationMessage)).getText();
        System.out.println(msg);
        return msg;
    }

    private void createPlaylist (String playlist) {
        wait.until(ExpectedConditions.visibilityOf(songsOnHomePage));
        clickElement(By.cssSelector("#sidebar a.songs"));
        wait.until(ExpectedConditions.visibilityOf(allSongs));
        clickElement(By.cssSelector("#songsWrapper  tr > td.title"));
        clickElement(By.cssSelector("div.song-list-controls button.btn-add-to"));

        //type in the name of a new playlist and create it
        WebElement newPlaylist = driver.findElement(By.cssSelector("section.new-playlist input"));
        newPlaylist.sendKeys(playlist);
        newPlaylist.sendKeys(Keys.ENTER);
    }

    public void selectPlaylist (String playlist){
        try {
            String xpathSelector = "//section[@id='playlists']//a[contains(text(),'" + playlist + "')]";
            clickElement(By.xpath(xpathSelector));
            playlistExists = Boolean.TRUE;
            wait.until(ExpectedConditions.visibilityOf(playlistSongs));
            System.out.println("Playlist " + playlist + " has been selected");
        } catch (Exception e) {
            //if there is no playlist with the given name then we create a new playlist with that name
            createPlaylist(playlist);
            System.out.println("Playlist " + playlist + " has been created and selected");
        }
    }

    public String deleteSelectedPlaylist(){
        clickElement(By.cssSelector("#playlistWrapper button.del.btn-delete-playlist"));

        String msg;
        if (playlistExists) {
            msg = wait.until(ExpectedConditions.visibilityOf(notificationMessage)).getText();
        } else {
            clickElement(By.cssSelector("div.alertify button.ok"));
            msg = wait.until(ExpectedConditions.visibilityOf(notificationMessageChild2)).getText();
        }
        System.out.println("Message is: " + msg);
        return msg;
    }

    public HomePage playNextSong () {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("i[title = 'Play next song']")
        )).click();
        clickElement(By.cssSelector("span.play>i"));
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
        System.out.println("searching for in " + url);
        clickElement(By.cssSelector("#songResultsWrapper  tr > td.title"));
        return this;
    }

    public String clickAddToPls (String playlist) {
        clickElement(By.cssSelector("#songResultsWrapper button.btn-add-to"));
        String xpathSelector = "//section[@id='songResultsWrapper']//li[contains(text(),'" + playlist + "')]";
        clickElement(By.xpath(xpathSelector));
        String msg = wait.until(ExpectedConditions.visibilityOf(notificationMessage)).getText();
        System.out.println(msg);
        return msg;
    }

}
