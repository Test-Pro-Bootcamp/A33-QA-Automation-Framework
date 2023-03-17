package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
 By playlistElementLocator = By.cssSelector(".playlist:nth-child(3)");
 By inputPlaylistFieldLocator = By.cssSelector("input[name='name']");
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void doubleClickPlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlistElementLocator));
        WebElement playlistElement = driver.findElement(playlistElementLocator);
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){

        WebElement inputPlaylistField =wait.until(ExpectedConditions.elementToBeClickable
                (inputPlaylistFieldLocator));
        inputPlaylistField.sendKeys(Keys.COMMAND + "a");
        inputPlaylistField.sendKeys(Keys.DELETE);
        inputPlaylistField.sendKeys(playlistName);
        inputPlaylistField.sendKeys(Keys.ENTER);
    }
    public boolean checkNewPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//a[text()= '" +playlistName+"']")));
        return playlistElement.isDisplayed();

    }

}
