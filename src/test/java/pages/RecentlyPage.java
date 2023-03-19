package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.List;

public class RecentlyPage extends BasePage{

    @FindBy(css = "#recentlyPlayedWrapper [class='song-item']:nth-child(1)")
    private WebElement firstSong;

    @FindBy(xpath = "//button[contains(text(),'View All')]")
    //@FindBy(xpath = "//a[@href='#!/recently-played']")
    //@FindBy(css = "button[data-testid='home-view-all-recently-played-btn']")
    private WebElement viewAllBtnLocator;

    @FindBy(xpath = "//*[@id='playlists']  //li[@class='playlist recently-played'] //a[@href='#!/recently-played']")
    private WebElement recentlyPlaylist;

    @FindBy(css = "li[class='has-sub']")
    private WebElement addtoContextmenu;

    @FindBy(xpath = "//li[@class='has-sub'] //li[@class='playlist']")
    private List<WebElement> addtoPlaylistmenu;

    @FindBy(css = "button[class='btn-add-to']")
    private WebElement addToLocator;

    public RecentlyPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public RecentlyPage playFirstSong() {
        wait.until(ExpectedConditions.elementToBeClickable((firstSong)));
        actions.doubleClick(firstSong).perform();
        return this;
    }

    public RecentlyPage openRecently() {
        wait.until(ExpectedConditions.elementToBeClickable((recentlyPlaylist)));
        recentlyPlaylist.click();
        //driver.get(koelSongs);
        return this;
    }

    public RecentlyPage clickFirstSong() {
        wait.until(ExpectedConditions.elementToBeClickable((firstSong)));
        firstSong.click();
        return this;
    }
    public RecentlyPage clickViewAll() {
        wait.until(ExpectedConditions.visibilityOf(viewAllBtnLocator));
        wait.until(ExpectedConditions.elementToBeClickable((viewAllBtnLocator)));
        viewAllBtnLocator.click();
        return this;
    }

    public RecentlyPage songContextMenu() {
        wait.until(ExpectedConditions.visibilityOf(firstSong));
        wait.until(ExpectedConditions.elementToBeClickable((firstSong)));
        actions.contextClick(firstSong).perform();
        return this;
    }

    public RecentlyPage addtoContextMenu() {
        wait.until(ExpectedConditions.visibilityOf(addtoContextmenu));
        wait.until(ExpectedConditions.elementToBeClickable((addtoContextmenu)));
        addtoContextmenu.click();
        return this;
    }

    public RecentlyPage addtoPlaylistMenu(String searchText) {
        for (WebElement locator : addtoPlaylistmenu) {
            if (locator.getText().contains(searchText)) {
                locator.click();
                break;
            }
        }
        return this;
    }


    public RecentlyPage addToBtn() {
        wait.until(ExpectedConditions.elementToBeClickable((addToLocator)));
        addToLocator.click();
        return this;
    }

    public RecentlyPage clickPlaylistfromAddto(String searchText) {
        WebElement playlistAddto = driver.findElement(By.xpath("//*[@id='recentlyPlayedWrapper'] //li[contains(text(),'" + searchText + "')]"));
        wait.until(ExpectedConditions.elementToBeClickable((playlistAddto)));
        playlistAddto.click();
        return this;
    }

}
