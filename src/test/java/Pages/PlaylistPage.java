package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
public PlaylistPage chooseThePlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']//a[contains(text(),'Med23')]"))).click();
        return this;
 }
 public PlaylistPage DeletePlaylist(){
wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='del btn-delete-playlist']"))).click();
     return this;
 }
 public boolean notificationDeletedPlaylist(){
       WebElement notificationIsDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.success.show")));
     return notificationIsDisplayed.isDisplayed();
 }
}
