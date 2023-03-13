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

public class RecentlyPage extends BasePage{

    @FindBy(css = "#recentlyPlayedWrapper [class='song-item']:nth-child(1)")
    WebElement firstSong;

    @FindBy(css = "button[data-testid='home-view-all-recently-played-btn']")
    WebElement viewAllBtnLocator;

    @FindBy(css = "button[class='btn-add-to']")
    WebElement addToLocator;


    public RecentlyPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void playFirstSong() {
        actions.doubleClick(firstSong).perform();
    }

    public void clickFirstSong() {
        firstSong.click();
    }

    public void clickViewAll() { viewAllBtnLocator.click(); }

    public void addToBtn() { addToLocator.click(); }

    public void clickPlaylistfromAddto(String searchText) {
        WebElement playlistAddto = driver.findElement(By.xpath("//*[@id='recentlyPlayedWrapper'] //li[contains(text(),'" + searchText + "')]"));
        playlistAddto.click();
    }

}
