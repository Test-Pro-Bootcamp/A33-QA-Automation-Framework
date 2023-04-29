package K_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {
    @FindBy (css = ".playlist:nth-child(3)")
    protected WebElement playlistLocator;
    @FindBy (css = "input[name='name']")
    public WebElement playlistInputFieldLocator;

    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    public void doubleClickOnPlaylist () {
        doubleClick(playlistLocator);
    }

    public void enterPlaylistNewName (String playlistName) {
        playlistInputFieldLocator.sendKeys((Keys.chord(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE))));
        playlistInputFieldLocator.sendKeys(playlistName);
        playlistInputFieldLocator.sendKeys(Keys.ENTER);

    }

    public void openPlaylist () {
        driver.findElement((By) playlistLocator).click();
    }


    public static boolean doesPlaylistExist (String playlistName) {
        WebElement playlistElement= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + playlistName + "']")));
//        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }


}
