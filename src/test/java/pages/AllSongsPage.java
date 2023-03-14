package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AllSongsPage extends BasePage{


    By allSongsElement = By.xpath("//*[@id='sidebar']/section[1]/ul/li[3]/a");
    By firstSong = By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]");
    By contextMenuAddTo = By.xpath("//*[@id='app']/nav/ul/li[4]");

    By contextMenuAddToPlaylist = By.xpath("//*[@id='app']/nav/ul/li[4]/ul/li[7]");


    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void clickAllSongsPage() {
        WebElement clickAllSongsLink = driver.findElement(allSongsElement);
        clickAllSongsLink.click();
    }
    public void addSongsToPlaylist(){
        WebElement chooseFirstSong = driver.findElement(firstSong);
        chooseFirstSong.click();
        WebElement clickContextMenuAddToPlaylist = driver.findElement(contextMenuAddTo);
        actions.contextClick(clickContextMenuAddToPlaylist).perform();
        WebElement contextMenuAddtoPlaylist = driver.findElement(contextMenuAddToPlaylist);
        actions.contextClick(contextMenuAddtoPlaylist).perform();

    }
    @Test
    public void addSong(){
        clickAllSongsPage();
        addSongsToPlaylist();
    }



    }


