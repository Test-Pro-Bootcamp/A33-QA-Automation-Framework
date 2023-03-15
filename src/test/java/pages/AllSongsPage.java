package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AllSongsPage extends BasePage {
    String NewNameTest = "Renamed Playlist";
    private By allSongsElement = By.xpath("//*[@id='sidebar']/section[1]/ul/li[3]/a");
    public By firstSong = By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]");
    private By greenBtnAddTo = By.xpath("//*[@id='songsWrapper']//span/button[2]");
    private By contextMenuAddToPlaylist = By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]");

    ///*[@id='app']/nav//li[4]//li[7]
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void clickAllSongsPage() {
        WebElement clickAllSongsLink = wait.until(ExpectedConditions.elementToBeClickable(allSongsElement));
        clickAllSongsLink.click();
    }

    public void addSongsToPlaylist() {
        clickAllSongsPage();
        WebElement chooseFirstSong = wait.until(ExpectedConditions.elementToBeClickable(firstSong));
        chooseFirstSong.click();
        WebElement clickGreenBtnToAdd = wait.until(ExpectedConditions.elementToBeClickable(greenBtnAddTo));
        clickGreenBtnToAdd.click();
        WebElement contextMenuAddtoPlaylist = wait.until(ExpectedConditions.elementToBeClickable(contextMenuAddToPlaylist));
        contextMenuAddtoPlaylist.click();
    }

    public void addSong() {
        clickAllSongsPage();
        addSongsToPlaylist();
    }
}