package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class AllSongsPage extends BasePage {

    Actions actions = new Actions(driver);
    @FindBy(xpath = "//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]")
    private WebElement firstSong;
    @FindBy(xpath = "//*[@id='songsWrapper']//span/button[2]")
    private WebElement greenBtnAddTo;
    @FindBy(xpath = "//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]")
    private WebElement contextMenuAddToPlaylist;
    @FindBy(xpath = "//*[@id='sidebar']/section[1]/ul/li[3]/a")
    private WebElement allSongsElement;
    @FindBy(xpath = "//th[@class='title']")
    private WebElement songTitleElement;


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
    public boolean confirmSongIsAdded(){
        return firstSong.isDisplayed();
    }
    public void dropToAddSong(){
        WebElement source = driver.findElement(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
        WebElement target = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        actions.dragAndDrop(source, target).build().perform();

    }
    public void sortSongs(){
        List<WebElement> songTitleList = driver.findElements(By.xpath("//div/table/tr/td[@class='title']"));
        List<WebElement> filteredList = songTitleList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(songTitleList.equals(filteredList));

    }

}