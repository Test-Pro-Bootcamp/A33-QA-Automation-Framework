package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AllSongsPage extends BasePage {

    @FindBy(xpath = "//*[@id='sidebar']/section[1]/ul/li[3]/a")
    private WebElement allSongsElement;
    @FindBy(xpath ="//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]")
    private WebElement firstSong;
    @FindBy(xpath = "//*[@id='songsWrapper']//span/button[2]")
    private WebElement greenBtnAddTo;
    @FindBy(xpath ="//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]")
    private  WebElement contextMenuAddToPlaylist;

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public AllSongsPage clickAllSongsPage() {
        allSongsElement.click();
        return this;
    }

    public AllSongsPage addSongsToPlaylist() {
        clickAllSongsPage();
        firstSong.click();
        greenBtnAddTo.click();
        contextMenuAddToPlaylist.click();
        return this;
    }

    public void addSong() {
        clickAllSongsPage();
        addSongsToPlaylist();
    }
}