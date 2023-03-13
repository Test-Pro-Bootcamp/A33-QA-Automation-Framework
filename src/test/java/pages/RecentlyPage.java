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
    private WebElement firstSong;

    @FindBy(css = "button[data-testid='home-view-all-recently-played-btn']")
    private WebElement viewAllBtnLocator;

    @FindBy(css = "button[class='btn-add-to']")
    private WebElement addToLocator;

    public RecentlyPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public RecentlyPage playFirstSong() {
        actions.doubleClick(firstSong).perform();
        return this;
    }

    public RecentlyPage clickFirstSong() {
        firstSong.click();
        return this;
    }

    public RecentlyPage clickViewAll() {
        viewAllBtnLocator.click();
        return this;
    }

    public RecentlyPage addToBtn() {
        addToLocator.click();
        return this;
    }

    public RecentlyPage clickPlaylistfromAddto(String searchText) {
        WebElement playlistAddto = driver.findElement(By.xpath("//*[@id='recentlyPlayedWrapper'] //li[contains(text(),'" + searchText + "')]"));
        playlistAddto.click();
        return this;
    }

}
